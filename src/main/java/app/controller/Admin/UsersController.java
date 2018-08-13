package app.controller.Admin;

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

@RestController
@RequestMapping(value="/admin")
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
    @RequestMapping(value = "/user/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Users> findUser(@PathVariable Integer id){
        return userService.findUser(id);
    }

    //lay tat ca user
    @RequestMapping(value = "/user/list",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Users> findAllUser(){
        return userService.findAll();
    }

    //luu user
    @RequestMapping(value = "/user", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String saveUser(@RequestBody Users user){
        userService.save(user);
        return "User Saved !";
    }

    //update user
    @RequestMapping(value = "/user", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUser(@RequestBody Users user){
        if(userService.update(user)){
            return "User Updated !";
        }
        return "User Updated !";
    }

    //delete user
    @RequestMapping(value = "/user/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String deleteUser(@PathVariable int id){
        userService.delete(id);
        return "User Deleted !";
    }

    /**
     *
     * @UsersFreelancer
     *
     */
    //tim kiem user freelancer theo id
    @RequestMapping(value = "/userfreelancer/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersFreelancer> findUserFrelancer(@PathVariable int id){
        return usersFreelancerService.findUserFreelancer(id);
    }

    //lay tat ca user freelancer
    @RequestMapping(value = "/userfreelancer/list",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersFreelancer> findAllUserFrelancer(){
        return usersFreelancerService.findAll();
    }

    //luu userfreelancer
    @RequestMapping(value = "/userfreelancer", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String saveUserFreelancer(@RequestBody UsersFreelancer user){
        usersFreelancerService.save(user);
        return "UserFreelancer Saved !";
    }

    //update userfreelancer
    @RequestMapping(value = "/userfreelancer", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUserFreelancer(@RequestBody UsersFreelancer user){
        if(usersFreelancerService.update(user)){
            return "Freelancer Updated !";
        }
        return "Freelancer Not Found !";
    }

    //update userfreelancer
    @RequestMapping(value = "/userfreelancer/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String deleteUserFreelancer(@PathVariable int id){
        if(usersFreelancerService.delete(id)){
            return "Freelancer Deleted !";
        }
        return "Freelancer Not Found !";
    }


    /**
     *
     * @UsersRecruiter
     *
     */
    //tim kiem user recruiter
    @RequestMapping(value = "/userrecruiter/{id}", //
                   method = RequestMethod.GET, //
                   produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersRecruiter> findUserRecruiter(@PathVariable Integer id){
        return usersRecruiterService.findUserRecruiter(id);
    }

    //lay tat ca user recruiter
    @RequestMapping(value = "/userrecruiter/list",//
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsersRecruiter> findAllUsersRecruiter(){
        return usersRecruiterService.findAll();
    }

    //luu userrecruiter
    @RequestMapping(value = "/userrecruiter", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String saveUserRecruiter(@RequestBody UsersRecruiter user){
        usersRecruiterService.save(user);
        return "UserRecruiter Saved !";
    }

    //update userrecruiter
    @RequestMapping(value = "/userrecruiter", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUserRecruiter(@RequestBody UsersRecruiter user){
        if(usersRecruiterService.update(user)){
            return "Recruiter Updated !";
        }
        return "Recruiter Not Found !";
    }

    //update userrecruiter
    @RequestMapping(value = "/userrecruiter/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public String updateUserRecruiter(@PathVariable Integer id){
        if(usersRecruiterService.delete(id)){
            return "Recruiter Deleted !";
        }
        return "Recruiter Not Found !";
    }
}
