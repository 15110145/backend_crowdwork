package app.controller;

import app.model.Users;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "Spring Boot hello world !!!!!";
    }


}
