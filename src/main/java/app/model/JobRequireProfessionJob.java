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

    public JobRequireProfessionJobIdentity getJobRequireProfessionJobIdentity() {
        return jobRequireProfessionJobIdentity;
    }

    public void setJobRequireProfessionJobIdentity(JobRequireProfessionJobIdentity jobRequireProfessionJobIdentity) {
        this.jobRequireProfessionJobIdentity = jobRequireProfessionJobIdentity;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public ProfessionJob getProfessionJob() {
        return professionJob;
    }

    public void setProfessionJob(ProfessionJob professionJob) {
        this.professionJob = professionJob;
    }
}
