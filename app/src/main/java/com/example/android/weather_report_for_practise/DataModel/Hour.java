package com.example.android.weather_report_for_practise.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue

public abstract class Hour implements Parcelable {
    @SerializedName("datetime")
    public abstract String datetime_hourly();//00:00:00 to 23:00:00

    @SerializedName("temp")
    public abstract double temp_hourly();

    @SerializedName("humidity")
    public abstract double humidity_hourly();

    @SerializedName("precip")
    public abstract double precip_hourly();

    @SerializedName("windspeed")
    public abstract double windspeed_hourly();

    @SerializedName("icon")
    public abstract String icon_hourly();
}
