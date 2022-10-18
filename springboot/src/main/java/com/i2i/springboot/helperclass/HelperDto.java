package com.i2i.springboot.helperclass;

import com.i2i.springboot.dto.TraineeDto;
import com.i2i.springboot.dto.TrainerDto;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.model.Trainer;

import java.util.List;
import java.util.stream.Collectors;

public class HelperDto {

    public static TraineeDto traineeToDto(Trainee trainee,boolean flag) {

        TraineeDto traineeDto = new TraineeDto();
        traineeDto.setId(trainee.getId());
        traineeDto.setMail(trainee.getMail());
        traineeDto.setName(trainee.getName());
        traineeDto.setRole(trainee.getRole());
        traineeDto.setMobileNumber(trainee.getMobileNumber());
        traineeDto.setAddress(trainee.getAddress());
        traineeDto.setIsDeleted(trainee.getIsDeleted());
        traineeDto.setAadharNumber(trainee.getAadharNumber());
        traineeDto.setPassOutYear(trainee.getPassOutYear());
        traineeDto.setDateOfBirth(trainee.getDateOfBirth());
        traineeDto.setPanNumber(trainee.getPanNumber());
        traineeDto.setDateOfJoin(trainee.getDateOfJoin());

        List<Trainer> trainers = trainee.getTrainerDetails();
        if (null != trainers && flag) {
            traineeDto.setTrainerDetails(convertTrainersToDto(trainers));
        }

        return traineeDto;
    }

    private static List<TrainerDto> convertTrainersToDto(List<Trainer> trainers) {
        if (null != trainers) {
            return trainers.stream().map(trainer -> trainerToDto(trainer, false))
                    .collect(Collectors.toList());
        }
        return null;

    }

    public static Trainee traineeDtoToTrainee(TraineeDto traineeDto,boolean flag) {

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

       List<TrainerDto> trainersDto = traineeDto.getTrainerDetails();
        if (null != trainersDto && flag) {
            trainee.setTrainerDetails(convertTrainersDtoToTrainers(trainersDto));
       }

        return trainee;
    }
    public static TrainerDto trainerToDto(Trainer trainer,boolean flag) {

        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainer.getId());
        trainerDto.setMail(trainer.getMail());
        trainerDto.setName(trainer.getName());
        trainerDto.setRole(trainer.getRole());
        trainerDto.setMobileNumber(trainer.getMobileNumber());
        trainerDto.setAddress(trainer.getAddress());
        trainerDto.setIsDeleted(trainer.getIsDeleted());
        trainerDto.setAadharNumber(trainer.getAadharNumber());
        trainerDto.setCompanyName(trainer.getcompanyName());
        trainerDto.setDateOfBirth(trainer.getDateOfBirth());
        trainerDto.setPanNumber(trainer.getPanNumber());
        trainerDto.setDateOfJoin(trainer.getDateOfJoin());
        trainerDto.setExperience(trainerDto.getExperience());

        List<Trainee> trainees = trainer.getTraineeDetails();
        if (null != trainees && flag ) {
            trainerDto.setTraineeDetails(convertTraineesToDto(trainees));
        }
        return trainerDto;
    }

    private static List<TraineeDto> convertTraineesToDto(List<Trainee> trainees) {

        if (null != trainees) {
            return trainees.stream().map(trainee -> traineeToDto(trainee, false))
                    .collect(Collectors.toList());

        }
        return null;
    }

    public static Trainer trainerDtoToTrainer(TrainerDto trainerDto,boolean flag) {

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
        trainer.setExperience(trainerDto.getExperience());
        List<TraineeDto> traineesDto = trainerDto.getTraineeDetails();
        if ((null != traineesDto) && (flag) ) {
            trainer.setTraineeDetails(convertTraineesDtoToTrainees(traineesDto));
        }
        return trainer;
    }

    private static List<Trainee> convertTraineesDtoToTrainees(List<TraineeDto> traineesDto) {
        if (null != traineesDto) {
            return traineesDto.stream().map(trainee -> traineeDtoToTrainee(trainee,false))
                    .collect(Collectors.toList());
        }
        return null;
    }

    private static List<Trainer> convertTrainersDtoToTrainers(List<TrainerDto> trainersDto) {
        if(null != trainersDto){
            return trainersDto.stream().map(trainer -> trainerDtoToTrainer(trainer,false))
                    .collect(Collectors.toList());
        }

        return null;
    }
}
