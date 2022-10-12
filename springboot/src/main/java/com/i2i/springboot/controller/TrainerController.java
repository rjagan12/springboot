package com.i2i.springboot.controller;

import com.i2i.springboot.dto.TrainerDto;
import com.i2i.springboot.exception.NullListException;
import com.i2i.springboot.helperclass.HelperDto;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.model.Trainer;
import com.i2i.springboot.service.impl.EmployeeServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <h> TrainerServlet </h>
 *  class used to extends HttpServlet and gives method definitions
 *  to get, put, post and delete employee details from user to EmployeeServiceImpl
 *  vice versa
 *
 * @version 1.0
 * @author Jaganathan R
 */
@RestController
@RequestMapping("/spring")
public class TrainerController {

    private static final String line = ("******************************************************");
    private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);
    @Autowired
    private EmployeeServiceImpl employeeService ;

    /**
     * Method used to put or update trainer details  to server
     * @param {@link @RequestBody Trainer}trainer
     * @return {String}Status of trainer details
     */
    @PutMapping("/update_trainer")
    public String updateTrainer(@Valid @RequestBody TrainerDto trainerDto )  {

        int id = trainerDto.getId();
        Trainer trainer = HelperDto.trainerDtoToTrainer(trainerDto);
        return employeeService.modifyTrainerDetailsById(id, trainer);
    }

    /**
     * Method used to put or update trainer details with assigning the trainees
     * @param {@link @pathVariable int, String}trainerId,traineeIds
     * @return {String}Status of trainer details
     */
    @PutMapping("/assign_trainee/{trainerId}/{traineeId}")
    public String assignTrainee(@PathVariable int trainerId,
                                @PathVariable String traineeId)  {
        String message = "Failed :: Trainee Assign Is Not Updated";
       Trainer trainer = employeeService.getTrainerDetailsById(trainerId);

       if (null != trainer) {
           String[] traineeIds = traineeId.split(",");

           for (int i = 0; i < traineeIds.length; i++) {
               int id = Integer.valueOf(traineeIds[i]);
               Trainee trainee = employeeService.getTraineeDetailsById(id);

               if (trainee != null) {
                   trainer.getTraineeDetails().add(trainee);
               } else {
                   message = "**** THERE IS NO TRAINEE ID *****";
               }
           }
           message = employeeService.assignTrainees(trainerId, trainer);
           return message;
       } else {
           return message + "**** THERE IS NO TRAINER ID *****";
       }
    }

    /**
     * Method used to post or add trainer details  to server
     * @param {@link @RequestBody Trainer}trainer
     * @return {String}Status of trainer details
     */
    @PostMapping("/save_trainer")
    public String addTrainer(@Valid @RequestBody TrainerDto trainerDto) {

        Trainer trainer = HelperDto.trainerDtoToTrainer(trainerDto);
        return employeeService.addTrainerDetails(trainer);
    }
    /**
     * Method used to delete trainer details  from server  by id
     * @param {@link @pathVariable int}id
     * @return {String} returns the status message
     */
    @DeleteMapping("/delete_trainer/{id}")
    public String deleteTrainerById(@PathVariable("id") int id)
            throws Exception {

        return employeeService.deleteTrainerDetails(id);
    }

    @DeleteMapping("/unassign_trainee/{trainerId}/{traineeId}")
    public String unAssignTrainee(@PathVariable int trainerId,
                                  @PathVariable String traineeId)  {

        return employeeService.removeAssignedTrainee(trainerId, traineeId);
    }


    /**
     * Method used to get All trainer details  from server
     *
     * @param {@link}
     * @return {List<Trainer>} returns list of trainer details
     *
     */

    @GetMapping("/trainer/{id}")
    public Map<String, Object> getTrainerById(@PathVariable("id") int id ) throws NullListException {
        Map<String, Object> trainer = employeeService.showTrainerDetailsById(id);
        if (null != trainer) {
            return trainer;
        } else {
            throw new NullListException("Id Not Found ");
        }

    }

    /**
     * Method used to get All trainer details  from server
     *
     * @param {@link}
     * @return {List<Trainer>} returns list of trainer details
     *
     */
    @GetMapping("/trainers")
    public List<Map<String, Object>> getAllTrainers() {

        List<Map<String, Object>> showTrainers = null;
        showTrainers = employeeService.showAllTrainerDetails();
        return showTrainers;
    }

    /**
     * Method used to show the  exception which is handle by NullListException
     * with the help of exception handler method
     *
     * @param {@link NullListException}exception
     * @return {@link String}return the exception with message
     */
    @ExceptionHandler(value = NullListException.class )
    public String exceptionHandler(NullListException exception) {

        return " INVALID RECORD " + exception.getMessage();
    }

    /**
     * Method used to show the  exception which is handle by NullListException
     * with the help of exception handler method
     *
     * @param {@link MethodArgumentNotValidException}exception
     * @return {@link String}return the exception with message
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class )
    public String exceptionHandler(MethodArgumentNotValidException exception) {

        return " INVALID Entry " + exception.getMessage();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String exceptionHandler(RuntimeException exception) {

        return "Exception " + exception.getMessage();
    }
}