package app.services;

import app.model.JobCategory;
import app.model.Jobs;
import app.model.ProfessionJob;
import app.repository.JobRequireProfessionJobRepository;
import app.repository.JobsRepository;
import app.repository.ProfessionJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class JobsService {

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    JobRequireProfessionJobRepository jobRequireProfessionJobRepository;

    @Autowired
    JobCategoryService jobCategory;

    public ArrayList<Jobs> findAllJobs(){
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        lstJobs.addAll(jobsRepository.findAllByDelFlag(Boolean.FALSE));
        return lstJobs;
    }

    public Optional<Jobs> findJobsById(Integer id){
        return jobsRepository.findByIdAndDelFlag(id,Boolean.FALSE);
    }

    public ArrayList<Jobs> findAllJobsNoExperience() {
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        lstJobs.addAll(jobsRepository.findJobsNoExperience());
        return lstJobs;
    }

    public ArrayList<Jobs> findAllJobsWithExperience() {
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        lstJobs.addAll(jobsRepository.findJobsWithExperience());
        return lstJobs;
    }

    public ArrayList<Jobs> findAllJobByCategory(JobCategory jobCategory) {
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        lstJobs.addAll(jobsRepository.findAllJobByCategory(jobCategory));
        return lstJobs;
    }

    public List<Jobs> findAllJobByProfession(List<ProfessionJob> lstProfessionJobs) {
        List<Jobs> lstJob = jobRequireProfessionJobRepository.findAllJobByProfession(lstProfessionJobs);
        Set<Jobs> jobsSet= new HashSet<>();
        jobsSet.addAll(lstJob);
        lstJob.clear();
        lstJob.addAll(jobsSet);
        return lstJob;
    }

    public List<Jobs> findAllJobByProfessionAndCategory(List<ProfessionJob> lstProfessionJobs,List<Jobs> lstJobs) {
        List<Jobs> lstJob = jobRequireProfessionJobRepository.findAllJobByProfessionAndCategory(lstProfessionJobs,lstJobs);
        Set<Jobs> jobsSet= new HashSet<>();
        jobsSet.addAll(lstJob);
        lstJob.clear();
        lstJob.addAll(jobsSet);
        return lstJob;
    }

    /*
    Admin
     */

    public ArrayList<Jobs> findAll() {
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        lstJobs.addAll(jobsRepository.findAll());
        return lstJobs;
    }

    public Optional<Jobs> getJobs(Integer jobId)
    {
        return jobsRepository.findById(jobId);
    }

    public void addJobs(Jobs jobs) {
        jobs.setDelFlag(Boolean.FALSE);
        jobsRepository.save(jobs);
    }

    public void editJobs(Jobs editedjobs) {
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

    public void deleteJobs(Integer jobsId) {
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
