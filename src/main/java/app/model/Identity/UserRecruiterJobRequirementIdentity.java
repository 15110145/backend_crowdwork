package app.model.Identity;

import app.model.ProfessionJob;
import app.model.UsersRecruiter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserRecruiterJobRequirementIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_recruiter_user_id")
    private UsersRecruiter usersRecruiter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job")
    private ProfessionJob professionJob;

    public UserRecruiterJobRequirementIdentity() {
    }

    public UserRecruiterJobRequirementIdentity(UsersRecruiter usersRecruiter, ProfessionJob professionJob) {
        this.usersRecruiter = usersRecruiter;
        this.professionJob = professionJob;
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
