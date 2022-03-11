package com.example.android.weather_report_for_practise.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.AppConstants;
import com.example.android.weather_report_for_practise.R;

public class ViewHolderForHourlyList extends RecyclerView.ViewHolder {
    LinearLayout parent_layout;
    TextView temp_hourly, precipitation_hourly, humidity_hourly, wind_hourly, server_time_hourly;
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

    void bind(Hour hour) {
        temp_hourly.setText(hour.temp_hourly() + "\u2103");
        precipitation_hourly.setText(hour.precip_hourly() + "%");
        humidity_hourly.setText(hour.humidity_hourly() + "%");
        wind_hourly.setText(hour.windspeed_hourly() + "km/h");
        server_time_hourly.setText(hour.datetime_hourly());
        Glide
                .with(itemView.getContext())
                .load(formatUrl(hour))
                .into(icon_hourly);
    }

    private String formatUrl(Hour hour) {
        return AppConstants.iconBaseUrl
                + AppConstants.second_set_color
                + hour.icon_hourly()
                + ".png";
    }
}
