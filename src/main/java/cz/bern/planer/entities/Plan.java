package cz.bern.planer.entities;


import jakarta.persistence.*;



import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planDescription;
    private LocalDate date;
    private LocalTime time;

    // Constructors, getters, and setters
    public Plan() {}

    public Plan(String planDescription, LocalDate date, LocalTime time) {
        this.planDescription = planDescription;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}