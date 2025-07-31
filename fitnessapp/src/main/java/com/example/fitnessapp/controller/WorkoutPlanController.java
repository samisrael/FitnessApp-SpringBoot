package com.example.fitnessapp.controller;

import com.example.fitnessapp.dto.WorkoutExerciseRequest;
import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.service.WorkoutPlanService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkoutPlanController {
    private final WorkoutPlanService service;
    public WorkoutPlanController(WorkoutPlanService service) {
        this.service = service;
    }

    @PostMapping("/trainers/{trainerId}/plans")
    public WorkoutPlan createPlan(@PathVariable Long trainerId, @RequestBody WorkoutPlan plan) {
        return service.createPlan(trainerId, plan);
    }

    @GetMapping("/trainers/{trainerId}/plans")
    public List<WorkoutPlan> getPlans(@PathVariable Long trainerId) {
        return service.getPlansByTrainer(trainerId);
    }

    @PostMapping("/plans/{planId}/exercises")
    public WorkoutPlan addExercise(@PathVariable Long planId, @RequestBody WorkoutExerciseRequest req) {
        return service.addExerciseToPlan(planId, req);
    }

    @GetMapping("/plans/{planId}")
    public WorkoutPlan getPlan(@PathVariable Long planId) {
        return service.getPlan(planId);
    }

    @DeleteMapping("/plans/{planId}")
    public void delete(@PathVariable Long planId) {
        service.deletePlan(planId);
    }
}
