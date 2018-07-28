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

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;
    private UsersFreelancerService usersFreelancerService;
    private UsersRecruiterService usersRecruiterService;


    @RequestMapping(value = "/finduser", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Users> findUser(@RequestParam int id){
        return userService.findUser(id);
//        return list;
    }

    @RequestMapping(value = "/findalluser",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Users> findAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/finduserfreelancer", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<UsersFreelancer> findUserFrelancer(@RequestParam int id){
        return usersFreelancerService.findUserFreelancer(id);
//        return list;
    }

    @RequestMapping(value = "/findalluserfreelancer",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersFreelancer> findAllUserFrelancer(){
        return usersFreelancerService.findAll();
    }

    @RequestMapping(value = "/finduserrecruiter", //
                   method = RequestMethod.GET, //
                   produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<UsersRecruiter> findUserRecruiter(@RequestParam int id){
        return usersRecruiterService.findUserRecruiter(id);
//        return list;
    }

    @RequestMapping(value = "/findalluserrecruiter",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersRecruiter> findAllUsersRecruiter(){
        return usersRecruiterService.findAll();
    }
}
