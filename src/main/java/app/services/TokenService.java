package app.services;

import app.model.ApiResponse;
import app.model.Status;
import app.model.Token;
import app.model.Users;
import app.repository.StatusRepository;
import app.repository.TokenRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TokenService {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;



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
            if (token.getExpiredDateTime() != null){
                existingToken.setExpiredDateTime(token.getExpiredDateTime());
            }
            if (token.getIssuedDateTime() != null){
                existingToken.setIssuedDateTime(token.getIssuedDateTime());
            }
            if (token.getConfirmedDateTime() != null){
                existingToken.setConfirmedDateTime(token.getConfirmedDateTime());
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

    public void createVerification(Users users) throws MessagingException {

        Status status_PENDING = statusRepository.findByStatusName("PENDING").get();
        Optional<Token> verificationTokens = tokenRepository.findByUsers_Email(users.getEmail());
        Token verificationToken;
        if (verificationTokens.isPresent()) {
            verificationToken = verificationTokens.get();
        } else {
            verificationToken = new Token();
            verificationToken.setUsers(users);
            verificationToken.setStatus(status_PENDING);
            tokenRepository.save(verificationToken);

        }

        notificationService.sendVerifyEmail(users, verificationToken.getToken());
    }

    public ResponseEntity<?> verifyEmail(String token){
        Optional<Token> verificationTokens = tokenRepository.findByTokenAndDelFlag(token,false);
        if (!verificationTokens.isPresent()) {
            return ResponseEntity.ok(new ApiResponse(false,"Invalid token."));
        }

        Token verificationToken = verificationTokens.get();
        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
            return ResponseEntity.ok(new ApiResponse(false,"Expired token."));
        }

        Status status_VERIFIED = statusRepository.findByStatusName("VERIFIED").get();
        verificationToken.setConfirmedDateTime(LocalDateTime.now());
        verificationToken.setStatus(status_VERIFIED);
        verificationToken.getUsers().setVerifyEmail(true);
        tokenRepository.save(verificationToken);
        delete(verificationToken.getId());

        return ResponseEntity.ok(new ApiResponse(true,"You have successfully verified your email address."));
    }

    public ResponseEntity<?> forgetPassword(String token){
        Optional<Token> verificationTokens = tokenRepository.findByTokenAndDelFlag(token,false);
        if (!verificationTokens.isPresent()) {
            return ResponseEntity.ok(new ApiResponse(false,"Invalid token."));
        }

        Token verificationToken = verificationTokens.get();
        if (verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
            return ResponseEntity.ok(new ApiResponse(false,"Expired token."));
        }

        Status status_VERIFIED = statusRepository.findByStatusName("VERIFIED").get();
        verificationToken.setConfirmedDateTime(LocalDateTime.now());
        verificationToken.setStatus(status_VERIFIED);
        tokenRepository.save(verificationToken);
        String string = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        String pass = "";
        for (int i = 0; i < 10; i++) {
            int temp = (int) Math.round(Math.random() * string.length());
            pass += pass.charAt(temp);
        }
        delete(verificationToken.getId());

        return ResponseEntity.ok(new ApiResponse(true,pass));
    }
}
