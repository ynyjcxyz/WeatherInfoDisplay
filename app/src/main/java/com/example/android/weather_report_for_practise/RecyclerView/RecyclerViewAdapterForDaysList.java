package com.example.android.weather_report_for_practise.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.DataModel.Day;
import com.example.android.weather_report_for_practise.ParameterClass;
import com.example.android.weather_report_for_practise.R;

import java.util.List;

public class RecyclerViewAdapterForDaysList extends RecyclerView.Adapter<ViewHolderForDaysList>{
    private final Context context;
    private final List<Day> itemList;

    public RecyclerViewAdapterForDaysList(Context context, List<Day> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolderForDaysList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderForDaysList
                (LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_daily, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderForDaysList holder, int position) {
        holder.datetime_daily.setText(itemList.get(position).datetime_daily());
        holder.temp_max_daily.setText(itemList.get(position).tempmax_daily() + "\u2103 \u21E1");
        holder.temp_min_daily.setText(itemList.get(position).tempmin_daily() + "\u2103 \u21E3");
        holder.conditions_daily.setText(itemList.get(position).conditions_daily());
        Glide.with(context)
                .load(ParameterClass.iconBaseUrl + ParameterClass.second_set_color + itemList.get(position).icon_daily() + ".png")
                .into(holder.icon_by_daily);
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}
