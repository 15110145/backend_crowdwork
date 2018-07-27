package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_recruiter_job_requirement")
public class UserRecruiterJobRequirement implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job")
    private ProfessionJob professionJob;

    @Column(name="del_flag")
    private Boolean delFlag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "create_user")
    private Users createUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "update_user")
    private Users updateUser;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    public UserRecruiterJobRequirement() {
    }

    public UserRecruiterJobRequirement(UsersRecruiter usersRecruiter, ProfessionJob professionJob, Boolean delFlag, Users createUser, Users updateUser, Date createTime, Date updateTime) {
        this.usersRecruiter = usersRecruiter;
        this.professionJob = professionJob;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UsersRecruiter getUsersRecruiter() {
        return usersRecruiter;
    }

    public void setUsersRecruiter(UsersRecruiter usersRecruiter) {
        this.usersRecruiter = usersRecruiter;
    }

    public ProfessionJob getProfessionJob() {
        return professionJob;
    }

    public void setProfessionJob(ProfessionJob professionJob) {
        this.professionJob = professionJob;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Users getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Users createUser) {
        this.createUser = createUser;
    }

    public Users getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Users updateUser) {
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
                "usersRecruiter=" + usersRecruiter.getUserId() +
                ", professionJob=" + professionJob.getId() +
                ", delFlag=" + delFlag +
                ", createUser=" + createUser.getId() +
                ", updateUser=" + updateUser.getId() +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
