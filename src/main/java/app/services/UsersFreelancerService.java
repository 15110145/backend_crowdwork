package app.services;

import app.model.UsersFreelancer;
import app.repository.UsersFreelancerReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersFreelancerService {

    @Autowired
    UsersFreelancerReponsitory usersFreelancerReponsitory;

    public List<UsersFreelancer> findAll(){
        List<UsersFreelancer> usersFreelancers = new ArrayList<UsersFreelancer>();
        for (UsersFreelancer usersFreelancer: usersFreelancerReponsitory.findAll()){
            usersFreelancers.add(usersFreelancer);
        }
        return usersFreelancers;
    }

    public Optional<UsersFreelancer> findUserFreelancer(int id){
        return usersFreelancerReponsitory.findById(id);
    }

    public void save(UsersFreelancer usersFreelancer){
        usersFreelancerReponsitory.save(usersFreelancer);
    }

    public void update(UsersFreelancer users) {
//        Users existinguser = null;
        Optional<UsersFreelancer> user = findUserFreelancer(users.getUserId());
        if (user.isPresent()) {
            UsersFreelancer existinguser = user.get();
            if (users.getStatusId() != null){

            }
        }
    }

    public void delete(int id){
        usersFreelancerReponsitory.deleteById(id);
    }
}
