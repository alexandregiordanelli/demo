package com.example.demo;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CSVLoaderService {

    private final ProducerAwardRepository repository;

    public CSVLoaderService(ProducerAwardRepository repository) {
        this.repository = repository;
    }

    @jakarta.annotation.PostConstruct
    public void loadCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new ClassPathResource("raspberry_awards.csv").getInputStream()));
            
            CsvToBean<ProducerAward> csvToBean = new CsvToBeanBuilder<ProducerAward>(reader)
                    .withType(ProducerAward.class)
                    // .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();

            List<ProducerAward> awards = csvToBean.parse();
            repository.saveAll(awards);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
