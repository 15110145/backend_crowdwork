package app.repository;

import app.model.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer> {

    Optional<JobCategory> findByIdAndDelFlag(Integer Id, Boolean delFlag);

    List<JobCategory> findAllByDelFlag(Boolean delFlag);
}
