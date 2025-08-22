
package com.factoriaf5.covid_dashboard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.factoriaf5.covid_dashboard.domain.CovidData;

@Repository
public interface CovidDataRepository extends MongoRepository<CovidData, String> {
    List<CovidData> findByCountry(String country);
}
