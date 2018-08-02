package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name="create_user")
    private String createUser;

    @Column(name="update_user")
    private String updateUser;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    public ProfessionJob() {
    }

    public ProfessionJob(String professionJobName, Integer parentId, Boolean delFlag, String createUser, String updateUser, Date createTime, Date updateTime) {
        this.professionJobName = professionJobName;
        this.parentId = parentId;
        this.delFlag = delFlag;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
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

    @Override
    public String toString() {
        return "ProfessionJob{" +
                "id=" + id +
                ", professionJobName='" + professionJobName + '\'' +
                ", parentId=" + parentId +
                ", delFlag=" + delFlag +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
