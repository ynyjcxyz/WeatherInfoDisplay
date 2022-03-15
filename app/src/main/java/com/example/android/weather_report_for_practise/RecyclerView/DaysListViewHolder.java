package com.example.android.weather_report_for_practise.RecyclerView;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.Animations;
import com.example.android.weather_report_for_practise.DataModel.Day;
import com.example.android.weather_report_for_practise.DataModel.DayWrapper;
import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.Util.AppConstants;
import com.example.android.weather_report_for_practise.R;

import java.util.List;

public class DaysListViewHolder extends RecyclerView.ViewHolder{
    LinearLayout layout_un_expand,layout_expand;
    TextView datetime_daily,conditions_daily,temp_max_daily,temp_min_daily,
            windspeed_daily,humidity_daily,precipprob_daily,sunrise_sunset;
    ImageView icon_by_daily;
    RecyclerView hourly_list_expand;

    public DaysListViewHolder(View itemView) {
        super(itemView);
        layout_un_expand = itemView.findViewById(R.id.list_item_un_expand);
        datetime_daily = itemView.findViewById(R.id.datetime_daily);
        conditions_daily = itemView.findViewById(R.id.conditions_daily);
        temp_max_daily = itemView.findViewById(R.id.temp_max_daily);
        temp_min_daily = itemView.findViewById(R.id.temp_min_daily);
        icon_by_daily = itemView.findViewById(R.id.icon_by_daily);

        layout_expand = itemView.findViewById(R.id.layout_expand);

        windspeed_daily = itemView.findViewById(R.id.windspeed_daily);
        humidity_daily = itemView.findViewById(R.id.humidity_daily);
        precipprob_daily = itemView.findViewById(R.id.precipprob_daily);
        sunrise_sunset = itemView.findViewById(R.id.sunrise_sunset);

        hourly_list_expand = itemView.findViewById(R.id.hourly_list_expand);
    }

    @SuppressLint("SetTextI18n")
    public void bindData(DayWrapper wrapper) {
        Day dayModel = wrapper.getDay();
        datetime_daily.setText(wrapper.getDay().datetime_daily());
        temp_max_daily.setText(wrapper.getDay().tempmax_daily() + "\u2103 \u21E1");
        temp_min_daily.setText(wrapper.getDay().tempmin_daily() + "\u2103 \u21E3");
        conditions_daily.setText(wrapper.getDay().conditions_daily());
        Glide.with(itemView.getContext())
                .load(AppConstants.iconBaseUrl
                        + AppConstants.second_set_color
                        + wrapper.getDay().icon_daily() + ".png")
                .into(icon_by_daily);

        windspeed_daily.setText(wrapper.getDay().windspeed_daily()+"km/h");
        humidity_daily.setText(wrapper.getDay().humidity_daily()+"%");
        precipprob_daily.setText(wrapper.getDay().precipprob_daily()+"%");
        sunrise_sunset.setText(wrapper.getDay().sunrise_daily() + "," + wrapper.getDay().sunset_daily());
        bindExpandAction(new DayWrapper(dayModel,false));
    }

    private void bindExpandAction(DayWrapper dayWrapper) {
        layout_un_expand.setOnClickListener(view -> onItemToggled(dayWrapper));

        hourly_list_expand.setHasFixedSize(true);
        hourly_list_expand.addItemDecoration(new DividerItemDecoration(itemView.getContext(), DividerItemDecoration.HORIZONTAL));
        hourly_list_expand.setLayoutManager(new LinearLayoutManager(itemView.getContext(),RecyclerView.HORIZONTAL,false));
        hourly_list_expand.setAdapter(new HourlyListRecyclerViewAdapter(hourly(dayWrapper)));
    }

    private List<Hour> hourly(DayWrapper dayWrapper) {
        return dayWrapper.getDay().weather_list_by_hours();
    }

    private void onItemToggled(DayWrapper daysWrapperModel) {
        boolean isExpanded = !daysWrapperModel.isExpanded();
        if (isExpanded) {
            Animations.expand(layout_expand);
            Animations.setTextBold(datetime_daily);
        } else {
            Animations.collapse(layout_expand);
            Animations.setTextNormal(datetime_daily);
        }
        daysWrapperModel.setExpanded(isExpanded);
    }

}
