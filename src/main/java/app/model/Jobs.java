package app.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "jobs")
public class Jobs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="jobname")
    private String jobName;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="salary")
    private Double salary;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="experience")
    private Integer experience;

    @Column(name="slot")
    private Integer slot;

    @Column(name="status_id")
    private String statusId;

    @Column(name="user_recruiter_user_id")
    private Integer userRecruiterUserId;

    @Column(name="job_category_id")
    private Integer jobCategoryId;

    @Column(name="del_flag")
    private Boolean delFlag;

    @Column(name="create_user")
    private Integer createUser;

    @Column(name="update_user")
    private Integer updateUser;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    public Jobs(String jobName, Date deadline, Double salary, String title, String description, Integer experience, Integer slot, String statusId, Integer userRecruiterUserId, Integer jobCategoryId, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.jobName = jobName;
        this.deadline = deadline;
        this.salary = salary;
        this.title = title;
        this.description = description;
        this.experience = experience;
        this.slot = slot;
        this.statusId = statusId;
        this.userRecruiterUserId = userRecruiterUserId;
        this.jobCategoryId = jobCategoryId;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public String getstatusId() {
        return statusId;
    }

    public void setstatusId(String statusId) {
        this.statusId = statusId;
    }

    public Integer getUserRecruiterUserId() {
        return userRecruiterUserId;
    }

    public void setUserRecruiterUserId(Integer userRecruiterUserId) {
        this.userRecruiterUserId = userRecruiterUserId;
    }

    public Integer getJobCategoryId() {
        return jobCategoryId;
    }

    public void setJobCategoryId(Integer jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
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

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", deadline=" + deadline +
                ", salary=" + salary +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", slot=" + slot +
                ", statusId='" + statusId + '\'' +
                ", userRecruiterUserId=" + userRecruiterUserId +
                ", jobCategoryId=" + jobCategoryId +
                ", delFlag=" + delFlag +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
