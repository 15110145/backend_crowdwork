package app.dao;

import app.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
