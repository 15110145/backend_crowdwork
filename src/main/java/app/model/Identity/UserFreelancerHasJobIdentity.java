package app.model.Identity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserFreelancerHasJobIdentity implements Serializable {

    private Integer usersFreelancerId;
    private Integer jobId;
}
