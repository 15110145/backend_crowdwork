package app.model;

import app.model.Identity.UserFreelancerJobRequirementIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="user_freelancer_job_requirement")
@DynamicInsert
@DynamicUpdate
public class UserFreelancerJobRequirement extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity;

    @MapsId("usersFreelancerId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

    @MapsId("professionJobId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job_id")
    private ProfessionJob professionJob;

    @Column(name="del_flag")
    private Boolean delFlag= false;

    public UserFreelancerJobRequirement() {
    }

    public UserFreelancerJobRequirement(UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity, UsersFreelancer usersFreelancer, ProfessionJob professionJob, Boolean delFlag) {
        this.userFreelancerJobRequirementIdentity = userFreelancerJobRequirementIdentity;
        this.usersFreelancer = usersFreelancer;
        this.professionJob = professionJob;
        this.delFlag = delFlag;
    }

    public UserFreelancerJobRequirementIdentity getUserFreelancerJobRequirementIdentity() {
        return userFreelancerJobRequirementIdentity;
    }

    public void setUserFreelancerJobRequirementIdentity(UserFreelancerJobRequirementIdentity userFreelancerJobRequirementIdentity) {
        this.userFreelancerJobRequirementIdentity = userFreelancerJobRequirementIdentity;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public UsersFreelancer getUsersFreelancer() {
        return usersFreelancer;
    }

    public void setUsersFreelancer(UsersFreelancer usersFreelancer) {
        this.usersFreelancer = usersFreelancer;
    }

    public ProfessionJob getProfessionJob() {
        return professionJob;
    }

    public void setProfessionJob(ProfessionJob professionJob) {
        this.professionJob = professionJob;
    }
}
