package com.i2i.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <h> Trainee </h> 
 * <p>
 *  Class used to get Trainee details from user and
 *  set details with setter and getters 
 * </p>
 * 
 * @version 1.0
 * @author Jaganathan R  
 */
@Entity
@Table(name = "trainees")
public class Trainee extends Employee {


    @Column(name = "year_of_passing")
    private LocalDate passOutYear;

    @ManyToMany(targetEntity = Trainer.class, cascade = {CascadeType.PERSIST
                 , CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "trainers_trainees",
                joinColumns = {@JoinColumn(name = "trainee_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Trainer> trainer;

    public void setPassOutYear(LocalDate passOutYear) {
        this.passOutYear = passOutYear;
    }

    public void setTrainerDetails(List<Trainer> trainer) {
        this.trainer = trainer;
    }

    public List<Trainer> getTrainerDetails() {
        return trainer;
    }

    public LocalDate getPassOutYear() {
        return passOutYear;
    }

}