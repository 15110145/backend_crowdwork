package app.model.Identity;

import app.model.Jobs;
import app.model.Skills;

import javax.persistence.*;
import java.io.Serializable;

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
}
