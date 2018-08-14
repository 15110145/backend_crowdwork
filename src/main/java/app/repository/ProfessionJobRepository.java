package app.repository;

import app.model.ProfessionJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessionJobRepository extends JpaRepository<ProfessionJob,Integer> {

    @Modifying
    @Query("SELECT professionJob FROM ProfessionJob professionJob WHERE professionJob.id=:id and professionJob.delFlag=false")
    Optional<ProfessionJob> findProfessionJobById(@Param("id") Integer id);

    @Modifying
    @Query("SELECT professionJob FROM ProfessionJob professionJob WHERE professionJob.delFlag=false")
    List<ProfessionJob> findAllProfessionJob();
}
