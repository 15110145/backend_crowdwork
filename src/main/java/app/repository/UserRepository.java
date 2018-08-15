package app.repository;

import app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

//    @Modifying
//    @Query("UPDATE Users SET name = :name, update_time = :updateTime WHERE id = :id")
//    void updateUser(@Param("id") Integer id, @Param("name") String name, @Param("updateTime")Date updateTime);

    Optional<Users> findByIdAndDelFlag(Integer id, Boolean delFag);

    @Modifying
    @Query("SELECT u FROM Users u WHERE u.delFlag=false")
    List<Users> findAllUsers();
}