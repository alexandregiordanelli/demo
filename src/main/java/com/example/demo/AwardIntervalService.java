package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardIntervalService {

    @Autowired
    private ProducerAwardRepository repository;

    public IntervalDTO calculateIntervals() {
        List<ProducerAward> awards = repository.findByWinnerTrueOrderByYear();
        Map<String, List<Integer>> producerWins = new HashMap<>();
        List<ProducerInterval> allIntervals = new ArrayList<>();

        for (ProducerAward award : awards) {
            String[] producers = award.getProducer().split(",\\s*|\\s+and\\s+");
            for (String producer : producers) {
                producerWins.computeIfAbsent(producer, k -> new ArrayList<>()).add(award.getYear());
            }
        }

        for (Map.Entry<String, List<Integer>> entry : producerWins.entrySet()) {
            List<Integer> years = entry.getValue();
            Collections.sort(years);

            for (int i = 0; i < years.size() - 1; i++) {
                int interval = years.get(i + 1) - years.get(i);
                allIntervals.add(new ProducerInterval(entry.getKey(), interval, years.get(i), years.get(i + 1)));
            }
        }

        // Encontrar o intervalo mínimo e máximo
        int minIntervalValue = allIntervals.stream().min(Comparator.comparing(ProducerInterval::getInterval)).get()
                .getInterval();
        int maxIntervalValue = allIntervals.stream().max(Comparator.comparing(ProducerInterval::getInterval)).get()
                .getInterval();

        // Filtrar todos os intervalos que são iguais ao mínimo e máximo
        List<ProducerInterval> minIntervals = allIntervals.stream()
                .filter(interval -> interval.getInterval() == minIntervalValue).collect(Collectors.toList());
        List<ProducerInterval> maxIntervals = allIntervals.stream()
                .filter(interval -> interval.getInterval() == maxIntervalValue).collect(Collectors.toList());

        return new IntervalDTO(minIntervals, maxIntervals);
    }

}
