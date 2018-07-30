package app.model.Identity;

import app.model.ProfessionJob;
import app.model.UsersFreelancer;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserFreelancerJobRequirementIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job")
    private ProfessionJob professionJob;

    public UserFreelancerJobRequirementIdentity() {
    }

    public UserFreelancerJobRequirementIdentity(UsersFreelancer usersFreelancer, ProfessionJob professionJob) {
        this.usersFreelancer = usersFreelancer;
        this.professionJob = professionJob;
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
