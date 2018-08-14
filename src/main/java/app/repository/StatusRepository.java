package app.repository;

import app.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status,Integer> {
    
    @Modifying
    @Query("SELECT status FROM Status status WHERE status.id=:id and status.delFlag=false")
    Optional<Status> findStatusById(@Param("id") Integer id);

    @Modifying
    @Query("SELECT status FROM Status status WHERE status.delFlag=false")
    List<Status> findAllStatus();
}
