package app.repository;

import app.model.Identity.UserFreelancerHasJobIdentity;
import app.model.UserFreelancerHasJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFreelancerHasJobRepository extends JpaRepository<UserFreelancerHasJob, UserFreelancerHasJobIdentity> {
}
