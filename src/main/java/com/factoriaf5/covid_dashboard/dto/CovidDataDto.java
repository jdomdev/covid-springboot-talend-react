package com.factoriaf5.covid_dashboard.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidDataDto implements Serializable {
    private String id;
    private LocalDate date;
    private String country;
    private String region;
    private Integer cases;
    private Integer deaths;
    private Integer recovered;
}
