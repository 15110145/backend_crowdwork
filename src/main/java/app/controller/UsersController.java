package app.controller;

import app.model.Users;
import app.model.UsersFreelancer;
import app.model.UsersRecruiter;
import app.services.UserService;
import app.services.UsersFreelancerService;
import app.services.UsersRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersFreelancerService usersFreelancerService;

    @Autowired
    private UsersRecruiterService usersRecruiterService;

    /**
     *
     * @Users service
     *
     */
// tim kiem user thong qua id
    @RequestMapping(value = "/finduser/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Users> findUser(@PathVariable int id){
        return userService.findUser(id);
    }

    //lay tat ca user
    @RequestMapping(value = "/findalluser",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Users> findAllUser(){
        return userService.findAll();
    }

    //luu user
    @RequestMapping(value = "/saveuser", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String saveUser(@RequestBody Users user){
        user.setDelFlag(false);
        user.setVerifyEmail(false);
        userService.save(user);
        return "User saved !";
    }

    //update user
    @RequestMapping(value = "/updateuser", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUser(@RequestBody Users user){
//        user.setUpdateTime(new Date());
        userService.update(user);
        return "User updated !";
    }

    /**
     *
     * @UsersFreelancer
     *
     */
    //tim kiem user freelancer theo id
    @RequestMapping(value = "/finduserfreelancer/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<UsersFreelancer> findUserFrelancer(@PathVariable int id){
        return usersFreelancerService.findUserFreelancer(id);
    }

    //lay tat ca user freelancer
    @RequestMapping(value = "/findalluserfreelancer",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersFreelancer> findAllUserFrelancer(){
        return usersFreelancerService.findAll();
    }

    //luu userfreelancer
    @RequestMapping(value = "/saveuserfreelancer", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String saveUserFreelancer(@RequestBody UsersFreelancer user){
        user.setCreateTime(new Date());
        user.setDelFlag(false);
        usersFreelancerService.save(user);
        return "UserFreelancer saved !";
    }

    //update userfreelancer
    @RequestMapping(value = "/updateuserfreelancer", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUserFreelancer(@RequestBody UsersFreelancer user){
        usersFreelancerService.update(user);
        return "Freelancer updated !";
    }

    /**
     *
     * @UsersRecruiter
     *
     */
    //tim kiem user recruiter
    @RequestMapping(value = "/finduserrecruiter/{id}", //
                   method = RequestMethod.GET, //
                   produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<UsersRecruiter> findUserRecruiter(@PathVariable int id){
        return usersRecruiterService.findUserRecruiter(id);
//        return list;
    }

    //lay tat ca user recruiter
    @RequestMapping(value = "/findalluserrecruiter",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersRecruiter> findAllUsersRecruiter(){
        return usersRecruiterService.findAll();
    }

    //luu userrecruiter
    @RequestMapping(value = "/saveuserrecruiter", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String saveUserRecruiter(@RequestBody UsersRecruiter user){
        user.setCreateTime(new Date());
        user.setDelFlag(false);
        usersRecruiterService.save(user);
        return "UserRecruiter saved !";
    }

    //update userrecruiter
    @RequestMapping(value = "/updateuserrecruiter", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUserRecruiter(@RequestBody UsersRecruiter user){
        usersRecruiterService.update(user);
        return "Recruiter updated !";
    }

}
