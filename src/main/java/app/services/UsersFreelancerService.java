package app.services;

import app.model.UsersFreelancer;
import app.repository.UsersFreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UsersFreelancerService {

    @Autowired
    UsersFreelancerRepository usersFreelancerReponsitory;

    public List<UsersFreelancer> findAll(){
//        List<UsersFreelancer> usersFreelancers = new ArrayList<UsersFreelancer>();
//        for (UsersFreelancer usersFreelancer: usersFreelancerReponsitory.findAllUsersFreelancer()){
//            usersFreelancers.add(usersFreelancer);
//        }
        return usersFreelancerReponsitory.findAllUsersFreelancer();
    }

    public Optional<UsersFreelancer> findUserFreelancer(Integer u_id){
        return usersFreelancerReponsitory.findByUserIdAndDelFlag(u_id,false);
    }

    public void save(UsersFreelancer usersFreelancer){
        usersFreelancer.setDelFlag(false);
        usersFreelancerReponsitory.save(usersFreelancer);
    }

    public Boolean update(UsersFreelancer users) {
        Optional<UsersFreelancer> user = findUserFreelancer(users.getUserId());
        if (!user.isPresent()) {
            UsersFreelancer existinguser = user.get();
            if (users.getWorkingTime() != null){
                existinguser.setWorkingTime(users.getWorkingTime());
            }
            if (users.getSalaryPerHour() != null){
                existinguser.setSalaryPerHour(users.getSalaryPerHour());
            }
            if (users.getAbout() != null){
                existinguser.setAbout(users.getAbout());
            }
            if (users.getUsernameGithub() != null){
                existinguser.setUsernameGithub(users.getUsernameGithub());
            }
            if (users.getDegree() != null){
                existinguser.setDegree(users.getDegree());
            }
            if (users.getUpdateUser() != null) {
                existinguser.setUpdateUser(users.getUpdateUser());
            }
            if(users.getDelFlag() != null){
                existinguser.setDelFlag(users.getDelFlag());
            }
            if (users.getStatus() != null){
                existinguser.setStatus(users.getStatus());
            }
            usersFreelancerReponsitory.save(existinguser);
            return true;
        }
        return false;
    }

    public Boolean delete(Integer id){
//        usersFreelancerReponsitory.deleteById(id);
            Optional<UsersFreelancer> user = findUserFreelancer(id);
            if(!user.isPresent()) {
                UsersFreelancer existinguser = user.get();
                existinguser.setDelFlag(true);
                usersFreelancerReponsitory.save(existinguser);
                return true;
            }
            return false;
    }
}
