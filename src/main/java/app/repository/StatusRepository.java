package app.repository;

import app.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status,Integer> {

    Optional<Status> findByStatusName(String name);

    Optional<Status> findByIdAndDelFlag(Integer Id, Boolean delFlag);

    List<Status> findAllByDelFlag(Boolean delFlag);

    Optional<Status> findByStatusNameAndKind(String statusName, String kind);
}
