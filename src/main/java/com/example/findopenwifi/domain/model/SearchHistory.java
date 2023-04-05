package com.example.findopenwifi.domain.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchHistory {
    private int id;
    private Double xValue;
    private Double yValue;
    private String searchDateTime;
    private String dataDelYn;

    private SearchHistory(Double xValue, Double yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public static SearchHistory of(Double xValue, Double yValue) {
        return new SearchHistory(xValue, yValue);
    }
}
