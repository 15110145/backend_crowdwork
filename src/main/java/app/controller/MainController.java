package app.controller;

import app.services.NotificationService;
import app.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
//        try {
//            notificationService.sendNotification(userService.findUser().get());
//        }catch (MailException e){
//            logger.info("Error sending email: " + e.getMessage());
//        }
        return "Spring Boot hello world !!!!!";
    }


}
