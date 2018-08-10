package app.controller;

import app.model.Identity.JobRequireSkillIdentity;
import app.model.JobRequireSkill;
import app.services.JobRequireSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value="/jobquireskill")
public class JobRequireSkillController {
    @Autowired
    JobRequireSkillService jobRequireSkillService;

    //show List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<JobRequireSkill> getJobRequireSkillList() {
        ArrayList<JobRequireSkill> list = jobRequireSkillService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/{jobsId}{skillsId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<JobRequireSkill> getJobRequireSkill(@PathVariable("jobsId") String jobsId,
                                                        @PathVariable("skillsId") String skillsId) {
        return jobRequireSkillService.getJobRequireSkill(new JobRequireSkillIdentity(Integer.valueOf(jobsId),Integer.valueOf(skillsId)));
    }

    //Add
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobRequireSkill addJobRequireSkill(@RequestBody JobRequireSkill jobRequireSkill) {

        System.out.println("(Service Side) Creating: " + jobRequireSkill.getJobRequireSkillIdentity().toString());
        jobRequireSkillService.addJobRequireSkill(jobRequireSkill);
        return jobRequireSkill;
    }

    //Edit
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobRequireSkill updateJobRequireSkill(@RequestBody JobRequireSkill jobRequireSkill) {

        System.out.println("(Service Side) Editing: " + jobRequireSkill.getJobRequireSkillIdentity().getJobId());
        jobRequireSkillService.editJobRequireSkill(jobRequireSkill);
        return jobRequireSkill;
    }

    //Delete
    @RequestMapping(value = "/{jobsId}/{skillsId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteJobRequireSkill(@PathVariable("jobsId") String jobsId,
                                      @PathVariable("skillsId") String skillsId) {

        System.out.println("(Service Side) Deleting: " + new JobRequireSkillIdentity(Integer.valueOf(jobsId),Integer.valueOf(skillsId)).toString());

        jobRequireSkillService.deleteJobRequireSkill(new JobRequireSkillIdentity(Integer.valueOf(jobsId),Integer.valueOf(skillsId)));
    }
}
