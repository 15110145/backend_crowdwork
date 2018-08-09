package app.controller;

import app.model.UserFreelancerHasSkill;
import app.services.UserFreelancerHasSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserFreelancerHasSkillController {

    @Autowired
    UserFreelancerHasSkillService userFreelancerHasSkillService;

    @RequestMapping(value = "/findalluserfreelancerhasskill", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserFreelancerHasSkill> findAllUserFreelancerHasSkill(){
        return userFreelancerHasSkillService.findAllUserFreelancerHasSkill();
    }

    @RequestMapping(value = "/finduserfreelancerhasskill/{f_is}/{s_id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<UserFreelancerHasSkill> findUserFreelancerHasSkill(@PathVariable Integer f_id, @PathVariable Integer s_id){
        return userFreelancerHasSkillService.findUserFreelancerHasSkill(f_id, s_id);
    }

    @RequestMapping(value = "/saveuserfreelancerhasskill", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveUserFreelancerHasSkill(@RequestBody UserFreelancerHasSkill userFreelancerHasSkill){
        userFreelancerHasSkillService.save(userFreelancerHasSkill);
        return "UserFreelancerHasSkill Saved!";
    }

    @RequestMapping(value = "/updateuserfreelancerhasskill", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateUserFreelancerHasSkill(@RequestBody UserFreelancerHasSkill userFreelancerHasSkill){
        userFreelancerHasSkillService.update(userFreelancerHasSkill);
        return "UserFreelancerHasSkill Updated!";
    }

    @RequestMapping(value = "/deleteuserfreelancerhasskill/{f_id}/{s_id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteUserFreelancerHasSkill(@PathVariable Integer f_id, @PathVariable Integer s_id){
        userFreelancerHasSkillService.delete(f_id, s_id);
        return "UserFreelancerHasSkill Deleted!";
    }
}
