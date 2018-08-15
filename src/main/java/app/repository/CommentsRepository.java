package app.repository;

import app.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    Optional<Comments> findByIdAndDelFlag(Integer Id, Boolean delFlag);

    List<Comments> findAllByDelFlag(Boolean delFlag);
}
