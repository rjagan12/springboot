package com.i2i.springboot.controller;

import com.i2i.springboot.dto.TraineeDto;
import com.i2i.springboot.dto.TrainerDto;
import com.i2i.springboot.helperclass.HelperDto;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.model.Trainer;
import com.i2i.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("trainers")
    public ModelAndView getTrainers(ModelAndView model) {

        List<Trainer> showTrainers = employeeService.getAllTrainers();
        model.addObject("showTrainers",showTrainers);
        model.setViewName("index.html");
        return model;
    }
    @GetMapping("trainees")
    public ModelAndView getTrainees(ModelAndView model) {
        List<Trainee> showTrainees = employeeService.getAllTrainees();
        model.addObject("showTrainers",showTrainees);
        model.setViewName("view.html");
        return model;

    }
    @GetMapping("trainers/{id}")
    public ModelAndView getTrainerbyId(ModelAndView model, @PathVariable int id) {

        Trainer trainer = employeeService.showTrainerDetailsById(id);
        TrainerDto trainerDto = HelperDto.trainerToDto(trainer,true);
        List<TrainerDto> showTrainers = new ArrayList<>();
        showTrainers.add(trainerDto);
        model.addObject("showTrainers",showTrainers);
        model.setViewName("index.html");
        return model;
    }

    @GetMapping("trainees/{id}")
    public ModelAndView getTraineebyId(ModelAndView model, @PathVariable int id) {

        Trainee trainee = employeeService.showTraineeDetailsById(id);
        TraineeDto traineeDto = HelperDto.traineeToDto(trainee,true);
        List<TraineeDto> showTrainees = new ArrayList<>();
        showTrainees.add(traineeDto);
        model.addObject("showTrainees",showTrainees);
        model.setViewName("view.html");
        return model;
    }
}
