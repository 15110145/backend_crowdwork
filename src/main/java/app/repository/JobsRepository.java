package app.repository;

import app.model.JobCategory;
import app.model.Jobs;
import app.model.ProfessionJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {

    Optional<Jobs> findByIdAndDelFlag(Integer Id, Boolean delFlag);

    List<Jobs> findAllByDelFlag(Boolean delFlag);

    @Modifying
    @Query("SELECT jobs FROM Jobs jobs WHERE jobs.experience=0 and jobs.delFlag=false")
    List<Jobs> findJobsNoExperience();

    @Modifying
    @Query("SELECT jobs FROM Jobs jobs WHERE jobs.experience>0 and jobs.delFlag=false")
    List<Jobs> findJobsWithExperience();

    @Modifying
    @Query("Select jobs from Jobs jobs where jobs.jobCategory=:jobCategory and jobs.delFlag=false ")
    List<Jobs> findAllJobByCategory(@Param("jobCategory") JobCategory jobCategory);
}
