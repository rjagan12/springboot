package com.i2i.springboot.helperclass;

import com.i2i.springboot.dto.TraineeDto;
import com.i2i.springboot.dto.TrainerDto;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.model.Trainer;

public class HelperDto {

    public static TraineeDto traineeToDto(Trainee trainee) {

        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setId(traineeDto.getId());
        traineeDto.setMail(trainee.getMail());
        traineeDto.setName(trainee.getName());
        traineeDto.setRole(trainee.getRole());
        traineeDto.setMobileNumber(trainee.getMobileNumber());
        traineeDto.setAddress(trainee.getAddress());
        traineeDto.setIsDeleted(trainee.getIsDeleted());
        traineeDto.setAadharNumber(trainee.getAadharNumber());
        traineeDto.setTrainer(trainee.getTrainerDetails());
        traineeDto.setPassOutYear(trainee.getPassOutYear());
        traineeDto.setDateOfBirth(trainee.getDateOfBirth());
        traineeDto.setPanNumber(trainee.getPanNumber());
        traineeDto.setDateOfJoin(trainee.getDateOfJoin());
        return traineeDto;
    }

    public static Trainee traineeDtoToTrainee(TraineeDto traineeDto) {

        Trainee trainee = new Trainee();
        trainee.setId(traineeDto.getId());
        trainee.setRole(traineeDto.getRole());
        trainee.setName(traineeDto.getName());
        trainee.setMail(traineeDto.getMail());
        trainee.setAadharNumber(traineeDto.getAadharNumber());
        trainee.setIsDeleted(traineeDto.getIsDeleted());
        trainee.setAddress(traineeDto.getAddress());
        trainee.setDateOfJoin(traineeDto.getDateOfJoin());
        trainee.setDateOfBirth(traineeDto.getDateOfBirth());
        trainee.setPassOutYear(traineeDto.getPassOutYear());
        trainee.setPanNumber(traineeDto.getPanNumber());
        trainee.setMobileNumber(traineeDto.getMobileNumber());
        trainee.setTrainerDetails(traineeDto.getTrainer());
        return trainee;
    }
    public static TrainerDto trainerToDto(Trainer trainer) {

        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainerDto.getId());
        trainerDto.setMail(trainer.getMail());
        trainerDto.setName(trainer.getName());
        trainerDto.setRole(trainer.getRole());
        trainerDto.setMobileNumber(trainer.getMobileNumber());
        trainerDto.setAddress(trainer.getAddress());
        trainerDto.setIsDeleted(trainer.getIsDeleted());
        trainerDto.setAadharNumber(trainer.getAadharNumber());
        trainerDto.setTrainee(trainer.getTraineeDetails());
        trainerDto.setCompanyName(trainer.getcompanyName());
        trainerDto.setDateOfBirth(trainer.getDateOfBirth());
        trainerDto.setPanNumber(trainer.getPanNumber());
        trainerDto.setDateOfJoin(trainer.getDateOfJoin());
        trainerDto.setExperience(trainerDto.getExperience());
        return trainerDto;
    }

    public static Trainer trainerDtoToTrainer(TrainerDto trainerDto) {

        Trainer trainer = new Trainer();
        trainer.setId(trainerDto.getId());
        trainer.setRole(trainerDto.getRole());
        trainer.setName(trainerDto.getName());
        trainer.setMail(trainerDto.getMail());
        trainer.setAadharNumber(trainerDto.getAadharNumber());
        trainer.setIsDeleted(trainerDto.getIsDeleted());
        trainer.setAddress(trainerDto.getAddress());
        trainer.setDateOfJoin(trainerDto.getDateOfJoin());
        trainer.setDateOfBirth(trainerDto.getDateOfBirth());
        trainer.setcompanyName(trainerDto.getCompanyName());
        trainer.setPanNumber(trainerDto.getPanNumber());
        trainer.setMobileNumber(trainerDto.getMobileNumber());
        trainer.setTraineeDetails(trainerDto.getTrainee());
        trainer.setExperience(trainerDto.getExperience());
        return trainer;
    }
}
