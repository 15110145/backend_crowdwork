package app.model;

import app.model.Identity.JobRequireProfessionJobIdentity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="job_require_profession_job")
public class JobRequireProfessionJob implements Serializable {

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
