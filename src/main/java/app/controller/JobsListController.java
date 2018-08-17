package app.controller;

import app.model.Contracts;
import app.model.JobRequireProfessionJob;
import app.model.Jobs;
import app.services.*;
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

    @Autowired
    UsersRecruiterService usersRecruiterService;

    @Autowired
    UsersFreelancerService usersFreelancerService;

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
//        List<JobRequireProfessionJob> listJobRequireSkill = professionJobService.getProfessionJob(Integer.valueOf(professionJobId)).get().getJobRequireProfessionJobList();
//        List<Jobs> list = new ArrayList<>();
//        for (JobRequireProfessionJob jobRequireProfessionJob: listJobRequireSkill)
//        {
//            list.add(jobRequireProfessionJob.getJobs());
//        }

        return jobsService.findAllJobByProfession(professionJobService.getAllChildProfessionJob(Integer.valueOf(professionJobId)));
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

    //recruiter's job list
    @RequestMapping(value = "/list/recruiter={recruiterId}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Jobs> getJobsListRecruiter(@PathVariable("recruiterId") String recruiterId) {
        List<Jobs> list = usersRecruiterService.findUserRecruiter(Integer.valueOf(recruiterId)).get().getJobs();
        return list;
    }

    //freelancer's contract list
    @RequestMapping(value = "/list/freelancer={freelancerId}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Jobs> getJobsListFreelancer(@PathVariable("freelancerId") String freelancerId) {
        List<Contracts> contractsList = usersFreelancerService.findUserFreelancer(Integer.valueOf(freelancerId)).get().getContracts();
        List<Jobs> list = new ArrayList<>();
        for (Contracts contracts: contractsList)
        {
            list.add(contracts.getJobs());
        }
        return list;
    }
}
