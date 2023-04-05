package com.example.findopenwifi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistory {
    private int id;
    private Double xValue;
    private Double yValue;
    private String searchDateTime;
    private String dataDelYn;
}
