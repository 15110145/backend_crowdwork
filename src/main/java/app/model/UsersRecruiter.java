package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users_recruiter")
@DynamicInsert
@DynamicUpdate
public class UsersRecruiter extends Auditable<Integer> implements Serializable {

    @Id
    private Integer userId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_profile")
    private String companyProfile;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "del_flag")
    private Boolean delFlag;

    @JsonIgnore
    @MapsId("userId")
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @JsonIgnore
    @OneToMany(mappedBy = "usersRecruiter")
    private List<Contracts> contracts;

    @JsonIgnore
    @OneToMany(mappedBy = "usersRecruiter")
    private List<Jobs> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "usersRecruiter")
    private List<UserRecruiterJobRequirement> userRecruiterJobRequirements;

    public UsersRecruiter() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
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

    public List<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contracts> contracts) {
        this.contracts = contracts;
    }

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }

    public List<UserRecruiterJobRequirement> getUserRecruiterJobRequirements() {
        return userRecruiterJobRequirements;
    }

    public void setUserRecruiterJobRequirements(List<UserRecruiterJobRequirement> userRecruiterJobRequirements) {
        this.userRecruiterJobRequirements = userRecruiterJobRequirements;
    }
}
