package app.repository;

import app.model.Identity.JobRequireProfessionJobIdentity;
import app.model.JobRequireProfessionJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRequireProfessionJobRepository extends JpaRepository<JobRequireProfessionJob,JobRequireProfessionJobIdentity> {
}
