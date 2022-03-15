package com.example.android.weather_report_for_practise.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.DataModel.CurrentConditions;
import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.Util.AppConstants;
import com.example.android.weather_report_for_practise.R;
import com.example.android.weather_report_for_practise.RecyclerView.HourlyListRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class CurrentFragment extends Fragment {
    private TextView datetime,temp,humidity,conditions;
    private ImageView icon;
    private CurrentConditions currentWeather;
    private List<Hour> todayWeatherInfoByHours = new ArrayList<>();

    private RecyclerView recyclerView;
    private HourlyListRecyclerViewAdapter recyclerAdapter;

    public static CurrentFragment constructCurrentFragment(CurrentConditions currentConditions,
                                                           List<Hour> weather_list_by_hours){
        CurrentFragment currentFragment = new CurrentFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("currentConditions",currentConditions);
        bundle1.putParcelableArrayList("weather_list_by_hours", new ArrayList<>(weather_list_by_hours));
        currentFragment.setArguments(bundle1);
        return currentFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_current, container, false);
        initView(rootView);
        loadData(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        datetime = rootView.findViewById(R.id.datetime_current);
        temp = rootView.findViewById(R.id.temp_current);
        humidity = rootView.findViewById(R.id.humidity_current);
        conditions = rootView.findViewById(R.id.conditions_current);
        icon = rootView.findViewById(R.id.icon_current);

        recyclerView = rootView.findViewById(R.id.recyclerview_today_hourly);
    }

    @SuppressLint("SetTextI18n")
    private void loadData(View rootView) {
        currentWeather = requireArguments().getParcelable("currentConditions");
        todayWeatherInfoByHours = requireArguments().getParcelableArrayList("weather_list_by_hours");

        datetime.setText("DataTime: " + currentWeather.datetime_by_current());
        temp.setText(currentWeather.temp_by_current() + "\u2103");
        humidity.setText("Current Humidity: "+ currentWeather.humidity_by_current() +"%");
        conditions.setText("Current Condition: " + currentWeather.conditions_by_current());
        Glide.with(this)
                .load(AppConstants.iconBaseUrl
                        + AppConstants.fourth_set_color
                        + currentWeather.icon_by_current()
                        + ".png")
                .override(64,64)
                .into(icon);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerAdapter = new HourlyListRecyclerViewAdapter(todayWeatherInfoByHours);
        recyclerView.setAdapter(recyclerAdapter);
    }
}