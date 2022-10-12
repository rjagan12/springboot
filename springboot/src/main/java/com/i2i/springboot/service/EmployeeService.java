package com.i2i.springboot.service;

import com.i2i.springboot.exception.NullListException;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.model.Trainer;

import java.util.List;
import java.util.Map;

/**
 * <h> EmployeeService </h>
 * <p>
 *  Class used to get employee details from  TrainerRepository , TraineeRepository
 *  and returns details as object to EmployeeController vice versa
 *
 *  </p>
 *
 * @version 1.0
 * @author Jaganathan R
 */
public interface EmployeeService {

    /**
     * <p>
     * Method used to add All trainee Details
     * in server by help of TrainerRepository
     *
     * </p>
     * @param {@link Trainee}trainee Object
     * @return {@link Trainee }return status with trainee Object
     */
    Trainee addTraineeDetails(Trainee trainee);

    /**
     * Method used to show All trainees Details from the
     * servere with the help of  TrainerRepository
     *
     * @param {@link noparam}
     * @return {@link List<Trainee> }return traineeDetails
     */
    List<Map<String, Object>> showAllTraineeDetails();

    /**
     * Method used to remove or soft delete trainees deatils
     * with the help of id by TraineeRepository
     *
     * @param {@link int }traineeid
     * @return {@link String }return status
     */
    String deleteTraineeDetails(int id) throws Exception;

    /**
     * Method used to show trainee Details by id
     * from the servere with help of TraineeRepository
     *
     * @param {@link int}traineeid
     * @return {@link Trainee }return traineeDetailswith respect to id
     */
    Map<String, Object> showTraineeDetailsById(int traineeId) throws NullListException;

    /**
     * Method used to update trainee Details by id with
     * help of TraineeRepository with respect id
     *
     * @param {@link int, Trainee}traineeId, traineeDetails
     * @return {@link String}return status success if valid id (or) failure for invalid id
     */
    String modifyTraineeDetailsById(int traineeId, Trainee traineeDetails);

    /**
     * Method used to add All trainer Details with help
     * of TrainerRepository
     *
     * @param {@link Trainer}trainer details
     * @return {@link String }return status
     */
    String addTrainerDetails(Trainer trainer);

    /**
     * Method used to show All trainers Details
     * @param {@link noparam}
     * @return {@link List<Trainer> }return list of trainerDetails
     */
    List<Map<String, Object>> showAllTrainerDetails();

    /**
     * Method used to remove trainer details by id if exist
     * or returns invalid status
     * @param {@link int }trainerId
     * @return {@link String }return status removed or not
     */
    String  deleteTrainerDetails(int id);

    /**
     * Method used to show trainerDetails by id if exits
     * or returns null to controller
     * @param {@link int}trainerId
     * @return {@link Trainer }return trainerDetails or null
     */
    Map<String, Object> showTrainerDetailsById(int trainerId) throws NullListException;

    /**
     * Method used to get all  traineeDetails by id
     * from database to controller
     * @param {@link int}traineeId
     * @return {@link Trainee }return traineeDetails
     */
    Trainee getTraineeDetailsById(int traineeId) throws NullListException;

    /**
     * Method used to get all  trainerDetails by id
     * from database to controller
     * @param {@link int}trainerId
     * @return {@link Trainee }return trainerDetails
     */
    Trainer getTrainerDetailsById(int trainerId) throws NullListException;

    /**
     * Method used to modify trainer details by id with respect
     * to exist id
     *
     * @param {@link int, Trainer}trainerId and trainer
     * @return {@link String} returns status updated or not
     */
    String modifyTrainerDetailsById(int id, Trainer trainerDetails);

    /**
     * Method used to assign trainers to trainee by using traineeId
     * and trainerIds with respect to traineeId
     * @param {@link int, Trainer}traineeId, trainerIds
     * @return {@link String}returns status Assigned por not
     */
    String assignTrainers(int traineeId, String trainerId);

    /**
     * Method used to assign trainees to trainer with respect
     * to exist traineeId
     *
     * @param {@link int, Trainer}traineeId, trainer
     * @return {@link String}returns status assigned or not
     */
    String assignTrainees(int trainerId, Trainer trainer);

    /**
     * Method used to remove assigned trainees from trainer
     * with respect to exist trainerId and traineeIds
     *
     * @param {@link int, String}trainerId trainerIds
     * @return {@link String }return status removed or not
     */
    String removeAssignedTrainee(int trainerId, String traineeId);

    /**
     * Method used to remove assigned trainer from trainee
     * with help of exist id
     *
     * @param {@link int int}traineeId trainerId
     * @return {@link String }return status removed or not
     */
    String removeAssignedTrainer(int traineeId, int trainerId);

    /**
     *
     * Method used to get Trainer Details and created a new collection to avoid
     * Lazy exception while retrieve the trainers
     *
     * @param {@link Trainer}trainerDetails
     * @return {@link Map<String, Object> }returns the trainerDetails
     */
    Map<String, Object> getTrainerObject(Trainer trainer);

    /**
     * Method used to get Trainee Details and created a new collection to avoid
     * Lazy exception while retrieve the trainees
     *
     * @param {@link Trainee}traineeDetails
     * @return {@link Map<String, Object> }returns the traineeDetails
     */
    Map<String, Object> getTraineeObject(Trainee trainee);
}
