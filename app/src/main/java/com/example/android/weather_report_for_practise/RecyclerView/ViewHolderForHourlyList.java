package com.example.android.weather_report_for_practise.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.weather_report_for_practise.R;

public class ViewHolderForHourlyList extends RecyclerView.ViewHolder{
    LinearLayout parent_layout;
    TextView temp_hourly,precipitation_hourly,humidity_hourly,wind_hourly,server_time_hourly;
    ImageView icon_hourly;
    public ViewHolderForHourlyList(@NonNull View itemView) {
        super(itemView);

        parent_layout = itemView.findViewById(R.id.list_item_hourly);
        temp_hourly = itemView.findViewById(R.id.temp_hourly);
        precipitation_hourly = itemView.findViewById(R.id.precipitation_hourly);
        humidity_hourly = itemView.findViewById(R.id.humidity_hourly);
        wind_hourly = itemView.findViewById(R.id.wind_hourly);
        server_time_hourly = itemView.findViewById(R.id.server_time_hourly);
        icon_hourly = itemView.findViewById(R.id.icon_hourly);
    }
}
