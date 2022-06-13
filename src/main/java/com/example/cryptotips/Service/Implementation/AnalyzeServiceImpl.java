package com.example.cryptotips.Service.Implementation;

import com.example.cryptotips.Model.Analyze;
import com.example.cryptotips.Model.Comparator.SortAnalyzeByTime;
import com.example.cryptotips.Model.Comparator.SortByDateAdded;
import com.example.cryptotips.Model.DTO.AnalyzeDTO;
import com.example.cryptotips.Model.Exceptions.AnalyzeNotFoundException;
import com.example.cryptotips.Repository.AnalyzeRepository;
import com.example.cryptotips.Service.AnalyzeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {

    private final AnalyzeRepository analyzeRepository;

    public AnalyzeServiceImpl(AnalyzeRepository analyzeRepository) {
        this.analyzeRepository = analyzeRepository;
    }

    @Override
    public Analyze findById(Long id) {
        return analyzeRepository.findById(id).orElseThrow(() -> new AnalyzeNotFoundException(id));
    }

    @Override
    public List<Analyze> findAll() {
        List<Analyze> analyzeList = analyzeRepository.findAll();
        analyzeList.sort(new SortAnalyzeByTime().reversed());
        return analyzeList;
    }

    @Override
    public Optional<Analyze> create(AnalyzeDTO analyzeDTO) {
        String title = analyzeDTO.getTitle();
        String part1 = analyzeDTO.getPart1();
        String part2 = analyzeDTO.getPart2();
        String part3 = analyzeDTO.getPart3();
        String part4 = analyzeDTO.getPart4();
        Analyze analyze = new Analyze(title,part1,part2,part3,part4);
        analyzeRepository.save(analyze);
        return Optional.of(analyze);
    }

    @Override
    public Optional<Analyze> edit(Long id, AnalyzeDTO analyzeDTO) {

        Analyze analyze = this.findById(id);
        analyze.setTitle(analyzeDTO.getTitle());
        analyze.setPart1(analyzeDTO.getPart1());
        analyze.setPart2(analyzeDTO.getPart2());
        analyze.setPart3(analyzeDTO.getPart3());
        analyze.setPart4(analyzeDTO.getPart4());
        analyzeRepository.save(analyze);
        return Optional.of(analyze);
    }


    @Override
    public Optional<Analyze> delete(Long id) {
        Analyze analyze = this.findById(id);
        analyzeRepository.delete(analyze);
        return Optional.of(analyze);
    }
}
