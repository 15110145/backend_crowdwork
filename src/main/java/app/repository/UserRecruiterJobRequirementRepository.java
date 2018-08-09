package app.repository;

import app.model.Identity.UserRecruiterJobRequirementIdentity;
import app.model.UserRecruiterJobRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecruiterJobRequirementRepository extends JpaRepository<UserRecruiterJobRequirement,UserRecruiterJobRequirementIdentity> {
}
