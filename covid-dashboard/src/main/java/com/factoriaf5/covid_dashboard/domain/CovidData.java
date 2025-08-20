
package com.factoriaf5.covid_dashboard.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "covid_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CovidData {

    @Id
    private String id;
    private LocalDate date;
    private String country;
    private String region;
    private Integer cases;
    private Integer deaths;
    private Integer recovered;
}
