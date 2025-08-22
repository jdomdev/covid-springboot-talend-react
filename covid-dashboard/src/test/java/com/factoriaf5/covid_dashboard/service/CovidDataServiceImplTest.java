package com.factoriaf5.covid_dashboard.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.factoriaf5.covid_dashboard.domain.CovidData;
import com.factoriaf5.covid_dashboard.dto.CovidDataDto;
import com.factoriaf5.covid_dashboard.repository.CovidDataRepository;

@ExtendWith(MockitoExtension.class)
public class CovidDataServiceImplTest {

    @Mock
    private CovidDataRepository covidDataRepository;

    @InjectMocks
    private CovidDataServiceImpl covidDataService;

    private CovidData covidData1;
    private CovidData covidData2;

    @BeforeEach
    void setUp() {
        covidData1 = new CovidData("1", LocalDate.of(2023, 1, 1), "Spain", "Andalucia", 100, 10, 80);
        covidData2 = new CovidData("2", LocalDate.of(2023, 1, 1), "France", "Ile-de-France", 200, 20, 150);
    }

    @Test
    @DisplayName("getAll should return a list of CovidDataDto")
    void getAll_shouldReturnListOfDto() {
        // Arrange: Define the behavior of the mock
        when(covidDataRepository.findAll()).thenReturn(List.of(covidData1, covidData2));

        // Act: Call the method under test
        List<CovidDataDto> result = covidDataService.getAll();

        // Assert: Verify the outcome
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getCountry()).isEqualTo("Spain");
        assertThat(result.get(1).getCountry()).isEqualTo("France");
        assertThat(result.get(0).getCases()).isEqualTo(100);
        assertThat(result.get(1).getCases()).isEqualTo(200);
    }

    @Test
    @DisplayName("getAll should return an empty list when no data exists")
    void getAll_shouldReturnEmptyList_whenNoData() {
        // Arrange
        when(covidDataRepository.findAll()).thenReturn(List.of());

        // Act
        List<CovidDataDto> result = covidDataService.getAll();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.isEmpty()).isTrue();
    }
}
