package app.services;

import app.model.UsersFreelancer;
import app.repository.UsersFreelancerReponsitory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersFreelancerService {

    private final UsersFreelancerReponsitory usersFreelancerReponsitory;

    public UsersFreelancerService(UsersFreelancerReponsitory usersFreelancerReponsitory) {
        this.usersFreelancerReponsitory = usersFreelancerReponsitory;
    }

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
}
