package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contracts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_freelancer_user_id")
    private Integer userFreelancerUseId;

    @Column(name = "user_recruiter_user_id")
    private Integer userRecruiterUseId;

    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "status")
    private String status;

    @Column(name = "del_flag")
    private Boolean delFlag;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public Contracts() {
    }

    public Contracts(Integer userFreelancerUseId, Integer userRecruiterUseId, Integer jobId, String status, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.userFreelancerUseId = userFreelancerUseId;
        this.userRecruiterUseId = userRecruiterUseId;
        this.jobId = jobId;
        this.status = status;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUserFreelancerUseId() {
        return userFreelancerUseId;
    }

    public void setUserFreelancerUseId(Integer userFreelancerUseId) {
        this.userFreelancerUseId = userFreelancerUseId;
    }

    public Integer getUserRecruiterUseId() {
        return userRecruiterUseId;
    }

    public void setUserRecruiterUseId(Integer userRecruiterUseId) {
        this.userRecruiterUseId = userRecruiterUseId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
