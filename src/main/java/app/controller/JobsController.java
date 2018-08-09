package app.controller;

import app.model.Jobs;
import app.services.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class JobsController {

    @Autowired
    JobsService jobsService;

    //show List
    @RequestMapping(value = "/jobslist",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<Jobs> getJobsList() {
        ArrayList<Jobs> list = jobsService.findAll();
        return list;
    }

    //Find particular
    @RequestMapping(value = "/jobs/{jobsId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<Jobs> getJobs(@PathVariable("jobsId") String jobsId) {
        return jobsService.getJobs(Integer.valueOf(jobsId));
    }

    //Add
    @RequestMapping(value = "/jobs", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Jobs addJobs(@RequestBody Jobs jobs) {

        System.out.println("(Service Side) Creating: " + jobs.getId());
        jobsService.addJobs(jobs);
        return jobs;
    }

    //Edit
    @RequestMapping(value = "/jobs", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Jobs updateJobs(@RequestBody Jobs jobs) {

        System.out.println("(Service Side) Editing: " + jobs.getId());
        jobsService.editJobs(jobs);
        return jobs;
    }

    //Delete
    @RequestMapping(value = "/jobs/{jobsId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteJobs(@PathVariable("jobsId") String jobsId) {

        System.out.println("(Service Side) Deleting: " + jobsId);

        jobsService.deleteJobs(Integer.valueOf(jobsId));
    }
}
