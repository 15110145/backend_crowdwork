package app.services;

import app.model.Jobs;
import app.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class JobsService {

    @Autowired
    JobsRepository jobsRepository;

    public ArrayList<Jobs> findAll()
    {
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        lstJobs.addAll(jobsRepository.findAll());
        return lstJobs;
    }

    public Optional<Jobs> getJobs(Integer jobId)
    {
        return jobsRepository.findById(jobId);
    }

    public void addJobs(Jobs jobs)
    {
        jobs.setDelFlag(Boolean.FALSE);
        jobsRepository.save(jobs);
    }

    public void editJobs(Jobs editedjobs)
    {
        Optional<Jobs> optionalJobs = getJobs(editedjobs.getId());
        if(optionalJobs.isPresent()) {
            Jobs jobs = optionalJobs.get();
            if (editedjobs.getTitle() != null){
                jobs.setTitle(editedjobs.getTitle());
            }
            if (editedjobs.getDeadline() != null){
                jobs.setDeadline(editedjobs.getDeadline());
            }
            if (editedjobs.getDelFlag() != null){
                jobs.setDelFlag(editedjobs.getDelFlag());
            }
            if (editedjobs.getDescription() != null){
                jobs.setDescription(editedjobs.getDescription());
            }
            if (editedjobs.getExperience() != null){
                jobs.setExperience(editedjobs.getExperience());
            }
            if (editedjobs.getJobCategory() != null){
                jobs.setJobCategory(editedjobs.getJobCategory());
            }
            if (editedjobs.getJobName() != null){
                jobs.setJobName(editedjobs.getJobName());
            }
            if (editedjobs.getSalary() != null){
                jobs.setSalary(editedjobs.getSalary());
            }
            if (editedjobs.getSlot() != null){
                jobs.setSlot(editedjobs.getSlot());
            }
            if (editedjobs.getStatus() != null){
                jobs.setStatus(editedjobs.getStatus());
            }
            if (editedjobs.getUsersRecruiter() != null){
                jobs.setUsersRecruiter(editedjobs.getUsersRecruiter());
            }
            jobsRepository.save(jobs);
        }
        else
        {

        }
    }

    public void deleteJobs(Integer jobsId)
    {
        Optional<Jobs> optionalJobs = getJobs(jobsId);
        if(optionalJobs.isPresent()) {
            Jobs jobs = optionalJobs.get();
            jobs.setDelFlag(Boolean.TRUE);
            jobsRepository.save(jobs);
        }
        else
        {

        }
    }
}