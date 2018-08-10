package app.controller;

import app.model.Identity.JobRequireProfessionJobIdentity;
import app.model.JobRequireProfessionJob;
import app.services.JobRequireProfessionJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value="/jobrequireprofessionjob")
public class JobRequireProfessionJobController {

    @Autowired
    JobRequireProfessionJobService jobRequireProfessionJobService;

    //show List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<JobRequireProfessionJob> getJobRequireProfessionJobList() {
        ArrayList<JobRequireProfessionJob> list = jobRequireProfessionJobService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/{jobsId}/{professionJobId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<JobRequireProfessionJob> getJobRequireProfessionJob(@PathVariable("jobsId") String jobsId,
                                                        @PathVariable("professionJobId") String professionJobId) {
        return jobRequireProfessionJobService.getJobRequireProfessionJob(new JobRequireProfessionJobIdentity(Integer.valueOf(jobsId),Integer.valueOf(professionJobId)));
    }

    //Add
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobRequireProfessionJob addJobRequireProfessionJob(@RequestBody JobRequireProfessionJob jobRequireProfessionJob) {

        System.out.println("(Service Side) Creating: " + jobRequireProfessionJob.getJobRequireProfessionJobIdentity().toString());
        jobRequireProfessionJobService.addJobRequireProfessionJob(jobRequireProfessionJob);
        return jobRequireProfessionJob;
    }

    //Edit
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobRequireProfessionJob updateJobRequireProfessionJob(@RequestBody JobRequireProfessionJob jobRequireProfessionJob) {

        System.out.println("(Service Side) Editing: " + jobRequireProfessionJob.getJobRequireProfessionJobIdentity().getJobId());
        jobRequireProfessionJobService.editJobRequireProfessionJob(jobRequireProfessionJob);
        return jobRequireProfessionJob;
    }

    //Delete
    @RequestMapping(value = "/{jobsId}/{professionJobId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteJobRequireProfessionJob(@PathVariable("jobsId") String jobsId,
                                      @PathVariable("professionJobId") String professionJobId) {

        System.out.println("(Service Side) Deleting: " + new JobRequireProfessionJobIdentity(Integer.valueOf(jobsId),Integer.valueOf(professionJobId)).toString());

        jobRequireProfessionJobService.deleteJobRequireProfessionJob(new JobRequireProfessionJobIdentity(Integer.valueOf(jobsId),Integer.valueOf(professionJobId)));
    }
}
