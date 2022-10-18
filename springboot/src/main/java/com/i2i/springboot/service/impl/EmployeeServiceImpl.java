package com.i2i.springboot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.i2i.springboot.dao.TraineeRepository;
import com.i2i.springboot.dao.TrainerRepository;
import com.i2i.springboot.exception.NullListException;
import com.i2i.springboot.model.Trainer;
import com.i2i.springboot.model.Trainee;
import com.i2i.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h> EmployeeServiceImpl </h> 
 * <p>
 *  Class used to get employee details from EmployeeServiceImpl and
 *  returns details as object to EmployeeController vice versa
 *  which is implemented from EmployeeService
 *  </p>
 *
 * @version 1.0
 * @author Jaganathan R  
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private TraineeRepository traineeRepository;

    private final NullListException message = new NullListException("ID NOT FOUND");

    /**
     * <p>
     * Method used to add All trainee Details
     * in server by help of TrainerRepository
     *
     * </p>
     * @param {@link Trainee}trainee Object
     * @return {@link Trainee }return status with trainee Object
     */
    @Override
    public Trainee addTraineeDetails(Trainee trainee) {

        return traineeRepository.save(trainee);
    }

    /**
     * Method used to show All trainees Details from the
     * database with the help of  TrainerRepository
     *
     * @param {@link }
     * @return {@link List<Map<String, Object>> }return traineeDetails
     */
    @Override
    public List<Map<String, Object>> showAllTraineeDetails()  {

        List<Map<String, Object>> traineeDetails = new ArrayList<>();
        List<Trainee> trainee = traineeRepository.findByIsDeleted(false);

        for (Trainee trainees: trainee ) {
            traineeDetails.add(getTraineeObject(trainees));
        }
        return traineeDetails;
    }

    /**
     * Method used to remove or soft delete trainees details
     * with the help of id by TraineeRepository
     *
     * @param {@link int }traineeId
     * @return {@link String }return status
     */
    @Override
    public String deleteTraineeDetails(int id) throws Exception {
        String message = "******* there is no record to Delete *******";
        if (traineeRepository.existsById(id)) {
            Trainee trainee = traineeRepository.getById(id);
            trainee.setIsDeleted(true);
            traineeRepository.save(trainee);
            return "**** THE ID : " + id + " IS DELETED SUCCESSFULLY";
        } else {
            return message +" Enter The Valid Id ";
        }


    }

    /**
     * Method used to show trainee Details by id
     * from the database with help of TraineeRepository
     *
     * @param {@link int}traineeId
     * @return {@link Trainee }return trainee Details with respect to id
     */
    @Override
    public Trainee showTraineeDetailsById(int traineeId) throws NullListException  {

       if (traineeRepository.existsById(traineeId)) {
            return traineeRepository.getById(traineeId);
           //return getTraineeObject(trainee);
       }
        throw new NullListException(" ***** THERE IS NO ID ***** ");
    }

    /**
     * Method used to update trainee Details by id with
     * help of TraineeRepository with respect id
     *
     * @param {@link int, Trainee}traineeId, traineeDetails
     * @return {@link String}return status success if valid id (or) failure for invalid id
     */
    @Override
    public String modifyTraineeDetailsById(int traineeId, Trainee traineeDetails)  {

        if (traineeRepository.existsById(traineeId)) {
            traineeRepository.save(traineeDetails);
            return "THE ID : " + traineeId + " IS UPDATED SUCCESSFULLY ";
        } else {
            return "\" FAILED  :: THERE IS NO ID TO UPDATE \"";
        }
    }

    /**
     * Method used to add All trainer Details with help
     * of TrainerRepository
     *
     * @param {@link Trainer}trainer details
     * @return {@link String }return status
     */
    @Override
    public String addTrainerDetails(Trainer trainer)  {
        String message = "FAILED NOT INSERTED";
        if (null != trainer) {
            trainerRepository.save(trainer);
            return "SUCCESSFULLY INSERTED";
        } else {
            return message;
        }
    }

    /**
     * Method used to show All trainers Details
     *
     * @param {@link}
     * @return {@link List<Trainer> }return list of trainerDetails
     */
    @Override
    public List<Map<String, Object>> showAllTrainerDetails()  {
        Map<String, Object> trainerDetails = null;
        List<Map<String, Object>> trainers = new ArrayList<>();
        List<Trainer> list = trainerRepository.findByIsDeleted(false);
        for (Trainer trainer:list) {
            trainers.add( getTrainerObject(trainer));
        }
        return trainers;
    }

    /**
     * Method used to remove trainer details by id if exist
     * or returns invalid status
     *
     * @param {@link int }trainerId
     * @return {@link String }return status removed or not
     */
    @Override
    public String  deleteTrainerDetails(int id) {
        String message = "******* there is no record to Delete *******";
        if (trainerRepository.existsById(id)) {
            Trainer trainer = trainerRepository.getById(id);
            trainer.setIsDeleted(true);
            trainerRepository.save(trainer);
            return "**** THE ID : " + id + " IS DELETED SUCCESSFULLY";
        } else {
            return message +" Enter The Valid Id ";
        }

    }

    /**
     * Method used to show trainersDetails by id if exits
     * or returns null to controller
     *
     * @param {@link int}trainerId
     * @return {@link Trainer }return trainerDetails or null
     */
    @Override
    public Trainer showTrainerDetailsById(int trainerId) throws NullListException {

        if (trainerRepository.existsById(trainerId)) {
            return trainerRepository.getById(trainerId);
        } else {
            throw new NullListException("**** THERE IS NO RECORD *****");
        }
    }

    /**
     * Method used to get all  traineeDetails by id
     * from database to controller
     *
     * @param {@link int}traineeId
     * @return {@link Trainee }return traineeDetails
     */
    @Override
    public Trainee getTraineeDetailsById(int traineeId) throws NullListException {
        if (traineeRepository.existsById(traineeId)) {
            return traineeRepository.getById(traineeId);
        } else {
            throw new NullListException("***** THERE IS NO RECORD *****");
        }
    }

    /**
     * Method used to show trainerDetails by id
     * @param {@link int}trainerId
     * @return {@link Trainer }return trainerDetails
     */
    @Override
    public Trainer getTrainerDetailsById(int trainerId) throws NullListException {
        if (trainerRepository.existsById(trainerId)) {
            return trainerRepository.getById(trainerId);
        }
        throw new NullListException("***** THERE IS NO RECORD *****");
    }

    /**
     * Method used to modify trainer details by id with respect
     * to exist id
     *
     * @param {@link int, Trainer}trainerId and trainer
     * @return {@link String} returns status updated or not
     */
    @Override
    public String modifyTrainerDetailsById(int id, Trainer trainerDetails) {

        if (trainerRepository.existsById(id)) {
             trainerRepository.save(trainerDetails);
             return "THE ID : " + id + " IS UPDATED SUCCESSFULLY ";
        } else {
            return " FAILED  :: THERE IS NO ID TO UPDATE ";
        }
    }

    /**
     * Method used to assign trainers to trainee by using traineeId
     * and trainerIds with respect to traineeId
     *
     * @param {@link int, String}traineeId, trainerIds
     * @return {@link String}returns status Assigned por not
     */
    @Override
    public String assignTrainers(int traineeId, List<Integer> trainerIds) {

        String message = "Failed :: Trainee Assign Is Not Updated";
        Trainee trainee = null;
        if (traineeRepository.existsById(traineeId)) {
            trainee = traineeRepository.getById(traineeId);

            for (int i = 0; i < trainerIds.size(); i++) {
                int id = trainerIds.get(i);
                if (trainerRepository.existsById(id)) {
                    Trainer trainer = trainerRepository.getById(id);
                    trainee.getTrainerDetails().add(trainer);
                    message = "*****TRAINER ASSIGNED SUCCESSFULLY******";
                } else {
                    message = "**** THERE IS NO TRAINER ID *****";
                }
            }
            traineeRepository.save(trainee);
            return message;
        } else {
            return message + "**** THERE IS NO TRAINEE ID *****";
        }

    }   

    /**
     * Method used to assign trainees to trainer with respect
     * to exist traineeId
     *
     * @param {@link int, Trainer}traineeId, trainer
     * @return {@link String}returns status assigned or not
     */
    @Override
    public String assignTrainees(int trainerId, Trainer trainer)  {

         String message = "FAILED :: NOT ASSIGNED";
        if (trainerRepository.existsById(trainerId)) {
            trainerRepository.save(trainer);
           return message = "SUCCESSFULLY :: ASSIGNED";
        } else {
            return message;
        }

    }

    /**
     * Method used to remove assigned trainees from trainer
     * with respect to exist trainerId and traineeIds
     *
     * @param {@link int, String}trainerId trainerIds
     * @return {@link String }return status removed or not
     */
    @Override
    public String removeAssignedTrainee(int trainerId, List<Integer> traineeId) {

        if (trainerRepository.existsById(trainerId)) {
            Trainer trainer = trainerRepository.getById(trainerId);
            List<Trainee> trainees = trainer.getTraineeDetails();

            for (int i = 0; i < trainees.size(); i++) {

                for(int j = 0; j < traineeId.size(); j++) {
                    int id = traineeId.get(j);

                    if ((trainees.get(i).getId()) == id ) {
                        trainees.remove(i);
                    } else {
                        return "THERE IS NO TRAINEE ID TO REMOVE";
                    }
                }
            }
            trainer.setTraineeDetails(trainees);
            trainerRepository.save(trainer);
            return "TRAINEE REMOVED SUCCESSFULLY";
        }else {
            return "THERE IS NO TRAINER ID :: PLEASE ENTER VALID ID";
        }
    }
 
    /**
     * Method used to remove assigned trainer from trainee
     * with help of exist id
     *
     * @param {@link int int}traineeId trainerId
     * @return {@link String }return status removed or not
     */
    @Override
    public String removeAssignedTrainer(int traineeId,List<Integer> trainerId) {

        if (traineeRepository.existsById(traineeId)) {
            Trainee trainee = traineeRepository.getById(traineeId);
            List<Trainer> trainers = trainee.getTrainerDetails();

            for (int i = 0; i < trainers.size(); i++) {

                for(int j = 0; j < trainerId.size(); j++) {
                    int id = trainerId.get(j);

                    if ((trainers.get(i).getId()) == id ) {
                        trainers.remove(i);
                    } else {
                        return "THERE IS NO TRAINER ID TO REMOVE";
                    }
                }
            }
            trainee.setTrainerDetails(trainers);
            traineeRepository.save(trainee);
            return "TRAINEE REMOVED SUCCESSFULLY";
        }else {
            return "THERE IS NO TRAINEE ID :: PLEASE ENTER VALID ID";
        }
    }

    /**
     *
     * Method used to get Trainer Details and created a new collection to avoid
     * Lazy exception while retrieve the trainers
     *
     * @param {@link Trainer}trainerDetails
     * @return {@link Map<String, Object> }returns the trainerDetails
     */
    @Override
    public Map<String, Object> getTrainerObject(Trainer trainer) {
        List<Map<String, Object>> trainee = new ArrayList<>();
        List<Trainee> list = trainer.getTraineeDetails();

        for(Trainee traineeList : list){
            Map<String,Object> listTrainee = new HashMap<>();
            listTrainee.put("traineeId",traineeList.getId());
            listTrainee.put("Trainee Name",traineeList.getName());
            trainee.add(listTrainee);

        }
        Map<String,Object> map = new HashMap<>();
        map.put("trainer Id",trainer.getId());
        map.put("Trainer Name",trainer.getName());
        map.put("Trainer Mail",trainer.getMail());
        map.put("Trainer Role" ,trainer.getRole());
        map.put("Trainer Mobile Number", trainer.getMobileNumber());
        map.put("trainees", trainee);
        return map;
    }

    /**
     * Method used to get Trainee Details and created a new collection to avoid
     * Lazy exception while retrieve the trainees
     *
     * @param {@link Trainee}traineeDetails
     * @return {@link Map<String, Object> }returns the traineeDetails
     */
    @Override
    public Map<String, Object> getTraineeObject(Trainee trainee) {

        List<Map<String, Object>> trainer = new ArrayList<>();
        List<Trainer> list = trainee.getTrainerDetails();

        for(Trainer trainerList : list){
            Map<String,Object> listTrainer = new HashMap<>();
            listTrainer.put("trainerId",trainerList.getId());
            listTrainer.put("Trainer Name",trainerList.getName());
            trainer.add(listTrainer);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("trainee Id",trainee.getId());
        map.put("Trainee Name",trainee.getName());
        map.put("Trainee Mail",trainee.getMail());
        map.put("Trainee Role" ,trainee.getRole());
        map.put("Trainee Mobile Number", trainee.getMobileNumber());
        map.put("trainers", trainer);
        return map;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return  trainerRepository.findByIsDeleted(false);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return  traineeRepository.findByIsDeleted(false);
    }

}