package app.model.Identity;

import app.model.Jobs;
import app.model.ProfessionJob;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobRequireProfessionJobIdentity implements Serializable {

    private Integer jobId;

    private Integer professionJobId;

    public JobRequireProfessionJobIdentity() {
    }

    public JobRequireProfessionJobIdentity(Integer jobId, Integer professionJobId) {
        this.jobId = jobId;
        this.professionJobId = professionJobId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
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
        JobRequireProfessionJobIdentity that = (JobRequireProfessionJobIdentity) o;
        return Objects.equals(jobId, that.jobId) &&
                Objects.equals(professionJobId, that.professionJobId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobId, professionJobId);
    }
}
