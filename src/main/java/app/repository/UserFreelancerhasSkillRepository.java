package app.repository;

import app.model.Identity.UserFreelancerHasSkillIdentity;
import app.model.UserFreelancerHasSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFreelancerhasSkillRepository extends JpaRepository<UserFreelancerHasSkill, UserFreelancerHasSkillIdentity> {
}
