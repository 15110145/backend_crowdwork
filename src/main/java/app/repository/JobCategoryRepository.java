package app.repository;

import app.model.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer> {

    @Modifying
    @Query("SELECT jobcategory FROM JobCategory jobcategory WHERE jobcategory.id=:id and jobcategory.delFlag=false")
    Optional<JobCategory> findJobCategoryById(@Param("id") Integer id);

    @Modifying
    @Query("SELECT jobcategory FROM JobCategory jobcategory WHERE jobcategory.delFlag=false")
    List<JobCategory> findAllJobCategory();
}
