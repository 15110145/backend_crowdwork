package app.services;

import app.repository.UserRepository;
import app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<Users> findUser(Integer id){
        return userRepository.findByIdAndDelFlag(id,false);
    }

    public List<Users> findAll(){
//        List<Users> users = new ArrayList<Users>();
//        users.addAll(userRepository.findAllUsers());
        //tuong duong
//        for (UsersRecruiter usersRecruiter: usersRecruiterReponsitory.findAll()){
//            usersRecruiters.add(usersRecruiter);
//        }
        return userRepository.findAllUsers();
    }

    public void save(Users users){
        userRepository.save(users);
    }

//    public void update1(Users users){
//        userRepository.updateUser(users.getId(),users.getName(),users.getUpdateTime());
//    }

    public Boolean update(Users users){
        Optional<Users> user = findUser(users.getId());
        if(!user.isPresent()) {
            Users existinguser = user.get();
            if (users.getName() != null){
                existinguser.setName(users.getName());
            }
            if(users.getAddress() != null){
                existinguser.setAddress(users.getAddress());
            }
            if(users.getAvatar() != null){
                existinguser.setAvatar(users.getAvatar());
            }
            if(users.getCmnd() != null){
                existinguser.setCmnd(users.getCmnd());
            }
            if (users.getDate_of_birth() != null){
                existinguser.setDate_of_birth(users.getDate_of_birth());
            }
            if(users.getEmail() != null){
                existinguser.setEmail(users.getEmail());
            }
            if(users.getVerifyEmail() != null){
                existinguser.setVerifyEmail(users.getVerifyEmail());
            }
            userRepository.save(existinguser);
            return true;
        }
        return false;
    }

    public Boolean delete(Integer id){
        //        userRepository.deleteById(id);
        Optional<Users> user = findUser(id);
        if(!user.isPresent()) {
            Users existinguser = user.get();
            existinguser.setDelFlag(true);
            userRepository.save(existinguser);
            return true;
        }
        return false;
    }
}
