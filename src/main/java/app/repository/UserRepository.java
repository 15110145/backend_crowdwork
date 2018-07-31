package app.repository;

import app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Modifying
    @Query("UPDATE Users SET name = :name, update_time = :updateTime WHERE id = :id")
    void updateUser(@Param("id") Integer id, @Param("name") String name, @Param("updateTime")Date updateTime);
}
