package app.controller;


import app.model.JobCategory;
import app.services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class JobCategoryController {

    @Autowired
    JobCategoryService jobCategoryService;

    //show Job Category List
    @RequestMapping(value = "/jobcategorylist",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ArrayList<JobCategory> getJobCategoryList() {
        ArrayList<JobCategory> list = jobCategoryService.findAll();
        return list;
    }

    //Find particular JobCategory
    @RequestMapping(value = "/jobcategory/{jobCategoryId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobCategory getJobCategory(@PathVariable("jobCategoryId") String jobCategoryId) {
        return jobCategoryService.getJobCategory(Integer.valueOf(jobCategoryId));
    }

//    //Find particular JobCategory
//    @RequestMapping(value = "/jobcategory1", //
//            method = RequestMethod.GET, //
//            produces = { MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public JobCategory getJobCategory1(@RequestParam("Id") String jobCategoryId,
//                                       @RequestParam("Name") String jobCategoryName) {
//        return jobCategoryService.findbyIdandName(Integer.valueOf(jobCategoryId),jobCategoryName);
//    }
    //Add JobCategory
    @RequestMapping(value = "/jobcategory", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobCategory addJobCategory(@RequestBody JobCategory jobCategory) {

        System.out.println("(Service Side) Creating jobCategory: " + jobCategory.getId());
        jobCategoryService.addJobCategory(jobCategory,0);
        return jobCategory;
    }

    //
    @RequestMapping(value = "/jobcategory", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JobCategory updateEmployee(@RequestBody JobCategory jobCategory) {

        System.out.println("(Service Side) Editing JobCategory: " + jobCategory.getId());
        jobCategoryService.editJobCategory(jobCategory.getId(),jobCategory,0);
        return jobCategory;
    }

    //
    @RequestMapping(value = "/jobcategory/{jobCategoryId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteJobCategory(@PathVariable("jobCategoryId") String jobCategoryId) {

        System.out.println("(Service Side) Deleting JobCategory: " + jobCategoryId);

        jobCategoryService.deleteJobCategory(Integer.valueOf(jobCategoryId));
    }
}
