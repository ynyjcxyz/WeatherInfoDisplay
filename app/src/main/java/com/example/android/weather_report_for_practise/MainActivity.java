package com.example.android.weather_report_for_practise;

import static com.example.android.weather_report_for_practise.DtoRepository.getDto;
import static com.uber.autodispose.AutoDispose.autoDisposable;
import static com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.from;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.example.android.weather_report_for_practise.DataModel.Dto;
import com.example.android.weather_report_for_practise.Util.AppConstants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        initListener();
        loadData();
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void loadData() {
        getDto(AppConstants.PARAM)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(autoDisposable(from(this)))
                .subscribe(this::onSuccess, this::onError);
    }

    private void onError(Throwable throwable) {
        System.out.println(throwable);
        throwable.printStackTrace();
        throw new RuntimeException(throwable);
    }

    private void onSuccess(Dto dto) {
        bindViewPagerWithData(dto);
        this.setTitle(dto.resolvedAddress());
    }

    private void bindViewPagerWithData(Dto dto) {
        viewPager.setAdapter(new ScreenSlidePagerAdapter(this,dto));
        viewPager.setCurrentItem(0);
        bindTab();
    }

    private void bindTab() {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                tab.setText(AppConstants.fragmentTitles[position])).attach();
    }


}