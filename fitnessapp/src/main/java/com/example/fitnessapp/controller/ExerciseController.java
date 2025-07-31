package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.Exercise;
import com.example.fitnessapp.service.ExerciseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {
    private final ExerciseService service;
    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    @PostMapping
    public Exercise create(@RequestBody Exercise e) {
        return service.create(e);
    }

    @GetMapping
    public List<Exercise> getAll() {
        return service.getAll();
    }
}
