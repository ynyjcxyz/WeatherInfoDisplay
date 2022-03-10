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
        Fragment fragment = new Fragment();
        switch (position) {
            case 0:
                fragment = currentFragment();
                break;
            case 1:
                fragment = tomorrowFragment();
                break;
            case 2:
                fragment = daysFragment();
                break;
        }
        return fragment;
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
