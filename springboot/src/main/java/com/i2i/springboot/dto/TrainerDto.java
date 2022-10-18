package com.i2i.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.i2i.springboot.model.Trainee;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Component
@Validated
public class TrainerDto {

    public TrainerDto() {
    }

    @NotEmpty(message = "Name Is Mandatory :: Please Enter The Name")
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[A-Z{1}\\sa-z]{2,30}", message = "Please Enter Valid Name")
    private String name;

    private int id;

    @NotNull
    //@Size(min = 10, max = 10)
    //@Pattern(regexp = "[6-9]{1},[0-9]{9}")
    private long mobileNumber;

    @NotEmpty(message = "Mail is Mandatory")
    @Email( message = "please Enter Valid Mail " )
    private String mail;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;

    private LocalDate dateOfJoin;

    @NotNull
    //@Digits(integer = 12, fraction = 0, message = "size of the aadhar number 12")
    //@Length(min = 12, max = 12)
    private long aadharNumber;

    @NotEmpty(message = "PanNumber Mandatory")
    @Pattern(regexp = "[A-Z 0-9]{10}", message = "Please Enter Valid PanNumber")
    private String panNumber;

    @NotEmpty(message = "Address Mandatory ")
    private String address;

    private boolean isDeleted;

    @NotEmpty(message = "Role Is Mandatory ")
    @Pattern(regexp = "[a-z]{3,}", message = "Please Enter Valid Role")
    private String role;

    @NotNull
    private int experience;

    @NotEmpty(message = "Please Enter the previous Company Name")
    @Pattern(regexp = "[(A-Z)(0-9)\\s]{3,}", message = "Please Enter The Valid Company Name")
    private String companyName;

    private List<TraineeDto> traineeDetails;

    public void setIsDeleted(Boolean isDeleted) {
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }
}
