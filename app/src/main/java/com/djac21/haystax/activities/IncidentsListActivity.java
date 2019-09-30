package com.djac21.haystax.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.djac21.haystax.R;
import com.djac21.haystax.Utils.Utils;
import com.djac21.haystax.adapters.IncidentListAdapter;
import com.djac21.haystax.api.APIClient;
import com.djac21.haystax.api.APIInterface;
import com.djac21.haystax.model.IncidentListViewModel;
import com.djac21.haystax.model.IncidentsListModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IncidentsListActivity extends AppCompatActivity {

    private static final String TAG = IncidentsListActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private TextView errorText;
    private Button retryButton;
    private IncidentListAdapter incidentListAdapter;
    private ProgressBar progressBar;
    private ArrayList<IncidentsListModel.Incidents> articleArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidents_list);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.progressBar);
        errorText = findViewById(R.id.errorText);
        retryButton = findViewById(R.id.retryButton);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIncidentView();
            }
        });

        String cookies = sharedPreferences.getString("Cookies", "");

        if (cookies.equals("")) {
            new Utils(getApplicationContext()).goLoginActivity(IncidentsListActivity.this);
        } else {
            IncidentListViewModel incidentListViewModel = ViewModelProviders.of(this).get(IncidentListViewModel.class);
            incidentListViewModel.init(cookies);
            incidentListViewModel.getIncidentsRepository().observe(this, new Observer<IncidentsListModel>() {
                @Override
                public void onChanged(IncidentsListModel incidentResponse) {
                    if (incidentResponse != null) {
                        articleArrayList.addAll(incidentResponse.getIncidents());
                        setIncidentView();
                    }
                }
            });
        }
    }

    public MutableLiveData<IncidentsListModel> getNews(String cookies) {
        final MutableLiveData<IncidentsListModel> incidentsListModel = new MutableLiveData<>();
        APIClient.getClient().create(APIInterface.class).getIncidents(cookies).enqueue(new Callback<IncidentsListModel>() {
            @Override
            public void onResponse(Call<IncidentsListModel> call, Response<IncidentsListModel> response) {
                if (response.isSuccessful()) {
                    incidentsListModel.setValue(response.body());
                } else if (response.code() == 401 || response.code() == 403) {
                    errorOnResponse(true);
                } else {
                    Log.e(TAG, "onResponse: " + response.code());
                    incidentsListModel.setValue(null);
                    errorOnResponse(false);
                }
            }

            @Override
            public void onFailure(Call<IncidentsListModel> call, Throwable t) {
                t.printStackTrace();
                incidentsListModel.setValue(null);
            }
        });
        return incidentsListModel;
    }

    private void setIncidentView() {
        if (incidentListAdapter == null) {
            errorText.setVisibility(View.GONE);
            retryButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            incidentListAdapter = new IncidentListAdapter(getApplicationContext(), articleArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(incidentListAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        } else {
            incidentListAdapter.notifyDataSetChanged();
            errorOnResponse(false);
        }
    }

    private void errorOnResponse(boolean logout) {
        Log.e(TAG, "errorOnResponse");

        if (logout)
            new Utils(getApplicationContext()).goLoginActivity(IncidentsListActivity.this);

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        errorText.setVisibility(View.VISIBLE);
        retryButton.setVisibility(View.VISIBLE);
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

        if (id == R.id.logout) {
            new Utils(getApplicationContext()).logout(IncidentsListActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}