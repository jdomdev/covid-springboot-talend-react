package com.factoriaf5.covid_dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CovidDataDto {

    @NotBlank(message = "Date cannot be blank")
    private String date;

    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotNull(message = "Cases cannot be null")
    @Min(value = 0, message = "Cases must be non-negative")
    private Integer cases;

    @NotNull(message = "Deaths cannot be null")
    @Min(value = 0, message = "Deaths must be non-negative")
    private Integer deaths;

    @NotNull(message = "Recovered cannot be null")
    @Min(value = 0, message = "Recovered must be non-negative")
    private Integer recovered;
}
