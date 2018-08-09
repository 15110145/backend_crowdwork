package app.repository;

import app.model.Identity.UserFreelancerJobRequirementIdentity;
import app.model.UserFreelancerJobRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFreelancerJobRequirementRepository extends JpaRepository<UserFreelancerJobRequirement, UserFreelancerJobRequirementIdentity> {
}
