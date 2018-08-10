package app.repository;

import app.model.Identity.UserFreelancerHasSkillIdentity;
import app.model.UserFreelancerHasSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFreelancerhasSkillRepository extends JpaRepository<UserFreelancerHasSkill, UserFreelancerHasSkillIdentity> {

    List<UserFreelancerHasSkill> findAllByDelFlag(Boolean delFlag);

    List<UserFreelancerHasSkill> findByUserFreelancerHasSkillIdentityAndDelFlag(UserFreelancerHasSkillIdentity userFreelancerHasSkillIdentity, Boolean delFlag);
}
