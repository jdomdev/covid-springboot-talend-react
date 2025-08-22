package com.factoriaf5.covid_dashboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.factoriaf5.covid_dashboard.dto.CovidDataDto;
import com.factoriaf5.covid_dashboard.service.CovidDataService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;


@WebMvcTest(CovidDataController.class)
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration")
public class CovidDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CovidDataService covidDataService;

    @MockBean
    private MongoTemplate mongoTemplate; // Mock MongoTemplate to prevent actual DB connection

    @MockBean
    private GridFsTemplate gridFsTemplate; // Mock GridFsTemplate to prevent its auto-configuration issues

    @Test
    public void getAll_ShouldReturnListOfCovidData() throws Exception {
        // Given
        CovidDataDto covidDataDto = new CovidDataDto("2024-01-01", "Testland", 100, 5, 95);
        when(covidDataService.getAll()).thenReturn(List.of(covidDataDto));

        // When & Then
        mockMvc.perform(get("/api/v1/covid-data"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].country", is("Testland")))
                .andExpect(jsonPath("$[0].cases", is(100)));
    }
}
