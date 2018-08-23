package app.services;

import app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Users users, String verificationCode) throws MailException, MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(mail, multipart, "UTF-8");
        String htmlMsg = "Hi " + users.getName() + "<br/>Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!<br/>"
                + "Vui lòng nhấn vào link bên dưới để xác thực email<br/>"
              + "<a href=\"http://localhost:8080/api/auth/verify-email/" + verificationCode + "\">Nhấn vào đây</a><br/>";
        mail.setContent(htmlMsg,"text/html; charset=utf-8");
        mail.setFrom("${spring.mail.username}");
        helper.addTo(users.getEmail());
        helper.setSubject("Xác Thực Email");
        javaMailSender.send(mail);
    }
}
