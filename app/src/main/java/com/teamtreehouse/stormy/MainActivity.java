package com.teamtreehouse.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    String apiKey = "57eaf3aa961968bf65b0619680588073";
    double latitude = 37.8267;
    double longitude = -122.423;

    String forecastURL = "https://api.forecast.io/forecast/"
        + apiKey + "/"
        + latitude + ","
        + longitude;

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
        .url(forecastURL)
        .build();

    Call call = client.newCall(request);

    try {
      Response response = call.execute();
      if (response.isSuccessful()) {
        Log.v(TAG, response.body().string());
      }
    } catch (IOException e) {
      Log.e(TAG, "IO Exception caught: ", e);
    }

  }
}
