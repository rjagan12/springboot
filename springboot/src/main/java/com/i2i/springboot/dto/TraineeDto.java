package com.i2i.springboot.dto;

import com.i2i.springboot.model.Trainer;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Component
@Validated
public class TraineeDto {

    @NotEmpty(message = "Name Is Mandatory :: Please Enter The Name")
    @Min(2)@Max(30)
    private String name;

    private int id;

    //@NotBlank(message = "mobileNumber is required")
    //@Size(min = 10, max = 10)
    private long mobileNumber;

    @NotEmpty(message = "Mail is Mandatory")
    @Email( message = "please Enter Valid Mail " )
    private String mail;


    private LocalDate dateOfBirth;


    private LocalDate dateOfJoin;

    @NotNull
    @Min(value = 12, message = "Number Contains (0-9)12 Characters")
    @Max(value = 12, message = "Number Contains (0-9)12 Characters" )
    private long aadharNumber;

    @NotEmpty(message = "PanNumber Mandatory")
    @Min(value = 10, message = "panNumber contains 10 Characters(A-Z/0-9) ")
    @Max(value = 10, message = "panNumber contains 10 Characters(A-Z/0-9) ")
    private String panNumber;

    @NotEmpty(message = "Address Mandatory ")
    private String address;

    private boolean isDeleted;

    @NotEmpty(message = "Role Is Mandatory ")
    private String role;


    private LocalDate passOutYear;

    private List<Trainer> trainer;

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
