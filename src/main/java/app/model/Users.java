package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date date_of_birth;
    private String email;
    private String password;
    private String address;
    private String cmnd;
    private String avatar;
    private String role;
    private boolean del_plag;
    private int create_user;
    private int update_user;
    private Date create_time;
    private Date update_time;

    public Users() {
    }

    public Users(String name, Date date_of_birth, String email, String password, String address, String cmnd, String avatar, String role, boolean del_plag, int create_user, int update_user, Date create_time, Date update_time) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cmnd = cmnd;
        this.avatar = avatar;
        this.role = role;
        this.del_plag = del_plag;
        this.create_user = create_user;
        this.update_user = update_user;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isDel_plag() {
        return del_plag;
    }

    public void setDel_plag(boolean del_plag) {
        this.del_plag = del_plag;
    }

    public int getCreate_user() {
        return create_user;
    }

    public void setCreate_user(int create_user) {
        this.create_user = create_user;
    }

    public int getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(int update_user) {
        this.update_user = update_user;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
