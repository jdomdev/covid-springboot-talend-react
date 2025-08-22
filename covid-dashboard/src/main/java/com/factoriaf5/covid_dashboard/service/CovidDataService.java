package com.factoriaf5.covid_dashboard.service;

import com.factoriaf5.covid_dashboard.dto.CovidDataDto;
import java.util.List;

public interface CovidDataService {
    List<CovidDataDto> getAll();
}
