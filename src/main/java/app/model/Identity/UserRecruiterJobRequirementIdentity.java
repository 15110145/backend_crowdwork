package app.model.Identity;

import app.model.ProfessionJob;
import app.model.UsersRecruiter;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRecruiterJobRequirementIdentity implements Serializable {

    private Integer usersRecruiterId;
    private Integer professionJobId;

    public UserRecruiterJobRequirementIdentity() {
    }

    public UserRecruiterJobRequirementIdentity(Integer usersRecruiterId, Integer professionJobId) {
        this.usersRecruiterId = usersRecruiterId;
        this.professionJobId = professionJobId;
    }

    public Integer getUsersRecruiterId() {
        return usersRecruiterId;
    }

    public void setUsersRecruiterId(Integer usersRecruiterId) {
        this.usersRecruiterId = usersRecruiterId;
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
        UserRecruiterJobRequirementIdentity that = (UserRecruiterJobRequirementIdentity) o;
        return Objects.equals(usersRecruiterId, that.usersRecruiterId) &&
                Objects.equals(professionJobId, that.professionJobId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(usersRecruiterId, professionJobId);
    }
}
