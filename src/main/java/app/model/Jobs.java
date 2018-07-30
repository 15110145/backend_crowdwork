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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_category_id")
    private JobCategory jobCategory;

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

    @OneToMany(mappedBy = "jobs")
    private List<Comments> commentsList;

    @OneToMany(mappedBy = "jobs")
    private List<JobRequireProfessionJob> jobRequireProfessionJobList;

    @OneToMany(mappedBy = "jobs")
    private List<JobRequireSkill> jobRequireSkillList;

    @OneToMany(mappedBy = "jobs")
    private List<UserFreelancerHasJob> userFreelancerHasJobList;

    public Jobs() {
    }

    public Jobs(String jobName, Date deadline, Double salary, String title, String description, Integer experience, Integer slot, Status status, UsersRecruiter usersRecruiter, JobCategory jobCategory, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<JobRequireProfessionJob> getJobRequireProfessionJobList() {
        return jobRequireProfessionJobList;
    }

    public void setJobRequireProfessionJobList(List<JobRequireProfessionJob> jobRequireProfessionJobList) {
        this.jobRequireProfessionJobList = jobRequireProfessionJobList;
    }

    public List<JobRequireSkill> getJobRequireSkillList() {
        return jobRequireSkillList;
    }

    public void setJobRequireSkillList(List<JobRequireSkill> jobRequireSkillList) {
        this.jobRequireSkillList = jobRequireSkillList;
    }

    public List<UserFreelancerHasJob> getUserFreelancerHasJobList() {
        return userFreelancerHasJobList;
    }

    public void setUserFreelancerHasJobList(List<UserFreelancerHasJob> userFreelancerHasJobList) {
        this.userFreelancerHasJobList = userFreelancerHasJobList;
    }
}
