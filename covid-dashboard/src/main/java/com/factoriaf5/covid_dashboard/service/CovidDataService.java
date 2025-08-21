package com.factoriaf5.covid_dashboard.service;

import java.util.List;

import com.factoriaf5.covid_dashboard.dto.CovidDataDto;

public interface CovidDataService {
    List<CovidDataDto> getAll();
}
