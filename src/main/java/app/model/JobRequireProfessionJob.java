package app.model;

import app.model.Identity.JobRequireProfessionJobIdentity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="job_require_profession_job")
public class JobRequireProfessionJob implements Serializable {

    @EmbeddedId
    private JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity;

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

    public JobRequireProfessionJob() {
    }

    public JobRequireProfessionJob(JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.jobRequireProfessionJobIdentity = jobRequireProfessionJobIdentity;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public JobRequireProfessionJobIdentity getJobRequireProfessionJobIdentity() {
        return jobRequireProfessionJobIdentity;
    }

    public void setJobRequireProfessionJobIdentity(JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity) {
        this.jobRequireProfessionJobIdentity = jobRequireProfessionJobIdentity;
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
