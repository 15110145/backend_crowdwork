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
        List<UsersFreelancer> usersFreelancers = new ArrayList<UsersFreelancer>();
        for (UsersFreelancer usersFreelancer: usersFreelancerReponsitory.findAll()){
            usersFreelancers.add(usersFreelancer);
        }
        return usersFreelancers;
    }

    public Optional<UsersFreelancer> findUserFreelancer(int u_id){
        return usersFreelancerReponsitory.findById(u_id);
    }

//    public List<UsersFreelancer> findUserFreelancer1(int u_id, int s_id){
//        return usersFreelancerReponsitory.findUsersFreelancerById(u_id,s_id);
//    }

    public void save(UsersFreelancer usersFreelancer){
        usersFreelancer.setDelFlag(false);
        usersFreelancerReponsitory.save(usersFreelancer);
    }

    public void update(UsersFreelancer users) {
        Optional<UsersFreelancer> user = findUserFreelancer(users.getUserId());
        if (user.isPresent()) {
            UsersFreelancer existinguser = user.get();
            if (users.getStatus().getId() != null){
                existinguser.setStatus(users.getStatus());
            }
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
            existinguser.setUpdateTime(new Date());
            usersFreelancerReponsitory.save(existinguser);
        }
    }

    public void delete(int id){
        usersFreelancerReponsitory.deleteById(id);
    }
}
