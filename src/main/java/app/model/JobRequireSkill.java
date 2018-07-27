package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "job_require_skill")
public class JobRequireSkill implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skills skills;

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

    public JobRequireSkill() {
    }

    public JobRequireSkill(Jobs jobs, Skills skills, Boolean delFlag) {
        this.jobs = jobs;
        this.skills = skills;
        this.delFlag = delFlag;
    }

    public JobRequireSkill(Jobs jobs, Skills skills, Boolean delFlag, Users createUser, Users updateUser, Date createTime, Date updateTime) {
        this.jobs = jobs;
        this.skills = skills;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
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
        return "JobRequireSkill{" +
                "jobs=" + jobs.getId() +
                ", skills=" + skills.getId() +
                ", delFlag=" + delFlag +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
