package com.example.fitnessapp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<WorkoutPlanExercise> exercises;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
    public List<WorkoutPlanExercise> getExercises() { return exercises; }
    public void setExercises(List<WorkoutPlanExercise> exercises) { this.exercises = exercises; }
}
