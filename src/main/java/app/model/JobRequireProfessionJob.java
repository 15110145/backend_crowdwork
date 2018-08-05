package app.model;

import app.model.Identity.JobRequireProfessionJobIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="job_require_profession_job")
@DynamicInsert
@DynamicUpdate
public class JobRequireProfessionJob extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity;

    @MapsId("jobId")
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @MapsId("professionJobId")
    @ManyToOne
    @JoinColumn(name = "profession_job_id")
    private ProfessionJob professionJob;

}
