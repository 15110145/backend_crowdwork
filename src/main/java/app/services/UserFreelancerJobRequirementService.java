package app.services;

import app.model.Identity.UserFreelancerJobRequirementIdentity;
import app.model.UserFreelancerJobRequirement;
import app.repository.UserFreelancerJobRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class UserFreelancerJobRequirementService {
    @Autowired
    UserFreelancerJobRequirementRepository userFreelancerJobRequirementRepository;

    public ArrayList<UserFreelancerJobRequirement> findAll() {
        ArrayList<UserFreelancerJobRequirement> lstUserFreelancerJobRequirement = new ArrayList<>();
        lstUserFreelancerJobRequirement.addAll(userFreelancerJobRequirementRepository.findAll());
        return lstUserFreelancerJobRequirement;
    }

    public Optional<UserFreelancerJobRequirement> getUserFreelancerJobRequirement(UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity) {
        return userFreelancerJobRequirementRepository.findById(userFreelancerJobRequirementIdentity);
    }

    public void addUserFreelancerJobRequirement(UserFreelancerJobRequirement userFreelancerJobRequirement) {
        userFreelancerJobRequirement.setDelFlag(Boolean.FALSE);
        userFreelancerJobRequirementRepository.save(userFreelancerJobRequirement);
    }

    public void editUserFreelancerJobRequirement(UserFreelancerJobRequirement editedUserFreelancerJobRequirement) {
        Optional<UserFreelancerJobRequirement> optionalUserFreelancerJobRequirement = getUserFreelancerJobRequirement(editedUserFreelancerJobRequirement.getUserFreelancerJobRequirementIdentity());
        if(optionalUserFreelancerJobRequirement.isPresent()) {
            UserFreelancerJobRequirement userFreelancerJobRequirement = optionalUserFreelancerJobRequirement.get();
            if (editedUserFreelancerJobRequirement.getDelFlag() != null){
                userFreelancerJobRequirement.setDelFlag(editedUserFreelancerJobRequirement.getDelFlag());
            }
            if (editedUserFreelancerJobRequirement.getProfessionJob() != null){
                userFreelancerJobRequirement.setProfessionJob(editedUserFreelancerJobRequirement.getProfessionJob());
            }
            if (editedUserFreelancerJobRequirement.getUsersFreelancer() != null){
                userFreelancerJobRequirement.setUsersFreelancer(editedUserFreelancerJobRequirement.getUsersFreelancer());
            }
            userFreelancerJobRequirementRepository.save(userFreelancerJobRequirement);
        }
        else
        {

        }
        //userFreelancerJobRequirementRepository.save(editedUserFreelancerJobRequirement);
    }

    public void deleteUserFreelancerJobRequirement(UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity) {
        Optional<UserFreelancerJobRequirement> optionalUserFreelancerJobRequirement = getUserFreelancerJobRequirement(userFreelancerJobRequirementIdentity);
        if(optionalUserFreelancerJobRequirement.isPresent()) {
            UserFreelancerJobRequirement userFreelancerJobRequirement = optionalUserFreelancerJobRequirement.get();
//            userFreelancerJobRequirement.setDelFlag(Boolean.TRUE);
//            userFreelancerJobRequirementRepository.save(userFreelancerJobRequirement);
            userFreelancerJobRequirementRepository.delete(userFreelancerJobRequirement);
        }
        else
        {

        }
    }
}
