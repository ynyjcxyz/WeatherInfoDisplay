package com.example.android.weather_report_for_practise.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.weather_report_for_practise.R;

public class ViewHolderForDaysList extends RecyclerView.ViewHolder{
    LinearLayout parent_layout;
    TextView datetime_daily,conditions_daily,temp_max_daily,temp_min_daily;
    ImageView icon_by_daily;

    public ViewHolderForDaysList(@NonNull View itemView) {
        super(itemView);
        parent_layout = itemView.findViewById(R.id.list_item_daily);
        datetime_daily = itemView.findViewById(R.id.datetime_daily);
        conditions_daily = itemView.findViewById(R.id.conditions_daily);
        temp_max_daily = itemView.findViewById(R.id.temp_max_daily);
        temp_min_daily = itemView.findViewById(R.id.temp_min_daily);
        icon_by_daily = itemView.findViewById(R.id.icon_by_daily);
    }
}
