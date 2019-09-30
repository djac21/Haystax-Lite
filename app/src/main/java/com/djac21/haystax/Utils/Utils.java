package com.djac21.haystax.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.djac21.haystax.activities.MainActivity;
import com.djac21.haystax.api.APIClient;
import com.djac21.haystax.api.APIInterface;
import com.djac21.haystax.model.LoginModel;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Utils {
    private static final String TAG = Utils.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private CompositeDisposable disposable = new CompositeDisposable();

    public Utils(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void logout(final Activity activity) {
        disposable.add(
                APIClient.getClient().create(APIInterface.class).logout()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<LoginModel>() {
                            @Override
                            public void onSuccess(LoginModel loginModel) {
                                goLoginActivity(activity);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError: " + e.getMessage());
                            }
                        })
        );
    }

    public static String prettyTime(String inputTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        long time = 0;
        try {
            time = simpleDateFormat.parse(inputTime).getTime();
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

        PrettyTime prettyTime = new PrettyTime(Locale.getDefault());
        return prettyTime.format(new Date(time));
    }

    public void goLoginActivity(Activity activity) {
        Toast.makeText(activity, "You have successfully been logged out", Toast.LENGTH_SHORT).show();

        sharedPreferences.edit().putString("Cookies", "").apply();

        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }
}