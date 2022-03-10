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
import com.example.android.weather_report_for_practise.DataModel.Day;
import com.example.android.weather_report_for_practise.DataModel.Hour;
import com.example.android.weather_report_for_practise.ParameterClass;
import com.example.android.weather_report_for_practise.R;
import com.example.android.weather_report_for_practise.RecyclerView.RecyclerViewAdapterForHourlyList;

import java.util.ArrayList;
import java.util.List;

public class TomorrowFragment extends Fragment {
    private TextView datetime_tomorrow,temp_max_tomorrow,temp_min_tomorrow,conditions_tomorrow;
    private ImageView icon_tomorrow;
    private Day dataTomorrow;
    private List<Hour> tomorrowWeatherInfoByHours = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerViewAdapterForHourlyList recyclerAdapter;

    public static TomorrowFragment constructTomorrowFragment(Day dataOfTomorrow){
        TomorrowFragment tomorrowFragment = new TomorrowFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("dataOfTomorrow",dataOfTomorrow);
        tomorrowFragment.setArguments(bundle2);
        return tomorrowFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_tomorrow, container, false);
        initView(rootView);
        loadData(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        datetime_tomorrow = rootView.findViewById(R.id.datetime_tomorrow);
        temp_max_tomorrow = rootView.findViewById(R.id.temp_max_tomorrow);
        temp_min_tomorrow = rootView.findViewById(R.id.temp_min_tomorrow);
        conditions_tomorrow = rootView.findViewById(R.id.conditions_tomorrow);
        icon_tomorrow = rootView.findViewById(R.id.icon_tomorrow);

        recyclerView = rootView.findViewById(R.id.recyclerview_tomorrow_hourly);
    }

    @SuppressLint("SetTextI18n")
    private void loadData(View rootView) {
        dataTomorrow = requireArguments().getParcelable("dataOfTomorrow");
        tomorrowWeatherInfoByHours = dataTomorrow.weather_list_by_hours();

        datetime_tomorrow.setText(dataTomorrow.datetime_daily());
        temp_max_tomorrow.setText(dataTomorrow.tempmax_daily() + "\u2103 \u21E1");
        temp_min_tomorrow.setText(dataTomorrow.tempmin_daily() + "\u2103 \u21E3");
        conditions_tomorrow.setText(dataTomorrow.conditions_daily());
        Glide.with(this)
                .load(ParameterClass.iconBaseUrl
                        + ParameterClass.second_set_color
                        + dataTomorrow.icon_daily()
                        + ".png")
                .override(64,64)
                .into(icon_tomorrow);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerAdapter = new RecyclerViewAdapterForHourlyList(rootView.getContext(),tomorrowWeatherInfoByHours);
        recyclerView.setAdapter(recyclerAdapter);
    }

}