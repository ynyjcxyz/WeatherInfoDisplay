package com.example.android.weather_report_for_practise.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.ParameterClass;
import com.example.android.weather_report_for_practise.R;

import java.util.List;

public class RecyclerViewAdapterForHourlyList extends RecyclerView.Adapter<ViewHolderForHourlyList> {
    private final Context context;
    private final List<Hour> itemList;

    public RecyclerViewAdapterForHourlyList(Context context, List<Hour> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolderForHourlyList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForHourlyList
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_hourly, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderForHourlyList holder, int position) {
        holder.temp_hourly.setText(itemList.get(position).temp_hourly() + "\u2103");
        holder.precipitation_hourly.setText(itemList.get(position).precip_hourly() + "%");
        holder.humidity_hourly.setText(itemList.get(position).humidity_hourly() + "%");
        holder.wind_hourly.setText(itemList.get(position).windspeed_hourly() + "km/h");
        holder.server_time_hourly.setText(itemList.get(position).datetime_hourly());
        Glide
                .with(context)
                .load(ParameterClass.iconBaseUrl
                        + ParameterClass.second_set_color
                        + itemList.get(position).icon_hourly()
                        + ".png")
                .into(holder.icon_hourly);
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}