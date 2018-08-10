package app.controller;

import app.model.Identity.UserFreelancerJobRequirementIdentity;
import app.model.UserFreelancerJobRequirement;
import app.services.UserFreelancerJobRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value ="/userfreelancerjobrequirement")
public class UserFreelancerJobRequirementController {

    @Autowired
    UserFreelancerJobRequirementService userFreelancerJobRequirementService;

    //show List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<UserFreelancerJobRequirement> getUserFreelancerJobRequirementList() {
        ArrayList<UserFreelancerJobRequirement> list = userFreelancerJobRequirementService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/{usersFreelancerId}/{professionJobId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<UserFreelancerJobRequirement> getUserFreelancerJobRequirement(@PathVariable("usersFreelancerId") String usersFreelancerId,
                                                        @PathVariable("professionJobId") String professionJobId) {
        return userFreelancerJobRequirementService.getUserFreelancerJobRequirement(new UserFreelancerJobRequirementIdentity(Integer.valueOf(usersFreelancerId),Integer.valueOf(professionJobId)));
    }

    //Add
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public UserFreelancerJobRequirement addUserFreelancerJobRequirement(@RequestBody UserFreelancerJobRequirement userFreelancerJobRequirement) {

        System.out.println("(Service Side) Creating: " + userFreelancerJobRequirement.getUserFreelancerJobRequirementIdentity().toString());
        userFreelancerJobRequirementService.addUserFreelancerJobRequirement(userFreelancerJobRequirement);
        return userFreelancerJobRequirement;
    }

    //Edit
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public UserFreelancerJobRequirement updateUserFreelancerJobRequirement(@RequestBody UserFreelancerJobRequirement userFreelancerJobRequirement) {

        System.out.println("(Service Side) Editing: " + userFreelancerJobRequirement.getUserFreelancerJobRequirementIdentity());
        userFreelancerJobRequirementService.editUserFreelancerJobRequirement(userFreelancerJobRequirement);
        return userFreelancerJobRequirement;
    }

    //Delete
    @RequestMapping(value = "/{usersFreelancerId}/{professionJobId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteUserFreelancerJobRequirement(@PathVariable("usersFreelancerId") String usersFreelancerId,
                                      @PathVariable("professionJobId") String professionJobId) {

        System.out.println("(Service Side) Deleting: " + new UserFreelancerJobRequirementIdentity(Integer.valueOf(usersFreelancerId),Integer.valueOf(professionJobId)).toString());

        userFreelancerJobRequirementService.deleteUserFreelancerJobRequirement(new UserFreelancerJobRequirementIdentity(Integer.valueOf(usersFreelancerId),Integer.valueOf(professionJobId)));
    }
}
