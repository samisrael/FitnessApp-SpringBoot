package com.example.fitnessapp.service;

import com.example.fitnessapp.dto.WorkoutExerciseRequest;
import com.example.fitnessapp.model.*;
import com.example.fitnessapp.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutPlanService {
    private final WorkoutPlanRepository planRepo;
    private final TrainerRepository trainerRepo;
    private final ExerciseRepository exerciseRepo;
    private final WorkoutPlanExerciseRepository linkRepo;

    public WorkoutPlanService(WorkoutPlanRepository planRepo, TrainerRepository trainerRepo,
                              ExerciseRepository exerciseRepo, WorkoutPlanExerciseRepository linkRepo) {
        this.planRepo = planRepo;
        this.trainerRepo = trainerRepo;
        this.exerciseRepo = exerciseRepo;
        this.linkRepo = linkRepo;
    }

    public WorkoutPlan createPlan(Long trainerId, WorkoutPlan plan) {
        Trainer trainer = trainerRepo.findById(trainerId).orElseThrow();
        plan.setTrainer(trainer);
        return planRepo.save(plan);
    }

    public List<WorkoutPlan> getPlansByTrainer(Long trainerId) {
        Trainer trainer = trainerRepo.findById(trainerId).orElseThrow();
        return trainer.getPlans();
    }

    public WorkoutPlan addExerciseToPlan(Long planId, WorkoutExerciseRequest req) {
        WorkoutPlan plan = planRepo.findById(planId).orElseThrow();
        Exercise exercise = exerciseRepo.findById(req.exerciseId).orElseThrow();
        WorkoutPlanExercise wpe = new WorkoutPlanExercise();
        wpe.setPlan(plan);
        wpe.setExercise(exercise);
        wpe.setSets(req.sets);
        wpe.setReps(req.reps);
        wpe.setRestSeconds(req.restSeconds);
        linkRepo.save(wpe);
        return planRepo.findById(planId).orElseThrow();
    }

    public WorkoutPlan getPlan(Long id) {
        return planRepo.findById(id).orElseThrow();
    }

    public void deletePlan(Long id) {
        planRepo.deleteById(id);
    }
}
