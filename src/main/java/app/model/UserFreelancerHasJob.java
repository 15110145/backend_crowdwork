package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_freelancer_has_job")
public class UserFreelancerHasJob implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer userFreelancerUser;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "file_url")
    private String fileURL;

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

    public UserFreelancerHasJob() {
    }

    public UserFreelancerHasJob(UsersFreelancer userFreelancerUser, Jobs job, Date dateStart, Date dateEnd, String fileURL, Boolean delFlag) {
        this.userFreelancerUser = userFreelancerUser;
        this.job = job;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.fileURL = fileURL;
        this.delFlag = delFlag;
    }

    public UserFreelancerHasJob(UsersFreelancer userFreelancerUser, Jobs job, Date dateStart, Date dateEnd, String fileURL, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.userFreelancerUser = userFreelancerUser;
        this.job = job;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.fileURL = fileURL;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UsersFreelancer getUserFreelancerUser() {
        return userFreelancerUser;
    }

    public void setUserFreelancerUser(UsersFreelancer userFreelancerUser) {
        this.userFreelancerUser = userFreelancerUser;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
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
