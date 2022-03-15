package com.example.android.weather_report_for_practise.DataModel;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue

public abstract class Day implements Parcelable {
    @SerializedName("datetime")
    public abstract String datetime_daily();//from today to today+14,like:2022-03-09

    @SerializedName("tempmax")
    public abstract double tempmax_daily();

    @SerializedName("tempmin")
    public abstract double tempmin_daily();

    @SerializedName("conditions")
    public abstract String conditions_daily();

    @SerializedName("icon")
    public abstract String icon_daily();

    @SerializedName("windspeed")
    public abstract double windspeed_daily();

    @SerializedName("humidity")
    public abstract double humidity_daily();

    @SerializedName("precipprob")
    public abstract double precipprob_daily();

    @SerializedName("sunrise")
    public abstract String sunrise_daily();

    @SerializedName("sunset")
    public abstract String sunset_daily();

    @SerializedName("hours")
    public abstract List<Hour> weather_list_by_hours();
}
