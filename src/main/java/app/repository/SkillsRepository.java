package app.repository;

import app.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<Skills,Integer> {

    @Modifying
    @Query("SELECT u FROM Skills u WHERE u.id = :u_id and u.delFlag=false")
    List<Skills> findSkillsById(@Param("u_id") Integer u_id);

    @Modifying
    @Query("SELECT u FROM Skills u WHERE u.delFlag=false")
    List<Skills> findAllSkills();
}
