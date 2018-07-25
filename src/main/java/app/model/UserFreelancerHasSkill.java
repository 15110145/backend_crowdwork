package app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_freelancer_has_skill")
public class UserFreelancerHasSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_freelancer_user_id")
    private Integer userFreelancerUserId;

    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "level")
    private Integer level;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "description")
    private String description;

    @Column(name = "del_flag")
    private Boolean delFlag;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public UserFreelancerHasSkill() {
    }

    public UserFreelancerHasSkill(Integer skillId, Integer level, Integer experience, String description, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.skillId = skillId;
        this.level = level;
        this.experience = experience;
        this.description = description;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUserFreelancerUserId() {
        return userFreelancerUserId;
    }

    public void setUserFreelancerUserId(Integer userFreelancerUserId) {
        this.userFreelancerUserId = userFreelancerUserId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
