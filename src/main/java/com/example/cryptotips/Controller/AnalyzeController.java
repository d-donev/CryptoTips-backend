package com.example.cryptotips.Controller;


import com.example.cryptotips.Model.Analyze;
import com.example.cryptotips.Model.DTO.AnalyzeDTO;
import com.example.cryptotips.Service.AnalyzeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AnalyzeController {

    private final AnalyzeService analyzeService;

    public AnalyzeController(AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }


    @GetMapping("/analyze")
    public List<Analyze> getAllAnalysis() {
        return analyzeService.findAll();
    }

    @GetMapping("/analyze/{id}")
    public Analyze getById(@PathVariable Long id) {
        return analyzeService.findById(id);
    }

    @PostMapping("/analyze/add")
    public ResponseEntity<Analyze> addAnalyze(@RequestBody AnalyzeDTO analyzeDTO) {

        return analyzeService.create(analyzeDTO)
                .map(analyze -> ResponseEntity.ok().body(analyze))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/analyze/edit/{id}")
    public ResponseEntity<Analyze> editAnalzye (@PathVariable Long id,
                                                @RequestBody AnalyzeDTO analyzeDTO) {
        return analyzeService.edit(id, analyzeDTO)
                .map(analyze -> ResponseEntity.ok().body(analyze))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/analyze/delete/{id}")
    public ResponseEntity<Analyze> deleteAnalyze (@PathVariable Long id) {

        return analyzeService.delete(id)
                .map(analyze -> ResponseEntity.ok().body(analyze))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
