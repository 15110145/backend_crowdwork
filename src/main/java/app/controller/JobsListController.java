package app.controller;

import app.model.JobRequireProfessionJob;
import app.model.Jobs;
import app.services.JobCategoryService;
import app.services.JobsService;
import app.services.ProfessionJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/jobs")
public class JobsListController {
    @Autowired
    JobsService jobsService;

    @Autowired
    JobCategoryService jobCategoryService;

    @Autowired
    ProfessionJobService professionJobService;

    //filter job list by category
    @RequestMapping(value = "/list/jobcategory={jobCategoryId}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Jobs> getJobsListWithJobCategory(@PathVariable("jobCategoryId") String jobCategoryId) {
        List<Jobs> list = jobCategoryService.getJobCategory(Integer.valueOf(jobCategoryId)).get().getJobsList();
        return list;
    }

    //filter job list by profession
    @RequestMapping(value = "/list/profession={professionJobId}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Jobs> getJobsListWithProfessionJob(@PathVariable("professionJobId") String professionJobId) {
        List<JobRequireProfessionJob> listJobRequireSkill = professionJobService.getProfessionJob(Integer.valueOf(professionJobId)).get().getJobRequireProfessionJobList();
        List<Jobs> list = new ArrayList<>();
        for (JobRequireProfessionJob jobRequireProfessionJob: listJobRequireSkill)
        {
            list.add(jobRequireProfessionJob.getJobs());
        }
        return list;
    }

    //filter job no exp required
    @RequestMapping(value = "/list/noexp",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Jobs> getJobsListNoExpRequirement() {
        ArrayList<Jobs> list = jobsService.findAllJobsNoExperience();
        return list;
    }

    //filter job no exp required
    @RequestMapping(value = "/list/withexp",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Jobs> getJobsListWithExpRequirement() {
        ArrayList<Jobs> list = jobsService.findAllJobsWithExperience();
        return list;
    }
}
