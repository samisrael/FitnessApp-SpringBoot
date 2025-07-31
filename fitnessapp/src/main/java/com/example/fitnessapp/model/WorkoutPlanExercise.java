package com.example.fitnessapp.model;

import jakarta.persistence.*;

@Entity
public class WorkoutPlanExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private WorkoutPlan plan;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    private int sets;
    private int reps;
    private int restSeconds;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public WorkoutPlan getPlan() { return plan; }
    public void setPlan(WorkoutPlan plan) { this.plan = plan; }
    public Exercise getExercise() { return exercise; }
    public void setExercise(Exercise exercise) { this.exercise = exercise; }
    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }
    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }
    public int getRestSeconds() { return restSeconds; }
    public void setRestSeconds(int restSeconds) { this.restSeconds = restSeconds; }
}
