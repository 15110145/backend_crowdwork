package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users_recruiter")
public class Users_recruiter implements Serializable {

    private String company_name;
    private String company_profile;
    private Boolean approved;
    private Integer user_id;
    private Boolean del_flag;
    private Integer create_user;
    private Integer update_user;
    private Date create_time;
    private Date update_time;

    public Users_recruiter() {
    }

    public Users_recruiter(String company_name, String company_profile, Boolean approved, Integer user_id, Boolean del_flag, Integer create_user, Integer update_user, Date create_time, Date update_time) {
        this.company_name = company_name;
        this.company_profile = company_profile;
        this.approved = approved;
        this.user_id = user_id;
        this.del_flag = del_flag;
        this.create_user = create_user;
        this.update_user = update_user;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_profile() {
        return company_profile;
    }

    public void setCompany_profile(String company_profile) {
        this.company_profile = company_profile;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getDel_flag() {
        return del_flag;
    }

    public void setDel_plag(Boolean del_flag) {
        this.del_flag = del_flag;
    }

    public Integer getCreate_user() {
        return create_user;
    }

    public void setCreate_user(Integer create_user) {
        this.create_user = create_user;
    }

    public Integer getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(Integer update_user) {
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
