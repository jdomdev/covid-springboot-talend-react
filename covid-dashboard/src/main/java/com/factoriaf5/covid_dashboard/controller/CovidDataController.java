package com.factoriaf5.covid_dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factoriaf5.covid_dashboard.dto.CovidDataDto;
import com.factoriaf5.covid_dashboard.service.CovidDataService;

@RestController
@RequestMapping("/api/v1/covid-data")
@CrossOrigin(origins = "*")
public class CovidDataController {

    private final CovidDataService covidDataService;

    @Autowired
    public CovidDataController(CovidDataService covidDataService) {
        this.covidDataService = covidDataService;
    }

    @GetMapping
    public List<CovidDataDto> getAll() {
        return covidDataService.getAll();
    }

    @GetMapping("/{country}")
    public List<CovidDataDto> getByCountry(@PathVariable String country) {
        return covidDataService.findByCountry(country);
    }
}
