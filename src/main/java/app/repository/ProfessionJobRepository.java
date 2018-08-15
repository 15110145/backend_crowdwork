package app.repository;

import app.model.ProfessionJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessionJobRepository extends JpaRepository<ProfessionJob,Integer> {

    Optional<ProfessionJob> findByIdAndDelFlag(Integer Id, Boolean delFlag);

    List<ProfessionJob> findAllByDelFlag(Boolean delFlag);
}
