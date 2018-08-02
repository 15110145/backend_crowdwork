package app.services;

import app.model.Jobs;
import app.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class JobService {

    @Autowired
    JobsRepository jobsRepository;

    public ArrayList<Jobs> findAll()
    {
        ArrayList<Jobs> lstJobs = new ArrayList<>();
        for (Jobs jobs: jobsRepository.findAll())
        {
            lstJobs.add(jobs);
        }
        return lstJobs;
    }

    public Jobs getJobs(Integer jobId)
    {
        return jobsRepository.findById(jobId).get();
    }


}
