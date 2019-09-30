package com.djac21.haystax.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.djac21.haystax.R;
import com.djac21.haystax.Utils.Utils;
import com.djac21.haystax.api.APIClient;
import com.djac21.haystax.api.APIInterface;
import com.djac21.haystax.model.IncidentImageModel;
import com.djac21.haystax.model.IncidentDetailModel;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class IncidentDetailActivity extends AppCompatActivity {
    private static final String TAG = IncidentDetailActivity.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private CompositeDisposable disposable = new CompositeDisposable();
    private String cookies, incidentID;
    private TextView title, date, summary;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        incidentID = getIntent().getStringExtra("ID");
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        summary = findViewById(R.id.summary);
        image = findViewById(R.id.image);

        cookies = sharedPreferences.getString("Cookies", "");
        if (cookies.equals("")) {
            new Utils(getApplicationContext()).goLoginActivity(IncidentDetailActivity.this);
        } else {
            getDetails();
            getDetailsImage();
        }
    }

    private void getDetails() {
        disposable.add(
                APIClient.getClient().create(APIInterface.class).getIncident(cookies, incidentID)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<IncidentDetailModel>() {
                            @Override
                            public void onSuccess(IncidentDetailModel incidentDetailModel) {
                                title.setText(incidentDetailModel.getTitle());
                                date.setText(Utils.prettyTime(incidentDetailModel.getOverview().getDate()));
                                summary.setText(incidentDetailModel.getDetails().getSummary().replaceAll("\\<[^>]*>", ""));
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError Details: " + e.getMessage());
                                new Utils(getApplicationContext()).goLoginActivity(IncidentDetailActivity.this);
                            }
                        })
        );
    }

    private void getDetailsImage() {
        disposable.add(
                APIClient.getClient().create(APIInterface.class).getImage(cookies, incidentID)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<IncidentImageModel>() {
                            @Override
                            public void onSuccess(IncidentImageModel incidentImageModel) {
                                String encodedString = incidentImageModel.getFiles().get(0).getFile_small();
                                final String pureBase64Encoded = encodedString.substring(encodedString.indexOf(",") + 1);
                                final byte[] decodedBytes = Base64.decode(pureBase64Encoded, Base64.DEFAULT);

                                Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
                                image.setImageBitmap(decodedBitmap);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError Image: " + e.getMessage());
                                new Utils(getApplicationContext()).goLoginActivity(IncidentDetailActivity.this);
                            }
                        })
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        } else if (id == R.id.logout) {
            new Utils(getApplicationContext()).logout(IncidentDetailActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}