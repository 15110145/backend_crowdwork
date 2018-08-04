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


}
