package com.example.android.weather_report_for_practise;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.weather_report_for_practise.DataModel.Dto;
import com.example.android.weather_report_for_practise.Fragment.CurrentFragment;
import com.example.android.weather_report_for_practise.Fragment.DaysFragment;
import com.example.android.weather_report_for_practise.Fragment.TomorrowFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    private final Dto dto;

    public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity, Dto dto) {
        super(fragmentActivity);
        this.dto = dto;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return currentFragment();
            case 1:
                return tomorrowFragment();
            case 2:
                return daysFragment();
            default:
                throw new IllegalStateException("Do not support more than 3 items");
        }
    }

    private Fragment currentFragment() {
        return CurrentFragment.constructCurrentFragment(dto.currentConditions(),
                dto.weather_list_by_days().get(0).weather_list_by_hours());
    }

    private Fragment tomorrowFragment() {
        return TomorrowFragment.constructTomorrowFragment(dto.weather_list_by_days().get(1));
    }

    private Fragment daysFragment() {
        return DaysFragment.constructDaysFragment(dto.weather_list_by_days());
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
