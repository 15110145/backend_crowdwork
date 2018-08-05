package app.model;

import app.model.Identity.ContractsIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contracts")
@DynamicInsert
@DynamicUpdate
public class Contracts extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private ContractsIdentity contractsIdentity;

    @MapsId("usersFreelancerId")
    @ManyToOne
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

    @MapsId("usersRecruiterId")
    @ManyToOne
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @Column(name = "job_id")
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public Contracts() {
    }

    public ContractsIdentity getContractsIdentity() {
        return contractsIdentity;
    }

    public void setContractsIdentity(ContractsIdentity contractsIdentity) {
        this.contractsIdentity = contractsIdentity;
    }

    public UsersFreelancer getUsersFreelancer() {
        return usersFreelancer;
    }

    public void setUsersFreelancer(UsersFreelancer usersFreelancer) {
        this.usersFreelancer = usersFreelancer;
    }

    public UsersRecruiter getUsersRecruiter() {
        return usersRecruiter;
    }

    public void setUsersRecruiter(UsersRecruiter usersRecruiter) {
        this.usersRecruiter = usersRecruiter;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
