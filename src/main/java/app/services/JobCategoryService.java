package app.services;

import app.model.JobCategory;
import app.model.Jobs;
import app.repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
public class JobCategoryService {

    @Autowired
    JobCategoryRepository jobCategoryRepository;

    public ArrayList<JobCategory> findAll()
    {
        ArrayList<JobCategory> lstJobCategory = new ArrayList<>();
        for (JobCategory jobs: jobCategoryRepository.findAll())
        {
            lstJobCategory.add(jobs);
        }
        return lstJobCategory;
    }

    public JobCategory findbyIdandName(Integer Id,String name)
    {
        return jobCategoryRepository.findJobCategoriesByIdAndName(Id,name);
    }

    public JobCategory getJobCategory(Integer jobCategoryId)
    {
        return jobCategoryRepository.findById(jobCategoryId).get();
    }

//    public void addJobCategory(JobCategory jobCategory,Integer currentUser)
//    {
//        JobCategory jobCategoryAdd = new JobCategory(
//                jobCategory.getName(),
//                Boolean.FALSE,
//                currentUser,
//                null,
//                new Date(),
//                null
//        );
//        jobCategoryRepository.save(jobCategoryAdd);
//    }

    public void editJobCategory(Integer jobCategoryId, JobCategory editedJobCategory, Integer currentUser)
    {
        JobCategory newJobCategory = getJobCategory(jobCategoryId);
        newJobCategory.setName(editedJobCategory.getName());
        newJobCategory.setUpdateUser(currentUser);
        newJobCategory.setUpdateTime(new Date());
        jobCategoryRepository.save(newJobCategory);
    }

    public void deleteJobCategory(Integer jobCategoryId)
    {
        JobCategory deletedJobCategory = getJobCategory(jobCategoryId);
        deletedJobCategory.setDelFlag(Boolean.TRUE);
        jobCategoryRepository.save(deletedJobCategory);
    }
}
