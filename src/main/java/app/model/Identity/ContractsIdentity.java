package app.model.Identity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractsIdentity implements Serializable {

    private Integer usersFreelancerId;
    private Integer usersRecruiterId;

    public ContractsIdentity() {
    }

    public ContractsIdentity(Integer usersFreelancerId, Integer usersRecruiterId) {
        this.usersFreelancerId = usersFreelancerId;
        this.usersRecruiterId = usersRecruiterId;
    }

    public Integer getUsersFreelancerId() {
        return usersFreelancerId;
    }

    public void setUsersFreelancerId(Integer usersFreelancerId) {
        this.usersFreelancerId = usersFreelancerId;
    }

    public Integer getUsersRecruiterId() {
        return usersRecruiterId;
    }

    public void setUsersRecruiterId(Integer usersRecruiterId) {
        this.usersRecruiterId = usersRecruiterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractsIdentity that = (ContractsIdentity) o;
        return Objects.equals(usersFreelancerId, that.usersFreelancerId) &&
                Objects.equals(usersRecruiterId, that.usersRecruiterId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usersFreelancerId, usersRecruiterId);
    }
}
