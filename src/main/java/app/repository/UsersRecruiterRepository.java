package app.repository;

import app.model.UsersRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRecruiterRepository extends JpaRepository<UsersRecruiter, Integer> {

    @Modifying
    @Query("SELECT u FROM UsersRecruiter u WHERE u.userId = :u_id and u.delFlag=false")
    List<UsersRecruiter> findUsersRecruiterById(@Param("u_id") Integer u_id);

    @Modifying
    @Query("SELECT u FROM UsersRecruiter u WHERE u.delFlag=false")
    List<UsersRecruiter> findAllUsersRecruiter();
}
