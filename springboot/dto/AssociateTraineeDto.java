package com.i2i.springboot.dto;

import java.util.List;

public class AssociateTraineeDto {

    int trainerId;

    List<Integer> traineeId;

    public int getTrainerId() {
        return trainerId;
    }

    public List<Integer> getTraineeId() {
        return traineeId;
    }

}
