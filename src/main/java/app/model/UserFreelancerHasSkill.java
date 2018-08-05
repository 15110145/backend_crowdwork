package app.model;

import app.model.Identity.UserFreelancerHasSkillIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_freelancer_has_skill")
@DynamicInsert
@DynamicUpdate
public class UserFreelancerHasSkill extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private UserFreelancerHasSkillIdentity userFreelancerHasSkillIdentity;

    @MapsId("usersFreelancerId")
    @ManyToOne
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

    @MapsId("skillId")
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skills;

    @Column(name = "level")
    private Integer level;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "description")
    private String description;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public UserFreelancerHasSkill() {
    }

    public UserFreelancerHasSkillIdentity getUserFreelancerHasSkillIdentity() {
        return userFreelancerHasSkillIdentity;
    }

    public void setUserFreelancerHasSkillIdentity(UserFreelancerHasSkillIdentity userFreelancerHasSkillIdentity) {
        this.userFreelancerHasSkillIdentity = userFreelancerHasSkillIdentity;
    }

    public UsersFreelancer getUsersFreelancer() {
        return usersFreelancer;
    }

    public void setUsersFreelancer(UsersFreelancer usersFreelancer) {
        this.usersFreelancer = usersFreelancer;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
