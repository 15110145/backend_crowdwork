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

    public JobRequireSkillIdentity() {
    }

    public JobRequireSkillIdentity(Integer jobId, Integer skillId) {
        this.jobId = jobId;
        this.skillId = skillId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRequireSkillIdentity that = (JobRequireSkillIdentity) o;
        return Objects.equals(jobId, that.jobId) &&
                Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobId, skillId);
    }
}
