package app.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="comments")
@DynamicInsert
@DynamicUpdate
public class Comments extends Auditable<Integer> implements Serializable {
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
    private Boolean delFlag= false;

    public Comments() { }

    public Comments(String content, Users users, Jobs jobs, Integer parentId, Boolean delFlag) {
        this.content = content;
        this.users = users;
        this.jobs = jobs;
        this.parentId = parentId;
        this.delFlag = delFlag;
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

}
