package app.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Jobs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name="status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_category_id")
    private JobCategory jobCategory;

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

    @OneToMany(mappedBy = "jobs")
    private List<Comments> comments;

    @OneToMany(mappedBy = "jobs")
    private List<JobCategory> jobCategories;

    @OneToMany(mappedBy = "jobs")
    private List<JobRequireSkill> jobRequireSkills;

    public Jobs() {
    }

    public Jobs(String jobName, Date deadline, Double salary, String title, String description, Integer experience, Integer slot, String status, UsersRecruiter usersRecruiter, JobCategory jobCategory, Boolean delFlag) {
        this.jobName = jobName;
        this.deadline = deadline;
        this.salary = salary;
        this.title = title;
        this.description = description;
        this.experience = experience;
        this.slot = slot;
        this.status = status;
        this.usersRecruiter = usersRecruiter;
        this.jobCategory = jobCategory;
        this.delFlag = delFlag;
    }

    public Jobs(String jobName, Date deadline, Double salary, String title, String description, Integer experience, Integer slot, String status, UsersRecruiter usersRecruiter, JobCategory jobCategory, Boolean delFlag, Users createUser, Users updateUser, Date createTime, Date updateTime) {
        this.jobName = jobName;
        this.deadline = deadline;
        this.salary = salary;
        this.title = title;
        this.description = description;
        this.experience = experience;
        this.slot = slot;
        this.status = status;
        this.usersRecruiter = usersRecruiter;
        this.jobCategory = jobCategory;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsersRecruiter getUsersRecruiter() {
        return usersRecruiter;
    }

    public void setUsersRecruiter(UsersRecruiter usersRecruiter) {
        this.usersRecruiter = usersRecruiter;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
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

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<JobCategory> getJobCategories() {
        return jobCategories;
    }

    public void setJobCategories(List<JobCategory> jobCategories) {
        this.jobCategories = jobCategories;
    }

    public List<JobRequireSkill> getJobRequireSkills() {
        return jobRequireSkills;
    }

    public void setJobRequireSkills(List<JobRequireSkill> jobRequireSkills) {
        this.jobRequireSkills = jobRequireSkills;
    }
}
