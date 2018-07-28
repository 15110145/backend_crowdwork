package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_recruiter_job_requirement")
public class UserRecruiterJobRequirement implements Serializable {

    @Id
    @Column(name ="user_recruiter_user_id")
    private Integer userRecruiterUserId;

    @Id
    @Column(name ="profession_job")
    private Integer profession_job_id;

    @Column(name="del_flag")
    private Boolean delFlag;

    @Column(name="create_user")
    private String createUser;

    @Column(name="update_user")
    private String updateUser;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    public UserRecruiterJobRequirement() {
    }

    public UserRecruiterJobRequirement(Integer userRecruiterUserId, Integer profession_job_id, Boolean delFlag, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.userRecruiterUserId = userRecruiterUserId;
        this.profession_job_id = profession_job_id;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUserRecruiterUserId() {
        return userRecruiterUserId;
    }

    public void setUserRecruiterUserId(Integer userRecruiterUserId) {
        this.userRecruiterUserId = userRecruiterUserId;
    }

    public Integer getProfession_job_id() {
        return profession_job_id;
    }

    public void setProfession_job_id(Integer profession_job_id) {
        this.profession_job_id = profession_job_id;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserRecruiterJobRequirement{" +
                "userRecruiterUserId=" + userRecruiterUserId +
                ", profession_job_id=" + profession_job_id +
                ", delFlag=" + delFlag +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
