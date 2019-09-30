package com.djac21.haystax.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.djac21.haystax.R;
import com.djac21.haystax.api.APIClient;
import com.djac21.haystax.api.APIInterface;
import com.djac21.haystax.model.LoginModel;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String cookies = "";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        if (!sharedPreferences.getString("Cookies", "").equals("")) {
            startActivity(new Intent(MainActivity.this, IncidentsListActivity.class));
            finish();
        }
    }

    public void login() {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void, Void, Void> login = new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("email", "mobilehaystax@gmail.com");
                jsonObject.addProperty("password", "haystax123!");

                Log.d(TAG, "JSON Object: " + jsonObject);

                APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                Call<LoginModel> call = apiInterface.login(jsonObject);
                call.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        if (response.isSuccessful()) {
                            Headers headerResponse = response.headers();
                            Map<String, List<String>> headerMapList = headerResponse.toMultimap();
                            List<String> allCookies = headerMapList.get("Set-Cookie");

                            for (int i = 0; i < allCookies.size(); i++) {
                                allCookies.get(i);
                                cookies = cookies + allCookies.get(i);
                            }

                            sharedPreferences.edit().putString("Cookies", cookies).apply();
                            Log.i(TAG, "onResponse: " + cookies);

                            startActivity(new Intent(MainActivity.this, IncidentsListActivity.class));
                            finish();
                        } else {
                            Log.e(TAG, "Response Message: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {

                    }
                });
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
            }
        };
        login.execute(null, null, null);
    }
}