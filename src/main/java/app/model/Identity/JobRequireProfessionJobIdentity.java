package app.model.Identity;

import app.model.Jobs;
import app.model.ProfessionJob;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobRequireProfessionJobIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_job_id")
    private ProfessionJob professionJob;

    public JobRequireProfessionJobIdentity() {
    }

    public JobRequireProfessionJobIdentity(Jobs jobs, ProfessionJob professionJob) {
        this.jobs = jobs;
        this.professionJob = professionJob;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRequireProfessionJobIdentity that = (JobRequireProfessionJobIdentity) o;
        return Objects.equals(jobs, that.jobs) &&
                Objects.equals(professionJob, that.professionJob);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobs, professionJob);
    }
}
