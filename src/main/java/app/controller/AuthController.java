package app.controller;

import app.model.*;
import app.repository.UserRepository;
import app.security.JwtTokenProvider;
import app.services.NotificationService;
import app.services.TokenService;
import app.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws MessagingException {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity( new ApiResponse(false,"Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        Users users = new Users(signUpRequest.getName(), signUpRequest.getEmail(), signUpRequest.getPassword());

        users.setPassword(passwordEncoder.encode(users.getPassword()));

        users.setRole("ROLE_USER");

        userRepository.save(users);
        tokenService.createVerification(users);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(result.getEmail()).toUri();

        return ResponseEntity.ok(new ApiResponse(true,"User registered successfully"));
    }

    @GetMapping("/verify-email/{token}")
    public String verifyEmail(@PathVariable String token){
        ApiResponse apiResponse = (ApiResponse) tokenService.verifyEmail(token).getBody();
        if (apiResponse.getSuccess()==true){
            return "Đã xác thực.";
        }else {
            return "Lỗi không xác định.";
        }
    }
}
