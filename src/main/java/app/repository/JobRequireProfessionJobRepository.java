package app.repository;

import app.model.Identity.JobRequireProfessionJobIdentity;
import app.model.JobRequireProfessionJob;
import app.model.Jobs;
import app.model.ProfessionJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRequireProfessionJobRepository extends JpaRepository<JobRequireProfessionJob,JobRequireProfessionJobIdentity> {

    @Modifying
    @Query("Select jrpj.jobs from JobRequireProfessionJob jrpj where jrpj.professionJob in :professionJobList")
    List<Jobs> findAllJobByProfession(@Param("professionJobList") List<ProfessionJob> professionJobList);
}
