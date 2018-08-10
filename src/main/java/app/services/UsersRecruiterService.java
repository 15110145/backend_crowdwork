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

    public List<UsersRecruiter> findUserRecruiter(Integer id){
        return usersRecruiterReponsitory.findUsersRecruiterById(id);
    }

    public void save(UsersRecruiter usersRecruiter){
        usersRecruiterReponsitory.save(usersRecruiter);
    }

    public Boolean update(UsersRecruiter users) {
        List<UsersRecruiter> user = findUserRecruiter(users.getUserId());
        if (!user.isEmpty()) {
            UsersRecruiter existinguser = user.get(0);
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
        List<UsersRecruiter> user = findUserRecruiter(id);
        if(!user.isEmpty()) {
            UsersRecruiter existinguser = user.get(0);
            existinguser.setDelFlag(true);
            usersRecruiterReponsitory.save(existinguser);
            return true;
        }
        return false;
    }
}
