package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
//@SelectBeforeUpdate
@DynamicUpdate
public class Users extends Auditable<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "role")
    private String role;

    @Column(name = "del_flag")
    private Boolean delFlag;

//    @Column(name = "create_user")
//    private Integer createUser;
//
//    @Column(name = "update_user")
//    private Integer updateUser;
//
//    @Column(name = "create_time")
////    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;
//
//    @Column(name = "update_time")
////    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date updateTime;

    @Column(name = "isverifyemail")
    private Boolean isVerifyEmail;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Comments> commentsList;

    @JsonIgnore
    @OneToOne(mappedBy = "users")
    private UsersFreelancer usersFreelancer;

    @JsonIgnore
    @OneToOne(mappedBy = "users")
    private UsersRecruiter usersRecruiter;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Token> tokenList;
    public Users() {
    }


}
