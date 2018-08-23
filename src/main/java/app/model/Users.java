package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@DynamicUpdate
@DynamicInsert
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
    private Boolean delFlag= false;

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

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users(String name, Date date_of_birth, String email, String password, String address, String cmnd, String avatar, String role, Boolean delFlag, Boolean isVerifyEmail) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cmnd = cmnd;
        this.avatar = avatar;
        this.role = role;
        this.delFlag = delFlag;
        this.isVerifyEmail = isVerifyEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getVerifyEmail() {
        return isVerifyEmail;
    }

    public void setVerifyEmail(Boolean verifyEmail) {
        isVerifyEmail = verifyEmail;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public UsersFreelancer getUsersFreelancer() {
        return usersFreelancer;
    }

    public void setUsersFreelancer(UsersFreelancer usersFreelancer) {
        this.usersFreelancer = usersFreelancer;
    }

    public UsersRecruiter getUsersRecruiter() {
        return usersRecruiter;
    }

    public void setUsersRecruiter(UsersRecruiter usersRecruiter) {
        this.usersRecruiter = usersRecruiter;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }
}
