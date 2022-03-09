package com.example.android.weather_report_for_practise.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue

public abstract class CurrentConditions implements Parcelable{
    @SerializedName("datetime")
    public abstract String datetime_by_current();//like:15:48:17

    @SerializedName("temp")
    public abstract double temp_by_current();

    @SerializedName("humidity")
    public abstract double humidity_by_current();

    @SerializedName("conditions")
    public abstract String conditions_by_current();

    @SerializedName("icon")
    public abstract String icon_by_current();
}