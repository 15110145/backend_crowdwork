package app.model.Identity;

import app.model.ProfessionJob;
import app.model.UsersFreelancer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFreelancerJobRequirementIdentity implements Serializable {

    private Integer usersFreelancerId;
    private Integer professionJobId;

    public UserFreelancerJobRequirementIdentity() {
    }

    public UserFreelancerJobRequirementIdentity(Integer usersFreelancerId, Integer professionJobId) {
        this.usersFreelancerId = usersFreelancerId;
        this.professionJobId = professionJobId;
    }

    public Integer getUsersFreelancerId() {
        return usersFreelancerId;
    }

    public void setUsersFreelancerId(Integer usersFreelancerId) {
        this.usersFreelancerId = usersFreelancerId;
    }

    public Integer getProfessionJobId() {
        return professionJobId;
    }

    public void setProfessionJobId(Integer professionJobId) {
        this.professionJobId = professionJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFreelancerJobRequirementIdentity that = (UserFreelancerJobRequirementIdentity) o;
        return Objects.equals(usersFreelancerId, that.usersFreelancerId) &&
                Objects.equals(professionJobId, that.professionJobId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usersFreelancerId, professionJobId);
    }
}
