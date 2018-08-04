package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "statusname")
    private String statusName;

    @Column(name = "kind")
    private String kind;

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

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Jobs> jobsList;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<UsersFreelancer> usersFreelancerList;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Contracts> contractsList;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Token> tokenList;

    public Status() {
    }

    public Status(String statusName, String kind, Boolean delFlag) {
        this.statusName = statusName;
        this.kind = kind;
        this.delFlag = delFlag;
    }

    public Status(String statusName, String kind, Boolean delFlag, Integer createUser, Integer updateUser, Date createTime, Date updateTime) {
        this.statusName = statusName;
        this.kind = kind;
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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
