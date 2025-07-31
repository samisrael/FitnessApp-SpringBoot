package com.example.fitnessapp.service;

import com.example.fitnessapp.model.Exercise;
import com.example.fitnessapp.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise create(Exercise e) {
        return exerciseRepository.save(e);
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }
}
