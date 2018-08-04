package app.model;

import app.model.Identity.ContractsIdentity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contracts implements Serializable {

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

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public Contracts() {
    }


}
