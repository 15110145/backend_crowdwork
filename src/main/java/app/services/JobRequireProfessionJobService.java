package app.services;

import app.model.Identity.JobRequireProfessionJobIdentity;
import app.model.JobRequireProfessionJob;
import app.repository.JobRequireProfessionJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class JobRequireProfessionJobService {
    @Autowired
    JobRequireProfessionJobRepository jobRequireProfessionJobRepository;

    public ArrayList<JobRequireProfessionJob> findAll() {
        ArrayList<JobRequireProfessionJob> lstJobRequireProfessionJob = new ArrayList<>();
        lstJobRequireProfessionJob.addAll(jobRequireProfessionJobRepository.findAll());
        return lstJobRequireProfessionJob;
    }

    public Optional<JobRequireProfessionJob> getJobRequireProfessionJob(JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity) {
        return jobRequireProfessionJobRepository.findById(jobRequireProfessionJobIdentity);
    }

    public void addJobRequireProfessionJob(JobRequireProfessionJob jobRequireProfessionJob) {
        jobRequireProfessionJob.setDelFlag(Boolean.FALSE);
        jobRequireProfessionJobRepository.save(jobRequireProfessionJob);
    }

    public void editJobRequireProfessionJob(JobRequireProfessionJob editedJobRequireProfessionJob) {
        Optional<JobRequireProfessionJob> optionalJobRequireProfessionJob = getJobRequireProfessionJob(editedJobRequireProfessionJob.getJobRequireProfessionJobIdentity());
        if(optionalJobRequireProfessionJob.isPresent()) {
            JobRequireProfessionJob jobRequireProfessionJob = optionalJobRequireProfessionJob.get();
            if (editedJobRequireProfessionJob.getDelFlag() != null){
                jobRequireProfessionJob.setDelFlag(editedJobRequireProfessionJob.getDelFlag());
            }
            if (editedJobRequireProfessionJob.getJobs() != null){
                jobRequireProfessionJob.setJobs(editedJobRequireProfessionJob.getJobs());
            }
            if (editedJobRequireProfessionJob.getProfessionJob() != null){
                jobRequireProfessionJob.setProfessionJob(editedJobRequireProfessionJob.getProfessionJob());
            }
            jobRequireProfessionJobRepository.save(jobRequireProfessionJob);
        }
        else
        {

        }
        //jobRequireProfessionJobRepository.save(editedJobRequireProfessionJob);
    }

    public void deleteJobRequireProfessionJob(JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity) {
        Optional<JobRequireProfessionJob> optionalJobRequireProfessionJob = getJobRequireProfessionJob(jobRequireProfessionJobIdentity);
        if(optionalJobRequireProfessionJob.isPresent()) {
            JobRequireProfessionJob jobRequireProfessionJob = optionalJobRequireProfessionJob.get();
//            jobRequireProfessionJob.setDelFlag(Boolean.TRUE);
//            jobRequireProfessionJobRepository.save(jobRequireProfessionJob);
            jobRequireProfessionJobRepository.delete(jobRequireProfessionJob);
        }
        else
        {

        }
    }
}
