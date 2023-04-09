package com.example.findopenwifi.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchHistoryDTO {

    private int id;
    private double xValue;
    private double yValue;
    private String searchDateTime;
}
