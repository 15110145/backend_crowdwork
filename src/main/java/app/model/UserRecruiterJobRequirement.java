package app.model;

import app.model.Identity.UserRecruiterJobRequirementIdentity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_recruiter_job_requirement")
public class UserRecruiterJobRequirement implements Serializable {

    @EmbeddedId
    private UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity;

    @MapsId("usersRecruiterId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @MapsId("professionJobId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job_id")
    private ProfessionJob professionJob;

    @Column(name="del_flag")
    private Boolean delFlag;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public UserRecruiterJobRequirement() {
    }

    public UserRecruiterJobRequirement(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.userRecruiterJobRequirementIdentity = userRecruiterJobRequirementIdentity;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserRecruiterJobRequirementIdentity getUserRecruiterJobRequirementIdentity() {
        return userRecruiterJobRequirementIdentity;
    }

    public void setUserRecruiterJobRequirementIdentity(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity) {
        this.userRecruiterJobRequirementIdentity = userRecruiterJobRequirementIdentity;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
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
}
