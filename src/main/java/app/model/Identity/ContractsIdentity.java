package app.model.Identity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContractsIdentity implements Serializable {

    private Integer usersFreelancerId;
    private Integer usersRecruiterId;
}
