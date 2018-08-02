package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profession_job")
public class ProfessionJob implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="pjobname")
    private String professionJobName;

    @Column(name="parent_id")
    private Integer parentId;

    @Column(name="del_flag")
    private Boolean delFlag;

    @Column(name = "create_user")
    private Integer createUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

//    @OneToMany(mappedBy = "professionJob")
//    private List<UserRecruiterJobRequirement> userRecruiterJobRequirementList;
//
//    @OneToMany(mappedBy = "professionJob")
//    private List<JobRequireProfessionJob> jobRequireProfessionJobList;
//
//    @OneToMany(mappedBy = "professionJob")
//    private List<UserFreelancerJobRequirement> userFreelancerJobRequirementList;

    public ProfessionJob() {
    }

    public ProfessionJob(String professionJobName, Integer parrentId, Boolean delFlag) {
        this.professionJobName = professionJobName;
        this.parentId = parentId;
        this.delFlag = delFlag;
    }

//    public ProfessionJob(String professionJobName, Integer parrentId, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime, List<UserRecruiterJobRequirement> userRecruiterJobRequirementList, List<JobRequireProfessionJob> jobRequireProfessionJobList) {
//        this.professionJobName = professionJobName;
//        this.parrentId = parrentId;
//        this.delFlag = delFlag;
//        this.createUser = createUser;
//        this.updateUser = updateUser;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//        this.userRecruiterJobRequirementList = userRecruiterJobRequirementList;
//        this.jobRequireProfessionJobList = jobRequireProfessionJobList;
//    }

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

//    public List<UserRecruiterJobRequirement> getUserRecruiterJobRequirementList() {
//        return userRecruiterJobRequirementList;
//    }
//
//    public void setUserRecruiterJobRequirementList(List<UserRecruiterJobRequirement> userRecruiterJobRequirementList) {
//        this.userRecruiterJobRequirementList = userRecruiterJobRequirementList;
//    }
//
//    public List<JobRequireProfessionJob> getJobRequireProfessionJobList() {
//        return jobRequireProfessionJobList;
//    }
//
//    public void setJobRequireProfessionJobList(List<JobRequireProfessionJob> jobRequireProfessionJobList) {
//        this.jobRequireProfessionJobList = jobRequireProfessionJobList;
//    }
}
