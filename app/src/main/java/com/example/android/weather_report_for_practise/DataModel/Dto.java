package com.example.android.weather_report_for_practise.DataModel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;


@GenerateTypeAdapter
@AutoValue

public abstract class Dto implements Parcelable{
    @SerializedName("resolvedAddress")
    public abstract String resolvedAddress();

    @SerializedName("description")
    public abstract String description();

    @SerializedName("days")
    public abstract List<Day> weather_list_by_days();

    @SerializedName("currentConditions")
    public abstract CurrentConditions currentConditions();
}