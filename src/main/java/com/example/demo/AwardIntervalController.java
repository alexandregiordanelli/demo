package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/awards")
public class AwardIntervalController {

    @Autowired
    private AwardIntervalService service;

    @GetMapping("/intervals")
    public ResponseEntity<IntervalDTO> getIntervals() {
        IntervalDTO intervalDTO = service.calculateIntervals();
        return ResponseEntity.ok(intervalDTO);
    }
}
