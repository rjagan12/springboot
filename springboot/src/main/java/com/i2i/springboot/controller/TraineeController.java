package com.i2i.springboot.controller;

import com.i2i.springboot.dto.AssociateTrainerDto;
import com.i2i.springboot.dto.TraineeDto;
import com.i2i.springboot.exception.NullListException;
import com.i2i.springboot.helperclass.HelperDto;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h> TraineeServlet </h>
 *  class used to extends HttpServlet and gives method definitions
 *  to get, put, post and delete employee details from user to EmployeeServiceImpl
 *  vice versa
 *
 * @version 1.0
 * @author Jaganathan R
 */
@RestController
@RequestMapping("/employee_assist")
public class TraineeController  {

    private static final String inValidData = (" ##********* //INVALID DATA// ************## ");
    private static final String noData = (" ##********* // NO DATA // ************## ");
    private static final Logger logger = LoggerFactory.getLogger(TraineeController.class);
    private static final String line = ("******************************************************");
    @Autowired
    private EmployeeService employeeService ;


    /**
     * Method used to post trainee details to service from user
     * @param {@link @RequestBody Trainee}trainee object with required details
     * @return {@link String}returns the status of the given details
     */
    @PostMapping(path = "/save_trainee")
    public String addTrainee(@Valid @RequestBody TraineeDto traineeDto) throws Exception {
        String message = " Failed :: Not Inserted ";
        if (null != traineeDto) {
            Trainee trainee = HelperDto.traineeDtoToTrainee(traineeDto,false);
            employeeService.addTraineeDetails(trainee);
            return "SUCCESSFULLY :: INSERTED";
        } else{
            return message;
        }
    }

    /**
     * Method used to delete trainee details  from server
     * @param {@link @pathVariable int}id
     * @return {@link String} returns the status wit respect to given id
     */
    @DeleteMapping("/delete_trainee/{id}")
    protected String deleteById(@PathVariable("id") int id)
            throws Exception {
            return employeeService.deleteTraineeDetails(id);
    }

    /**
     * Method used to put or update trainee details to service from user
     * @param {@link @ResponseBody Trainee}trainee object with updated details
     * @return {@link String}returns the Status of the given id
     */
    @PutMapping("/update_trainee")
    public String updateTrainee(@Valid @RequestBody TraineeDto traineeDto) {

        Trainee trainee = HelperDto.traineeDtoToTrainee(traineeDto,false);
        int id = trainee.getId();
       return employeeService.modifyTraineeDetailsById(id, trainee);

    }

    /**
     * Method used to get trainee details  from server
     * @param {@link @PathVariable int}id
     * @return {@link Trainee}returns trainee object with respect id
     */
    @GetMapping("/trainee/{id}")
    public TraineeDto getTraineeById(@PathVariable("id") int id )
            throws NullListException {
        Trainee trainee = employeeService.showTraineeDetailsById(id);
        TraineeDto traineeDto = HelperDto.traineeToDto(trainee, true);
        if (trainee != null ) {
            return traineeDto;
        }
        throw new NullListException("ID NOT FOUND");
    }
    /**
     * Method used to get trainee details  from server
     * @param {no param}
     * @return {@link List<Trainee>}returns all the trainee details
     */
    @GetMapping("/trainees")
    @ResponseBody
    public List<Map<String, Object>> getAllTrainees() throws NullListException, Exception {

        List<Map<String, Object>> showTrainees = null;
        return showTrainees = employeeService.showAllTraineeDetails();
    }

    /**
     * Method used to put or update trainer details with assigning the trainees
     * @param {@link @pathVariable int, String}trainerId,traineeIds
     * @return {String}Status of trainer details
     */
    @PutMapping("/assign_trainer")
    public String assignTrainer(@RequestBody AssociateTrainerDto assign) throws Exception {
        int traineeId = assign.getTraineeId();
        List<Integer> trainerId = assign.getTrainerId();
         return employeeService.assignTrainers(traineeId, trainerId);
    }

    @DeleteMapping("/unassign_trainer")
    public String unAssignTrainer(@RequestBody AssociateTrainerDto assign) throws Exception {
        int traineeId = assign.getTraineeId();
        List<Integer> trainerId = assign.getTrainerId();
        return employeeService.removeAssignedTrainer(traineeId, trainerId);
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
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
            });
        return " INVALID Entry " + errors;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String exceptionHandler(RuntimeException exception) {

        return "Exception " + exception.getMessage();
    }

}
