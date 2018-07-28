package app.reponsitory;

import app.model.UsersFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersFreelancerReponsitory extends JpaRepository<UsersFreelancer, Integer> {
}
