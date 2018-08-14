package app.services;

import app.model.JobCategory;
import app.model.Jobs;
import app.repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class JobCategoryService {

    @Autowired
    JobCategoryRepository jobCategoryRepository;

    public ArrayList<JobCategory> findAllJobCategory(){
        ArrayList<JobCategory> lstJobCategory = new ArrayList<>();
        lstJobCategory.addAll(jobCategoryRepository.findAllJobCategory());
        return lstJobCategory;
    }

    public Optional<JobCategory> findJobCategoryById(Integer id){
        return jobCategoryRepository.findJobCategoryById(id);
    }

    /*
    Admin
     */

    public ArrayList<JobCategory> findAll() {
        ArrayList<JobCategory> lstJobCategory = new ArrayList<>();
        lstJobCategory.addAll(jobCategoryRepository.findAll());
        return lstJobCategory;
    }

    public Optional<JobCategory> getJobCategory(Integer jobCategoryId) {
        return jobCategoryRepository.findById(jobCategoryId);
    }

    public void addJobCategory(JobCategory jobCategory) {
        jobCategory.setDelFlag(Boolean.FALSE);
        jobCategoryRepository.save(jobCategory);
    }

    public void editJobCategory(JobCategory editedJobCategory) {
        Optional<JobCategory> optionalJobCategory = getJobCategory(editedJobCategory.getId());
        if(optionalJobCategory.isPresent()) {
            JobCategory jobCategory = optionalJobCategory.get();
            jobCategory.setName(editedJobCategory.getName());
            jobCategoryRepository.save(jobCategory);
        }
        else
        {

        }
    }

    public void deleteJobCategory(Integer jobCategoryId) {
        Optional<JobCategory> optionalJobCategory = getJobCategory(jobCategoryId);
        if(optionalJobCategory.isPresent()) {
            JobCategory jobCategory = optionalJobCategory.get();
            jobCategory.setDelFlag(Boolean.TRUE);
            jobCategoryRepository.save(jobCategory);
        }
        else {

        }
    }
}
