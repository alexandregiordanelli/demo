package com.example.demo;

import java.util.List;

public class IntervalDTO {
    private List<ProducerInterval> min;
    private List<ProducerInterval> max;

     public IntervalDTO(List<ProducerInterval> min, List<ProducerInterval> max) {
        this.min = min;
        this.max = max;
    }

    public List<ProducerInterval> getMin() {
        return min;
    }

    public void setMin(List<ProducerInterval> min) {
        this.min = min;
    }

    public List<ProducerInterval> getMax() {
        return max;
    }

    public void setMax(List<ProducerInterval> max) {
        this.max = max;
    }
}
