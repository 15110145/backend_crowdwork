package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "skills")
@DynamicInsert
@DynamicUpdate
public class Skills extends Auditable<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "skillname")
    private String skillName;

    @Column(name = "del_flag")
    private Boolean delFlag= false;

    @JsonIgnore
    @OneToMany(mappedBy = "skills")
    private List<UserFreelancerHasSkill> userFreelancerHasSkills;

    @JsonIgnore
    @OneToMany(mappedBy = "skills")
    private List<JobRequireSkill> jobRequireSkill;

    public Skills() {
    }

    public Skills(String skillName, Boolean delFlag) {
        this.skillName = skillName;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

}
