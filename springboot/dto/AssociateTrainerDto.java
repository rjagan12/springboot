package com.i2i.springboot.dto;

import java.util.List;

public class AssociateTrainerDto {

    int traineeId;
    List<Integer> trainerId;

    public int getTraineeId() {
        return traineeId;
    }

    public List<Integer> getTrainerId() {
        return trainerId;
    }
}
