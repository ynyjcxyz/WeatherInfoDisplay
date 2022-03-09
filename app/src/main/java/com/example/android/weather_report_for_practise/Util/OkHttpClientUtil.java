package com.example.android.weather_report_for_practise.Util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientUtil {
    public static OkHttpClient buildOkHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor
                        (new HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();
    }
}
