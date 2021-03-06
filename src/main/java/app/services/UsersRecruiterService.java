package app.services;

import app.model.UsersRecruiter;
import app.repository.UsersRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersRecruiterService {

    @Autowired
    UsersRecruiterRepository usersRecruiterReponsitory;

    public List<UsersRecruiter> findAll(){
//        List<UsersRecruiter> usersRecruiters = new ArrayList<UsersRecruiter>();
//        usersRecruiters.addAll(usersRecruiterReponsitory.findAll());
        //tuong duong
//        for (UsersRecruiter usersRecruiter: usersRecruiterReponsitory.findAll()){
//            usersRecruiters.add(usersRecruiter);
//        }
        return usersRecruiterReponsitory.findAllUsersRecruiter();
    }

    public Optional<UsersRecruiter> findUserRecruiter(Integer id){
        return usersRecruiterReponsitory.findByUserIdAndDelFlag(id,false);
    }

    public void save(UsersRecruiter usersRecruiter){
        usersRecruiterReponsitory.save(usersRecruiter);
    }

    public Boolean update(UsersRecruiter users) {
        Optional<UsersRecruiter> user = findUserRecruiter(users.getUserId());
        if (!user.isPresent()) {
            UsersRecruiter existinguser = user.get();
            if (users.getCompanyName() != null) {
                existinguser.setCompanyName(users.getCompanyName());
            }
            if (users.getCompanyProfile() != null) {
                existinguser.setCompanyProfile(users.getCompanyProfile());
            }
            if(users.getApproved() != null){
                existinguser.setApproved(users.getApproved());
            }
            if (users.getUpdateUser() != null) {
                existinguser.setUpdateUser(users.getUpdateUser());
            }
            if(users.getDelFlag() != null){
                existinguser.setDelFlag(users.getDelFlag());
            }
            usersRecruiterReponsitory.save(existinguser);
            return true;
        }
        return false;
    }

    public Boolean delete(int id){
//        usersRecruiterReponsitory.deleteById(id);
        Optional<UsersRecruiter> user = findUserRecruiter(id);
        if(!user.isPresent()) {
            UsersRecruiter existinguser = user.get();
            existinguser.setDelFlag(true);
            usersRecruiterReponsitory.save(existinguser);
            return true;
        }
        return false;
    }
}
