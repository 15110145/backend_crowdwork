package app.services;

import app.model.Identity.UserRecruiterJobRequirementIdentity;
import app.model.UserRecruiterJobRequirement;
import app.repository.UserRecruiterJobRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class UserRecruiterJobRequirementService {
    @Autowired
    UserRecruiterJobRequirementRepository userRecruiterJobRequirementRepository;

    public ArrayList<UserRecruiterJobRequirement> findAll() {
        ArrayList<UserRecruiterJobRequirement> lstUserRecruiterJobRequirement = new ArrayList<>();
        lstUserRecruiterJobRequirement.addAll(userRecruiterJobRequirementRepository.findAll());
        return lstUserRecruiterJobRequirement;
    }

    public Optional<UserRecruiterJobRequirement> getUserRecruiterJobRequirement(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity) {
        return userRecruiterJobRequirementRepository.findById(userRecruiterJobRequirementIdentity);
    }

    public void addUserRecruiterJobRequirement(UserRecruiterJobRequirement userRecruiterJobRequirement) {
        userRecruiterJobRequirement.setDelFlag(Boolean.FALSE);
        userRecruiterJobRequirementRepository.save(userRecruiterJobRequirement);
    }

    public void editUserRecruiterJobRequirement(UserRecruiterJobRequirement editedUserRecruiterJobRequirement) {
        Optional<UserRecruiterJobRequirement> optionalUserRecruiterJobRequirement = getUserRecruiterJobRequirement(editedUserRecruiterJobRequirement.getUserRecruiterJobRequirementIdentity());
        if(optionalUserRecruiterJobRequirement.isPresent()) {
            UserRecruiterJobRequirement userRecruiterJobRequirement = optionalUserRecruiterJobRequirement.get();
            if (editedUserRecruiterJobRequirement.getDelFlag() != null){
                userRecruiterJobRequirement.setDelFlag(editedUserRecruiterJobRequirement.getDelFlag());
            }
            if (editedUserRecruiterJobRequirement.getProfessionJob() != null){
                userRecruiterJobRequirement.setProfessionJob(editedUserRecruiterJobRequirement.getProfessionJob());
            }
            if (editedUserRecruiterJobRequirement.getUsersRecruiter() != null){
                userRecruiterJobRequirement.setUsersRecruiter(editedUserRecruiterJobRequirement.getUsersRecruiter());
            }
            userRecruiterJobRequirementRepository.save(userRecruiterJobRequirement);
        }
        else
        {

        }
        //userRecruiterJobRequirementRepository.save(editedUserRecruiterJobRequirement);
    }

    public void deleteUserRecruiterJobRequirement(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity) {
        Optional<UserRecruiterJobRequirement> optionalUserRecruiterJobRequirement = getUserRecruiterJobRequirement(userRecruiterJobRequirementIdentity);
        if(optionalUserRecruiterJobRequirement.isPresent()) {
            UserRecruiterJobRequirement userRecruiterJobRequirement = optionalUserRecruiterJobRequirement.get();
//            userRecruiterJobRequirement.setDelFlag(Boolean.TRUE);
//            userRecruiterJobRequirementRepository.save(userRecruiterJobRequirement);
            userRecruiterJobRequirementRepository.delete(userRecruiterJobRequirement);
        }
        else
        {

        }
    }
}
