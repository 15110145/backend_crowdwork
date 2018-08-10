package app.services;

import app.model.Identity.UserFreelancerHasSkillIdentity;
import app.model.UserFreelancerHasSkill;
import app.repository.UserFreelancerhasSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserFreelancerHasSkillService {

    @Autowired
    UserFreelancerhasSkillRepository userFreelancerhasSkillRepository;

    public List<UserFreelancerHasSkill> findAllUserFreelancerHasSkill(){
        return userFreelancerhasSkillRepository.findAllByDelFlag(false);
    }

    public List<UserFreelancerHasSkill> findUserFreelancerHasSkill(Integer f_id, Integer s_id){//f_id: freelancer_id, s_id: status_id
        UserFreelancerHasSkillIdentity userFreelancerHasSkillIdentity = new UserFreelancerHasSkillIdentity(f_id,s_id);
        return userFreelancerhasSkillRepository.findByUserFreelancerHasSkillIdentityAndDelFlag(userFreelancerHasSkillIdentity, false);
    }

    public void save(UserFreelancerHasSkill userFreelancerHasSkill){
        userFreelancerhasSkillRepository.save(userFreelancerHasSkill);
    }

    public Boolean update(UserFreelancerHasSkill userFreelancerHasSkill){
        List<UserFreelancerHasSkill> userFreelancerHasSkill1 = findUserFreelancerHasSkill(userFreelancerHasSkill.getUserFreelancerHasSkillIdentity().getUsersFreelancerId(),userFreelancerHasSkill.getUserFreelancerHasSkillIdentity().getSkillId());
        if (!userFreelancerHasSkill1.isEmpty()){
            UserFreelancerHasSkill existingUserFreelancerHasSkill = userFreelancerHasSkill1.get(0);
            if (userFreelancerHasSkill.getDelFlag() != null){
                existingUserFreelancerHasSkill.setDelFlag(userFreelancerHasSkill.getDelFlag());
            }
            if (userFreelancerHasSkill.getDescription() != null){
                existingUserFreelancerHasSkill.setDescription(userFreelancerHasSkill.getDescription());
            }
            if (userFreelancerHasSkill.getExperience() != null){
                existingUserFreelancerHasSkill.setExperience(userFreelancerHasSkill.getExperience());
            }
            if (userFreelancerHasSkill.getLevel() != null) {
                existingUserFreelancerHasSkill.setLevel(userFreelancerHasSkill.getLevel());
            }
            userFreelancerhasSkillRepository.save(existingUserFreelancerHasSkill);
            return true;
        }
        return false;
    }

    public Boolean delete(Integer f_id, Integer s_id) {
        List<UserFreelancerHasSkill> userFreelancerHasSkill1 = findUserFreelancerHasSkill(f_id, s_id);
        if (!userFreelancerHasSkill1.isEmpty()) {
            UserFreelancerHasSkill existingUserFreelancerHasSkill = userFreelancerHasSkill1.get(0);
            existingUserFreelancerHasSkill.setDelFlag(true);
            userFreelancerhasSkillRepository.save(existingUserFreelancerHasSkill);
            return true;
        }
        return false;
    }
}
