package app.services;

import app.model.Identity.UserFreelancerHasJobIdentity;
import app.model.UserFreelancerHasJob;
import app.repository.UserFreelancerHasJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserFreelancerHasJobService {

    @Autowired
    UserFreelancerHasJobRepository userFreelancerHasJobRepository;

    public List<UserFreelancerHasJob> findAllUserFreelancerHasJob(){
        return userFreelancerHasJobRepository.findAllByDelFlag(false);
    }

    public Optional<UserFreelancerHasJob> findUserFreelancerHasJob(Integer f_id, Integer j_id){//f_id: freelancer_id, j_id:job_id
        UserFreelancerHasJobIdentity userFreelancerHasJobIdentity = new UserFreelancerHasJobIdentity(f_id,j_id);
        return userFreelancerHasJobRepository.findByUserFreelancerHasJobIdentityAndDelFlag(userFreelancerHasJobIdentity, false);
    }

    public void save(UserFreelancerHasJob userFreelancerHasJob){
        userFreelancerHasJobRepository.save(userFreelancerHasJob);
    }

    public Boolean update(UserFreelancerHasJob userFreelancerHasJob){
        Optional<UserFreelancerHasJob> userFreelancerHasJob1 = findUserFreelancerHasJob(userFreelancerHasJob.getUserFreelancerHasJobIdentity().getUsersFreelancerId(),userFreelancerHasJob.getUserFreelancerHasJobIdentity().getJobId());
        if (!userFreelancerHasJob1.isPresent()){
            UserFreelancerHasJob existingUserFreelancerHasJob = userFreelancerHasJob1.get();
            if (userFreelancerHasJob.getDateStart() != null){
                existingUserFreelancerHasJob.setDateStart(userFreelancerHasJob.getDateStart());
            }
            if (userFreelancerHasJob.getDateEnd() != null){
                existingUserFreelancerHasJob.setDateEnd(userFreelancerHasJob.getDateEnd());
            }
            if (userFreelancerHasJob.getFileURL() != null){
                existingUserFreelancerHasJob.setFileURL(userFreelancerHasJob.getFileURL());
            }
            if (userFreelancerHasJob.getDelFlag() != null){
                existingUserFreelancerHasJob.setDelFlag(userFreelancerHasJob.getDelFlag());
            }
            userFreelancerHasJobRepository.save(existingUserFreelancerHasJob);
            return true;
        }
        return false;
    }

    public Boolean delete(Integer f_id, Integer j_id) {
        Optional<UserFreelancerHasJob> userFreelancerHasJob1 = findUserFreelancerHasJob(f_id, j_id);
        if (!userFreelancerHasJob1.isPresent()) {
            UserFreelancerHasJob existingUserFreelancerHasJob = userFreelancerHasJob1.get();
            existingUserFreelancerHasJob.setDelFlag(true);
            userFreelancerHasJobRepository.save(existingUserFreelancerHasJob);
            return true;
        }
        return false;
    }
}
