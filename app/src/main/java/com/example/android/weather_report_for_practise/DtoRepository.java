package com.example.android.weather_report_for_practise;

import static com.example.android.weather_report_for_practise.GetRetrofitObj.retrofitService;

import com.example.android.weather_report_for_practise.DataModel.Dto;

import io.reactivex.Observable;

public class DtoRepository {
    public static Observable<Dto> getDto(RequestParam requestParam) {
        return retrofitService().getDto(
                requestParam.cityName,
                requestParam.unitGroup,
                requestParam.key,
                requestParam.contentType);
    }
}
