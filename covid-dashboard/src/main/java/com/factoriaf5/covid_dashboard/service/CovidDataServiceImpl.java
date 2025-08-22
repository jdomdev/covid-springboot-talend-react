package com.factoriaf5.covid_dashboard.service;

import com.factoriaf5.covid_dashboard.domain.CovidData;
import com.factoriaf5.covid_dashboard.dto.CovidDataDto;
import com.factoriaf5.covid_dashboard.repository.CovidDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.factoriaf5.covid_dashboard.exception.ResourceNotFoundException;

@Service
public class CovidDataServiceImpl implements CovidDataService {

    private final CovidDataRepository covidDataRepository;

    @Autowired
    public CovidDataServiceImpl(CovidDataRepository covidDataRepository) {
        this.covidDataRepository = covidDataRepository;
    }

    @Override
    public List<CovidDataDto> getAll() {
        List<CovidData> covidDataList = covidDataRepository.findAll();
        if (covidDataList.isEmpty()) {
            throw new ResourceNotFoundException("No COVID data found.");
        }
        return covidDataList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CovidDataDto convertToDto(CovidData covidData) {
        if (covidData == null) {
            return null;
        }
        String formattedDate = covidData.getDate() != null ? covidData.getDate().toString() : null;
        return new CovidDataDto(
                formattedDate,
                covidData.getCountry(),
                covidData.getCases(),
                covidData.getDeaths(),
                covidData.getRecovered()
        );
    }
}