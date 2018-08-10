package app.controller;

import app.model.Identity.UserRecruiterJobRequirementIdentity;
import app.model.UserRecruiterJobRequirement;
import app.services.UserRecruiterJobRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value="userrecruiterjobrequirement")
public class UserRecruiterJobRequirementController {

    @Autowired
    UserRecruiterJobRequirementService userRecruiterJobRequirementService;

    //show List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<UserRecruiterJobRequirement> getUserRecruiterJobRequirementList() {
        ArrayList<UserRecruiterJobRequirement> list = userRecruiterJobRequirementService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/{usersRecruiterId}/{professionJobId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<UserRecruiterJobRequirement> getUserRecruiterJobRequirement(@PathVariable("usersRecruiterId") String usersRecruiterId,
                                                        @PathVariable("professionJobId") String professionJobId) {
        return userRecruiterJobRequirementService.getUserRecruiterJobRequirement(new UserRecruiterJobRequirementIdentity(Integer.valueOf(usersRecruiterId),Integer.valueOf(professionJobId)));
    }

    //Add
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public UserRecruiterJobRequirement addUserRecruiterJobRequirement(@RequestBody UserRecruiterJobRequirement userRecruiterJobRequirement) {

        System.out.println("(Service Side) Creating: " + userRecruiterJobRequirement.getUserRecruiterJobRequirementIdentity().toString());
        userRecruiterJobRequirementService.addUserRecruiterJobRequirement(userRecruiterJobRequirement);
        return userRecruiterJobRequirement;
    }

    //Edit
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public UserRecruiterJobRequirement updateUserRecruiterJobRequirement(@RequestBody UserRecruiterJobRequirement userRecruiterJobRequirement) {

        System.out.println("(Service Side) Editing: " + userRecruiterJobRequirement.getUserRecruiterJobRequirementIdentity());
        userRecruiterJobRequirementService.editUserRecruiterJobRequirement(userRecruiterJobRequirement);
        return userRecruiterJobRequirement;
    }

    //Delete
    @RequestMapping(value = "/{usersRecruiterId}/{professionJobId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteUserRecruiterJobRequirement(@PathVariable("usersRecruiterId") String usersRecruiterId,
                                      @PathVariable("professionJobId") String professionJobId) {

        System.out.println("(Service Side) Deleting: " + new UserRecruiterJobRequirementIdentity(Integer.valueOf(usersRecruiterId),Integer.valueOf(professionJobId)).toString());

        userRecruiterJobRequirementService.deleteUserRecruiterJobRequirement(new UserRecruiterJobRequirementIdentity(Integer.valueOf(usersRecruiterId),Integer.valueOf(professionJobId)));
    }
}
