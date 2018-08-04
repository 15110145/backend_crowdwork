package app.model;

import app.model.Identity.UserFreelancerJobRequirementIdentity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_freelancer_job_requirement")
public class UserFreelancerJobRequirement implements Serializable {

    @EmbeddedId
    private UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity;

    @MapsId("usersFreelancerId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

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

    public UserFreelancerJobRequirement() {
    }

    public UserFreelancerJobRequirement(UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.userFreelancerJobRequirementIdentity = userFreelancerJobRequirementIdentity;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserFreelancerJobRequirementIdentity getUserFreelancerJobRequirementIdentity() {
        return userFreelancerJobRequirementIdentity;
    }

    public void setUserFreelancerJobRequirementIdentity(UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity) {
        this.userFreelancerJobRequirementIdentity = userFreelancerJobRequirementIdentity;
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
