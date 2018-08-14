package app.repository;

import app.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    @Modifying
    @Query("SELECT comments FROM Comments comments WHERE comments.id=:id and comments.delFlag=false")
    Optional<Comments> findCommentsById(@Param("id") Integer id);

    @Modifying
    @Query("SELECT comments FROM Comments comments WHERE comments.delFlag=false")
    List<Comments> findAllComments();
}
