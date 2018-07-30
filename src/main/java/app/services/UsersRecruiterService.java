package app.services;

import app.model.UsersRecruiter;
import app.repository.UsersRecruiterReponsitory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersRecruiterService {

    private final UsersRecruiterReponsitory usersRecruiterReponsitory;

    public UsersRecruiterService(UsersRecruiterReponsitory usersRecruiterReponsitory) {
        this.usersRecruiterReponsitory = usersRecruiterReponsitory;
    }

    public List<UsersRecruiter> findAll(){
        List<UsersRecruiter> usersRecruiters = new ArrayList<UsersRecruiter>();
        usersRecruiters.addAll(usersRecruiterReponsitory.findAll());
        //tuong duong
//        for (UsersRecruiter usersRecruiter: usersRecruiterReponsitory.findAll()){
//            usersRecruiters.add(usersRecruiter);
//        }
        return usersRecruiters;
    }

    public Optional<UsersRecruiter> findUserRecruiter(int id){
        return usersRecruiterReponsitory.findById(id);
    }
}
