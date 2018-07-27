package app.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="contents")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @Column(name="parent_id")
    private Integer parentId;

    @Column(name="del_flag")
    private Boolean delFlag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "create_user")
    private Users createUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "update_user")
    private Users updateUser;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    public Comments() { }

    public Comments(String content, Users users, Jobs jobs, Integer parentId, Boolean delFlag) {
        this.content = content;
        this.users = users;
        this.jobs = jobs;
        this.parentId = parentId;
        this.delFlag = delFlag;
    }

    public Comments(String content, Users users, Jobs jobs, Integer parentId, Boolean delFlag, Users createUser, Users updateUser, Date createTime, Date updateTime) {
        this.content = content;
        this.users = users;
        this.jobs = jobs;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Users getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Users createUser) {
        this.createUser = createUser;
    }

    public Users getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Users updateUser) {
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
        return "Comments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", users=" + users.getId() +
                ", jobs=" + jobs.getId() +
                ", parentId=" + parentId +
                ", delFlag=" + delFlag +
                ", createUser=" + createUser.getId() +
                ", updateUser=" + updateUser.getId() +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
