package app.model.Identity;

import app.model.Jobs;
import app.model.Skills;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JobRequireSkillIdentity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id")
    private Skills skills;

    public JobRequireSkillIdentity() {
    }

    public JobRequireSkillIdentity(Jobs jobs, Skills skills) {
        this.jobs = jobs;
        this.skills = skills;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobRequireSkillIdentity that = (JobRequireSkillIdentity) o;
        return Objects.equals(jobs, that.jobs) &&
                Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobs, skills);
    }
}
