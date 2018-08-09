package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profession_job")
@DynamicInsert
@DynamicUpdate
public class ProfessionJob extends Auditable<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="pjobname")
    private String professionJobName;

    @Column(name="parent_id")
    private Integer parentId;

    @Column(name="del_flag")
    private Boolean delFlag;

    @JsonIgnore
    @OneToMany(mappedBy = "professionJob")
    private List<UserRecruiterJobRequirement> userRecruiterJobRequirementList;

    @JsonIgnore
    @OneToMany(mappedBy = "professionJob")
    private List<JobRequireProfessionJob> jobRequireProfessionJobList;

    @JsonIgnore
    @OneToMany(mappedBy = "professionJob")
    private List<UserFreelancerJobRequirement> userFreelancerJobRequirementList;

    public ProfessionJob() {
    }

    public ProfessionJob(String professionJobName, Integer parentId, Boolean delFlag) {
        this.professionJobName = professionJobName;
        this.parentId = parentId;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionJobName() {
        return professionJobName;
    }

    public void setProfessionJobName(String professionJobName) {
        this.professionJobName = professionJobName;
    }

    public Integer getparentId() {
        return parentId;
    }

    public void setparentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

//    public List<UserRecruiterJobRequirement> getUserRecruiterJobRequirementList() {
//        return userRecruiterJobRequirementList;
//    }
//
//    public void setUserRecruiterJobRequirementList(List<UserRecruiterJobRequirement> userRecruiterJobRequirementList) {
//        this.userRecruiterJobRequirementList = userRecruiterJobRequirementList;
//    }
//
    public List<JobRequireProfessionJob> getJobRequireProfessionJobList() {
        return jobRequireProfessionJobList;
    }

    public void setJobRequireProfessionJobList(List<JobRequireProfessionJob> jobRequireProfessionJobList) {
        this.jobRequireProfessionJobList = jobRequireProfessionJobList;
    }
}
