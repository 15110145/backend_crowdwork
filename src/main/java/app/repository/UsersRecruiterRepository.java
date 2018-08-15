package app.repository;

import app.model.UsersRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRecruiterRepository extends JpaRepository<UsersRecruiter, Integer> {

    Optional<UsersRecruiter> findByUserIdAndDelFlag(Integer id, Boolean delFag);

    @Modifying
    @Query("SELECT u FROM UsersRecruiter u WHERE u.delFlag=false")
    List<UsersRecruiter> findAllUsersRecruiter();
}
