package app.repository;

import app.model.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer> {

    JobCategory findJobCategoriesByIdAndName(Integer jobCategoryId, String jobCategoryName);
}
