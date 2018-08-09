package app.model;

import app.model.Identity.UserRecruiterJobRequirementIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_recruiter_job_requirement")
@DynamicInsert
@DynamicUpdate
public class UserRecruiterJobRequirement extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity;

    @MapsId("usersRecruiterId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @MapsId("professionJobId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job_id")
    private ProfessionJob professionJob;

    @Column(name="del_flag")
    private Boolean delFlag;

    public UserRecruiterJobRequirement() {
    }

    public UserRecruiterJobRequirement(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity, UsersRecruiter usersRecruiter, ProfessionJob professionJob, Boolean delFlag) {
        this.userRecruiterJobRequirementIdentity = userRecruiterJobRequirementIdentity;
        this.usersRecruiter = usersRecruiter;
        this.professionJob = professionJob;
        this.delFlag = delFlag;
    }

    public UserRecruiterJobRequirement(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity, Boolean delFlag) {
        this.userRecruiterJobRequirementIdentity = userRecruiterJobRequirementIdentity;
        this.delFlag = delFlag;
    }

    public UserRecruiterJobRequirementIdentity getUserRecruiterJobRequirementIdentity() {
        return userRecruiterJobRequirementIdentity;
    }

    public void setUserRecruiterJobRequirementIdentity(UserRecruiterJobRequirementIdentity userRecruiterJobRequirementIdentity) {
        this.userRecruiterJobRequirementIdentity = userRecruiterJobRequirementIdentity;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
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
}
