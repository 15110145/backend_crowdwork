package app.model.Identity;

import app.model.Jobs;
import app.model.Skills;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobRequireSkillIdentity implements Serializable {

    private Integer jobId;
    private Integer skillId;

    
}
