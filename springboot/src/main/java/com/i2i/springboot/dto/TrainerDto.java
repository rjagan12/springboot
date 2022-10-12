package com.i2i.springboot.dto;

import com.i2i.springboot.model.Trainee;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
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
        super();
    }
    @NotEmpty(message = "Name Is Mandatory :: Please Enter The Name")
    @Size(min = 2, max = 30)
    private String name;

    private int id;

   // @NotNull(message = "mobileNumber is required")
    //@Size(min = 10, max = 10)
    private long mobileNumber;

    @NotEmpty(message = "Mail is Mandatory")
    @Email( message = "please Enter Valid Mail " )
    private String mail;


    private LocalDate dateOfBirth;

    private LocalDate dateOfJoin;

    @NotNull()
    @Length(min = 12, max = 12)
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

    @NotEmpty(message = "experience Required")
    private int experience;

    @NotEmpty(message = "Please Enter the previous Company Name")
    private String companyName;

    private List<Trainee> trainee;

    public void setIsDeleted(Boolean isDeleted) {
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }
}
