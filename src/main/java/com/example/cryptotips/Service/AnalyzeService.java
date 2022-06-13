package com.example.cryptotips.Service;



import com.example.cryptotips.Model.DTO.AnalyzeDTO;
import com.example.cryptotips.Model.Analyze;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AnalyzeService {

    Analyze findById(Long id);

    List<Analyze> findAll();

    Optional<Analyze> create (AnalyzeDTO analyzeDTO);

    Optional<Analyze> edit (Long id, AnalyzeDTO analyzeDTO);

    Optional<Analyze> delete(Long id);

}
