package app.services;

import app.model.Token;
import app.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    public List<Token> findAllToken(){
        return tokenRepository.findAll();
    }

    public Optional<Token> findToken(Integer id){
        return tokenRepository.findById(id);
    }

    public void save(Token token){
        tokenRepository.save(token);
    }

    public void update(Token token){
        Optional<Token> token1 = findToken(token.getId());
        if (token1.isPresent()){
            Token existingToken = token1.get();
            if (token.getTime() != null){
                existingToken.setTime(token.getTime());
            }
            if (token.getDelFlag() != null){
                existingToken.setDelFlag(token.getDelFlag());
            }
            if (token.getStatus() != null){
                existingToken.setStatus(token.getStatus());
            }
            if (token.getUsers() != null){
                existingToken.setUsers(token.getUsers());
            }
            tokenRepository.save(existingToken);
        }
    }

    public void delete(Integer id){
        Optional<Token> token1 = findToken(id);
        if (token1.isPresent()) {
            Token existingToken = token1.get();
            existingToken.setDelFlag(true);
            tokenRepository.save(existingToken);
        }
    }
}
