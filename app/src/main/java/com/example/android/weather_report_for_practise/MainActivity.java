package com.example.android.weather_report_for_practise;

import static android.widget.Toast.LENGTH_LONG;
import static com.example.android.weather_report_for_practise.DtoRepository.getDto;
import static com.uber.autodispose.AutoDispose.autoDisposable;
import static com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.from;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.android.weather_report_for_practise.DataModel.Dto;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView description,datetime,temp,humidity,conditions;
    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadData();
    }

    private void initView() {
        description = findViewById(R.id.description);
        datetime = findViewById(R.id.datetime);
        temp = findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        conditions = findViewById(R.id.conditions);
        icon = findViewById(R.id.icon);
    }

    private void loadData() {
        getDto(ParameterClass.PARAM)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(autoDisposable(from(this)))
                .subscribe(this::onSuccess, this::onError);
    }

    private void onError(Throwable throwable) {
        System.out.println(throwable);
//        throwable.printStackTrace();
//        throw new RuntimeException(throwable);
        Toast.makeText(getApplication(), throwable.getMessage(), LENGTH_LONG).show();
    }

    private void onSuccess(Dto dto) {
        this.setView(dto);
        setTitle(dto.resolvedAddress());
    }

    @SuppressLint("SetTextI18n")
    private void setView(Dto dto) {
        description.setText(dto.description());
        datetime.setText("DataTime: " + dto.currentConditions().datetime_by_current());
        temp.setText(dto.currentConditions().temp_by_current() + "\u2103");
        humidity.setText("Current Humidity: "+ dto.currentConditions().humidity_by_current() +"%");
        conditions.setText("Current Condition: " + dto.currentConditions().conditions_by_current());
        Glide.with(this)
                .load(ParameterClass.iconBaseUrl
                        + ParameterClass.fourth_set_color
                        + dto.currentConditions().icon_by_current()
                        + ".png")
                .override(64,64)
                .into(icon);
    }
}