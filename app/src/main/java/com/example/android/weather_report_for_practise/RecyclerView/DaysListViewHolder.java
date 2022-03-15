package com.example.android.weather_report_for_practise.RecyclerView;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.AppConstants;
import com.example.android.weather_report_for_practise.DataModel.Day;
import com.example.android.weather_report_for_practise.R;

public class DaysListViewHolder extends RecyclerView.ViewHolder{
    LinearLayout parent_layout;
    TextView datetime_daily,conditions_daily,temp_max_daily,temp_min_daily;
    ImageView icon_by_daily;

    public DaysListViewHolder(@NonNull View itemView) {
        super(itemView);
        parent_layout = itemView.findViewById(R.id.list_item_daily);
        datetime_daily = itemView.findViewById(R.id.datetime_daily);
        conditions_daily = itemView.findViewById(R.id.conditions_daily);
        temp_max_daily = itemView.findViewById(R.id.temp_max_daily);
        temp_min_daily = itemView.findViewById(R.id.temp_min_daily);
        icon_by_daily = itemView.findViewById(R.id.icon_by_daily);
    }

    @SuppressLint("SetTextI18n")
    public void bindData(Day daysItem) {
        datetime_daily.setText(daysItem.datetime_daily());
        temp_max_daily.setText(daysItem.tempmax_daily() + "\u2103 \u21E1");
        temp_min_daily.setText(daysItem.tempmin_daily() + "\u2103 \u21E3");
        conditions_daily.setText(daysItem.conditions_daily());
        Glide.with(itemView.getContext())
                .load(AppConstants.iconBaseUrl + AppConstants.second_set_color + daysItem.icon_daily() + ".png")
                .into(icon_by_daily);
    }
}
