package app.services;

import app.model.UsersRecruiter;
import app.repository.UserRepository;
import app.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<Users> findUser(int id){
        return userRepository.findById(id);
    }

    public List<Users> findAll(){
        List<Users> users = new ArrayList<Users>();
        users.addAll(userRepository.findAll());
        //tuong duong
//        for (UsersRecruiter usersRecruiter: usersRecruiterReponsitory.findAll()){
//            usersRecruiters.add(usersRecruiter);
//        }
        return users;
    }
}
