package app.repository;

import app.model.UsersFreelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersFreelancerRepository extends JpaRepository<UsersFreelancer, Integer> {

//    @Modifying
//    @Query("SELECT u FROM UsersFreelancer u WHERE u.userId = :u_id")
//    List<UsersFreelancer> findUsersFreelancerById(@Param("u_id") Integer u_id);
}
