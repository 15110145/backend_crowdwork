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
        return userFreelancerhasSkillRepository.findAll();
    }

    public Optional<UserFreelancerHasSkill> findUserFreelancerHasSkill(Integer f_id, Integer s_id){//f_id: freelancer_id, s_id: status_id
        UserFreelancerHasSkillIdentity userFreelancerHasSkillIdentity = new UserFreelancerHasSkillIdentity(f_id,s_id);
        return userFreelancerhasSkillRepository.findById(userFreelancerHasSkillIdentity);
    }

    public void save(UserFreelancerHasSkill userFreelancerHasSkill){
        userFreelancerhasSkillRepository.save(userFreelancerHasSkill);
    }

    public void update(UserFreelancerHasSkill userFreelancerHasSkill){
        Optional<UserFreelancerHasSkill> userFreelancerHasSkill1 = findUserFreelancerHasSkill(userFreelancerHasSkill.getUserFreelancerHasSkillIdentity().getUsersFreelancerId(),userFreelancerHasSkill.getUserFreelancerHasSkillIdentity().getSkillId());
        if (userFreelancerHasSkill1.isPresent()){
            UserFreelancerHasSkill existingUserFreelancerHasSkill = userFreelancerHasSkill1.get();
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
        }
    }

    public void delete(Integer f_id, Integer s_id) {
        Optional<UserFreelancerHasSkill> userFreelancerHasSkill1 = findUserFreelancerHasSkill(f_id, s_id);
        if (userFreelancerHasSkill1.isPresent()) {
            UserFreelancerHasSkill existingUserFreelancerHasSkill = userFreelancerHasSkill1.get();
            existingUserFreelancerHasSkill.setDelFlag(true);
            userFreelancerhasSkillRepository.save(existingUserFreelancerHasSkill);
        }
    }
}
