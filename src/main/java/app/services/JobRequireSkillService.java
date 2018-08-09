package app.services;

import app.model.Identity.JobRequireProfessionJobIdentity;
import app.model.Identity.JobRequireSkillIdentity;
import app.model.JobRequireSkill;
import app.repository.JobRequireSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class JobRequireSkillService {

    @Autowired
    JobRequireSkillRepository jobRequireSkillRepository;
    
    public ArrayList<JobRequireSkill> findAll()
    {
        ArrayList<JobRequireSkill> lstJobRequireSkill = new ArrayList<>();
        lstJobRequireSkill.addAll(jobRequireSkillRepository.findAll());
        return lstJobRequireSkill;
    }

    public Optional<JobRequireSkill> getJobRequireSkill(JobRequireSkillIdentity jobRequireSkillIdentity)
    {
        return jobRequireSkillRepository.findById(jobRequireSkillIdentity);
    }

    public void addJobRequireSkill(JobRequireSkill jobRequireSkill)
    {
        jobRequireSkill.setDelFlag(Boolean.FALSE);
        jobRequireSkillRepository.save(jobRequireSkill);
    }

    public void editJobRequireSkill(JobRequireSkill editedJobRequireSkill)
    {
        Optional<JobRequireSkill> optionalJobRequireSkill = getJobRequireSkill(editedJobRequireSkill.getJobRequireSkillIdentity());
        if(optionalJobRequireSkill.isPresent()) {
            JobRequireSkill jobRequireSkill = optionalJobRequireSkill.get();
            if (editedJobRequireSkill.getDelFlag() != null){
                jobRequireSkill.setDelFlag(editedJobRequireSkill.getDelFlag());
            }
            if (editedJobRequireSkill.getJobs() != null){
                jobRequireSkill.setJobs(editedJobRequireSkill.getJobs());
            }
            if (editedJobRequireSkill.getSkills() != null){
                jobRequireSkill.setSkills(editedJobRequireSkill.getSkills());
            }
            jobRequireSkillRepository.save(jobRequireSkill);
        }
        else
        {

        }
        //jobRequireSkillRepository.save(editedJobRequireSkill);
    }

    public void deleteJobRequireSkill(JobRequireSkillIdentity jobRequireSkillIdentity)
    {
        Optional<JobRequireSkill> optionalJobRequireSkill = getJobRequireSkill(jobRequireSkillIdentity);
        if(optionalJobRequireSkill.isPresent()) {
            JobRequireSkill jobRequireSkill = optionalJobRequireSkill.get();
            jobRequireSkill.setDelFlag(Boolean.TRUE);
            jobRequireSkillRepository.save(jobRequireSkill);
        }
        else
        {
        }
    }
}
