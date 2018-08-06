package app.model.Identity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFreelancerHasSkillIdentity implements Serializable {

    private Integer usersFreelancerId;
    private Integer skillId;

    public UserFreelancerHasSkillIdentity() {
    }

    public UserFreelancerHasSkillIdentity(Integer usersFreelancerId, Integer skillId) {
        this.usersFreelancerId = usersFreelancerId;
        this.skillId = skillId;
    }

    public Integer getUsersFreelancerId() {
        return usersFreelancerId;
    }

    public void setUsersFreelancerId(Integer usersFreelancerId) {
        this.usersFreelancerId = usersFreelancerId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFreelancerHasSkillIdentity that = (UserFreelancerHasSkillIdentity) o;
        return Objects.equals(usersFreelancerId, that.usersFreelancerId) &&
                Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usersFreelancerId, skillId);
    }
}
