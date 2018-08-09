package app.repository;

import app.model.Identity.JobRequireSkillIdentity;
import app.model.JobRequireSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRequireSkillRepository extends JpaRepository<JobRequireSkill,JobRequireSkillIdentity> {
}
