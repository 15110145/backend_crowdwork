package app.model.Identity;

import app.model.ProfessionJob;
import app.model.UsersFreelancer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFreelancerJobRequirementIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFreelancerJobRequirementIdentity that = (UserFreelancerJobRequirementIdentity) o;
        return Objects.equals(usersFreelancer, that.usersFreelancer) &&
                Objects.equals(professionJob, that.professionJob);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usersFreelancer, professionJob);
    }
}
