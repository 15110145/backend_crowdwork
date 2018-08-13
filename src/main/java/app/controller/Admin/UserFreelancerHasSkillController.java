package app.controller.Admin;

import app.model.UserFreelancerHasSkill;
import app.services.UserFreelancerHasSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/userfreelancerhasskill")
public class UserFreelancerHasSkillController {

    @Autowired
    UserFreelancerHasSkillService userFreelancerHasSkillService;

    @RequestMapping(value = "/list", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserFreelancerHasSkill> findAllUserFreelancerHasSkill(){
        return userFreelancerHasSkillService.findAllUserFreelancerHasSkill();
    }

    @RequestMapping(value = "/{f_is}/{s_id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserFreelancerHasSkill> findUserFreelancerHasSkill(@PathVariable Integer f_id, @PathVariable Integer s_id){
        return userFreelancerHasSkillService.findUserFreelancerHasSkill(f_id, s_id);
    }

    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveUserFreelancerHasSkill(@RequestBody UserFreelancerHasSkill userFreelancerHasSkill){
        userFreelancerHasSkillService.save(userFreelancerHasSkill);
        return "UserFreelancerHasSkill Saved!";
    }

    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateUserFreelancerHasSkill(@RequestBody UserFreelancerHasSkill userFreelancerHasSkill){
        if(userFreelancerHasSkillService.update(userFreelancerHasSkill)){
            return "UserFreelancerHasSkill Updated!";
        }
        return "UserFreelancerHasSkill Not Found!";
    }

    @RequestMapping(value = "/{f_id}/{s_id}", //
            method = RequestMethod.DELETE, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteUserFreelancerHasSkill(@PathVariable Integer f_id, @PathVariable Integer s_id){
        if(userFreelancerHasSkillService.delete(f_id, s_id)){
            return "UserFreelancerHasSkill Deleted!";
        }
        return "UserFreelancerHasSkill Not Found!";
    }
}
