package com.thejavatest.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thejavatest.domain.Study;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudyController {

    final StudyRepository repository;

    @GetMapping("/study/{id}")
    public Study getStudy(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Study not found for '" + id + "'"));
    }

    @PostMapping("/study")
    public Study createsStudy(@RequestBody Study study) {
        return repository.save(study);
    }

}
