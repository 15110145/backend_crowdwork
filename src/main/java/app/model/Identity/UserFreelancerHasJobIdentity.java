package app.model.Identity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFreelancerHasJobIdentity implements Serializable {

    private Integer usersFreelancerId;
    private Integer jobId;

    public UserFreelancerHasJobIdentity() {
    }

    public UserFreelancerHasJobIdentity(Integer usersFreelancerId, Integer jobId) {
        this.usersFreelancerId = usersFreelancerId;
        this.jobId = jobId;
    }

    public Integer getUsersFreelancerId() {
        return usersFreelancerId;
    }

    public void setUsersFreelancerId(Integer usersFreelancerId) {
        this.usersFreelancerId = usersFreelancerId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFreelancerHasJobIdentity that = (UserFreelancerHasJobIdentity) o;
        return Objects.equals(usersFreelancerId, that.usersFreelancerId) &&
                Objects.equals(jobId, that.jobId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usersFreelancerId, jobId);
    }
}
