//package app.services;
//
//import app.model.UsersRecruiter;
//import app.repository.UserRepository;
//import app.model.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    public Optional<Users> findUser(int id){
//        return userRepository.findById(id);
//    }
//
//    public List<Users> findAll(){
//        List<Users> users = new ArrayList<Users>();
//        users.addAll(userRepository.findAll());
//        //tuong duong
////        for (UsersRecruiter usersRecruiter: usersRecruiterReponsitory.findAll()){
////            usersRecruiters.add(usersRecruiter);
////        }
//        return users;
//    }
//
//    public void save(Users users){
//        userRepository.save(users);
//    }
//
////    public void update1(Users users){
////        userRepository.updateUser(users.getId(),users.getName(),users.getUpdateTime());
////    }
//
//    public void update(Users users){
////        Users existinguser = null;
//        Optional<Users> user = findUser(users.getId());
//        if(user.isPresent()) {
//            Users existinguser = user.get();
//            if (users.getName() != null){
//                existinguser.setName(users.getName());
//            }
//            if(users.getAddress() != null){
//                existinguser.setAddress(users.getAddress());
//            }
//            if(users.getAvatar() != null){
//                existinguser.setAvatar(users.getAvatar());
//            }
//            if(users.getCmnd() != null){
//                existinguser.setCmnd(users.getCmnd());
//            }
//            if (users.getDate_of_birth() != null){
//                existinguser.setDate_of_birth(users.getDate_of_birth());
//            }
//            if(users.getEmail() != null){
//                existinguser.setEmail(users.getEmail());
//            }
//            if(users.getVerifyEmail() != null){
//                existinguser.setVerifyEmail(users.getVerifyEmail());
//            }
//            userRepository.save(existinguser);
//        }
//    }
//
//    public void delete(int id){
//        userRepository.deleteById(id);
//    }
//}
