package com.i2i.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.i2i.springboot.model.Trainer;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Component
@Validated
public class TraineeDto {

    @NotEmpty(message = "Name may not be null")
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[A-Z{1}\\sa-z]{2,30}", message = "Please Enter Valid Name")
    private String name;

    private int id;

    @NotNull(message = "mobileNumber is required")
    //@Min(value = 10, message = "Number Should contains 10 characters")
    //@Max(value = 10, message = "Number Should contains 10 characters")
    private long mobileNumber;

    @NotEmpty(message = "Mail is Mandatory")
    @Email( message = "please Enter Valid Mail " )
    private String mail;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoin;

    @NotNull(message = "AADHAR Number Required")
    //@Min(value = 12, message = "Number Contains (0-9)12 Characters")
    //@Max(value = 12, message = "Number Contains (0-9)12 Characters" )
    private long aadharNumber;

    @NotEmpty(message = "PanNumber Mandatory")
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[A-Z 0-9]{10}", message = "Please Enter Valid PanNumber")
    private String panNumber;

    @NotEmpty(message = "Address Mandatory ")
    private String address;

    private boolean isDeleted;

    @NotEmpty(message = "Role Is Mandatory ")
    @Pattern(regexp = "[a-z]{3,}", message = "Please Enter Valid Role")
    private String role;

    private LocalDate passOutYear;


    private List<TrainerDto> trainerDetails;

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<TrainerDto> getTrainerDetails() {
        return trainerDetails;
    }
    public void setTrainerDetails(List<TrainerDto> trainer) {
        this.trainerDetails = trainer;
    }
}
