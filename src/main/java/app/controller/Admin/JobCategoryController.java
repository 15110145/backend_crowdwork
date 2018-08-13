package app.controller.Admin;


import app.model.JobCategory;
import app.services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value="/admin/jobcategory")
public class JobCategoryController {

    @Autowired
    JobCategoryService jobCategoryService;

    //show Job Category List
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<JobCategory> getJobCategoryList() {
        ArrayList<JobCategory> list = jobCategoryService.findAll();
        return list;
    }

    //Find particular JobCategory
    @RequestMapping(value = "/{jobCategoryId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Optional<JobCategory> getJobCategory(@PathVariable("jobCategoryId") String jobCategoryId) {
        return jobCategoryService.getJobCategory(Integer.valueOf(jobCategoryId));
    }

    //Add JobCategory
    @RequestMapping(value = "/", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobCategory addJobCategory(@RequestBody JobCategory jobCategory) {

        System.out.println("(Service Side) Creating jobCategory: " + jobCategory.getId());
        jobCategoryService.addJobCategory(jobCategory);
        return jobCategory;
    }

    //
    @RequestMapping(value = "/", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobCategory updateEmployee(@RequestBody JobCategory jobCategory) {

        System.out.println("(Service Side) Editing JobCategory: " + jobCategory.getId());
        jobCategoryService.editJobCategory(jobCategory);
        return jobCategory;
    }

    //
    @RequestMapping(value = "/{jobCategoryId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteJobCategory(@PathVariable("jobCategoryId") String jobCategoryId) {

        System.out.println("(Service Side) Deleting JobCategory: " + jobCategoryId);

        jobCategoryService.deleteJobCategory(Integer.valueOf(jobCategoryId));
    }
}
