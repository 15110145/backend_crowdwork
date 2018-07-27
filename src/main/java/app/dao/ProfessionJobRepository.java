package app.dao;

import app.model.ProfessionJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionJobRepository extends JpaRepository<ProfessionJob,long> {
}
