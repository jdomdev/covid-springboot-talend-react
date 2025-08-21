package com.factoriaf5.covid_dashboard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factoriaf5.covid_dashboard.domain.CovidData;
import com.factoriaf5.covid_dashboard.dto.CovidDataDto;
import com.factoriaf5.covid_dashboard.repository.CovidDataRepository;

@Service
public class CovidDataServiceImpl implements CovidDataService {

    private CovidDataRepository covidDataRepository;

    @Autowired
    public CovidDataServiceImpl(CovidDataRepository covidDataRepository) {
        this.covidDataRepository = covidDataRepository;
    }

    @Override
    public List<CovidDataDto> getAll() {
        List<CovidData> covidDataList = covidDataRepository.findAll();
        return covidDataList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CovidDataDto convertToDto(CovidData covidData) {
        return new CovidDataDto(
                covidData.getId(),
                covidData.getDate(),
                covidData.getCountry(),
                covidData.getRegion(),
                covidData.getCases(),
                covidData.getDeaths(),
                covidData.getRecovered());
    }
}
