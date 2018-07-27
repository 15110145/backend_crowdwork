package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_recruiter")
public class UsersRecruiter implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_profile")
    private String companyProfile;

    @Column(name = "approved")
    private Boolean approved;

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

    @OneToMany(mappedBy = "userRecruiterUseId")
    private List<Contracts> contracts;

    @OneToMany(mappedBy = "usersRecruiter")
    private List<Jobs> jobs;

    @OneToMany(mappedBy = "usersRecruiter")
    private List<UserRecruiterJobRequirement> userRecruiterJobRequirements;

    public UsersRecruiter() {
    }

    public UsersRecruiter(String companyName, String companyProfile, Boolean approved, Boolean delFlag) {
        this.companyName = companyName;
        this.companyProfile = companyProfile;
        this.approved = approved;
        this.delFlag = delFlag;
    }

    public UsersRecruiter(String companyName, String companyProfile, Boolean approved, Integer userId, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.companyName = companyName;
        this.companyProfile = companyProfile;
        this.approved = approved;
        this.userId = userId;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
