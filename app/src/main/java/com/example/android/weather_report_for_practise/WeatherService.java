package com.example.android.weather_report_for_practise;

import com.example.android.weather_report_for_practise.DataModel.Dto;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("VisualCrossingWebServices/rest/services/timeline/{cityName}")
    Observable<Dto>getDto(@Path("cityName") String cityName,//Seattle
                          @Query("unitGroup") String unitGroup,//metric
                          @Query("key") String key,//UDR74JLWCB3CRZBZQSTL3AVQH
                          @Query("contentType") String contentType);//json
}