package app.model;

import app.model.Identity.JobRequireSkillIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "job_require_skill")
@DynamicInsert
@DynamicUpdate
public class JobRequireSkill extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private JobRequireSkillIdentity jobRequireSkillIdentity;

    @MapsId("jobId")
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @MapsId("skillId")
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skills;

    @Column(name="del_flag")
    private Boolean delFlag;

    public JobRequireSkill() {
    }

    public JobRequireSkill(JobRequireSkillIdentity jobRequireSkillIdentity, Boolean delFlag) {
        this.jobRequireSkillIdentity = jobRequireSkillIdentity;
        this.delFlag = delFlag;
    }

    public JobRequireSkillIdentity getJobRequireSkillIdentity() {
        return jobRequireSkillIdentity;
    }

    public void setJobRequireSkillIdentity(JobRequireSkillIdentity jobRequireSkillIdentity) {
        this.jobRequireSkillIdentity = jobRequireSkillIdentity;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

}
