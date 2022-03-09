package com.example.android.weather_report_for_practise;

public class RequestParam {
    String cityName;
    String unitGroup;
    String key;
    String contentType;

    public RequestParam(String cityName,
                        String unitGroup,
                        String key,
                        String contentType) {
        this.cityName = cityName;
        this.unitGroup = unitGroup;
        this.key = key;
        this.contentType = contentType;
    }
}
