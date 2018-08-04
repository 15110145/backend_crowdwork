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


}
