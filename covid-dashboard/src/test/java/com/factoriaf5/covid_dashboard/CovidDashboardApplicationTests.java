package com.factoriaf5.covid_dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.factoriaf5.covid_dashboard.repository.CovidDataRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@SpringBootTest
@TestPropertySource(properties = 
"spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration")
class CovidDashboardApplicationTests {

    @MockBean
    private CovidDataRepository covidDataRepository; // This mock prevents the test from trying to connect to a real DB

    @MockBean
    private MongoTemplate mongoTemplate; // Mock MongoTemplate to prevent actual DB connection

    @MockBean
    private GridFsTemplate gridFsTemplate; // Mock GridFsTemplate to prevent its auto-configuration issues

    @Test
    void contextLoads() {
    }

}