package app.repository;

import app.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {

    Optional<Token> findByUsers_Email(String email);

    Optional<Token> findByTokenAndDelFlag(String token, Boolean delLag);
}
