package app.services;

import app.reponsitory.UserRepository;
import app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Users> findAll(){
        List<Users> users = new ArrayList<Users>();
        users.addAll(userRepository.findAll());
        return users;
    }

    public Optional<Users> findUser(int id){
        return userRepository.findById(id);
    }
}
