package com.i2i.springboot.dao;

import com.i2i.springboot.model.Employee;
import com.i2i.springboot.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

    List<Trainee> findByIsDeleted(boolean isDeleted);

    //List<Trainee> findByIsDeleted(int id,boolean isDeleted);


}
