package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users_freelancer")
@DynamicInsert
@DynamicUpdate
public class UsersFreelancer extends Auditable<Integer> implements Serializable {

    @Id
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "working_time")
    private String workingTime;

    @Column(name = "salary_per_hour")
    private Double salaryPerHour;

    @Column(name = "about")
    private String about;

    @Column(name = "username_github")
    private String usernameGithub;

    @Column(name = "degree")
    private String degree;

    @Column(name = "del_flag")
    private Boolean delFlag;

    @JsonIgnore
    @MapsId("userId")
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<UserFreelancerHasSkill> userFreelancerHasSkillList;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<UserFreelancerHasJob> userFreelancerHasJobs;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<Contracts> contracts;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<UserFreelancerJobRequirement> userFreelancerJobRequirementList;

    public UsersFreelancer() {
    }

    public UsersFreelancer(Integer userId, Status status, String workingTime, Double salaryPerHour, String about, String usernameGithub, String degree, Boolean delFlag) {
        this.userId = userId;
        this.status = status;
        this.workingTime = workingTime;
        this.salaryPerHour = salaryPerHour;
        this.about = about;
        this.usernameGithub = usernameGithub;
        this.degree = degree;
        this.delFlag = delFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUsernameGithub() {
        return usernameGithub;
    }

    public void setUsernameGithub(String usernameGithub) {
        this.usernameGithub = usernameGithub;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<UserFreelancerHasSkill> getUserFreelancerHasSkillList() {
        return userFreelancerHasSkillList;
    }

    public void setUserFreelancerHasSkillList(List<UserFreelancerHasSkill> userFreelancerHasSkillList) {
        this.userFreelancerHasSkillList = userFreelancerHasSkillList;
    }

    public List<UserFreelancerHasJob> getUserFreelancerHasJobs() {
        return userFreelancerHasJobs;
    }

    public void setUserFreelancerHasJobs(List<UserFreelancerHasJob> userFreelancerHasJobs) {
        this.userFreelancerHasJobs = userFreelancerHasJobs;
    }

    public List<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contracts> contracts) {
        this.contracts = contracts;
    }

    public List<UserFreelancerJobRequirement> getUserFreelancerJobRequirementList() {
        return userFreelancerJobRequirementList;
    }

    public void setUserFreelancerJobRequirementList(List<UserFreelancerJobRequirement> userFreelancerJobRequirementList) {
        this.userFreelancerJobRequirementList = userFreelancerJobRequirementList;
    }
}
