package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="job_require_profession_job")
public class JobRequireProfessionJob implements Serializable {

    @Id
    @Column(name="job_id")
    private Integer jobId;

    @Id
    @Column(name="profession_job_id")
    private Integer professionJobId;

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

    public JobRequireProfessionJob() {
    }

    public JobRequireProfessionJob(Integer jobId, Integer professionJobId, Boolean delFlag, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.jobId = jobId;
        this.professionJobId = professionJobId;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getProfessionJobId() {
        return professionJobId;
    }

    public void setProfessionJobId(Integer professionJobId) {
        this.professionJobId = professionJobId;
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
        return "JobRequireProfessionJob{" +
                "jobId=" + jobId +
                ", professionJobId=" + professionJobId +
                ", delFlag=" + delFlag +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
