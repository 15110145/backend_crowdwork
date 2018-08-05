package app.model;

import app.model.Identity.UserFreelancerHasJobIdentity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_freelancer_has_job")
@DynamicInsert
@DynamicUpdate
public class UserFreelancerHasJob extends Auditable<Integer> implements Serializable {

    @EmbeddedId
    private UserFreelancerHasJobIdentity userFreelancerHasJobIdentity;

    @MapsId("usersFreelancerId")
    @ManyToOne
    @JoinColumn(name = "user_freelancer_user_id")
    private UsersFreelancer usersFreelancer;

    @MapsId("jobId")
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "file_url")
    private String fileURL;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public UserFreelancerHasJob() {
    }

    public UserFreelancerHasJobIdentity getUserFreelancerHasJobIdentity() {
        return userFreelancerHasJobIdentity;
    }

    public void setUserFreelancerHasJobIdentity(UserFreelancerHasJobIdentity userFreelancerHasJobIdentity) {
        this.userFreelancerHasJobIdentity = userFreelancerHasJobIdentity;
    }

    public UsersFreelancer getUsersFreelancer() {
        return usersFreelancer;
    }

    public void setUsersFreelancer(UsersFreelancer usersFreelancer) {
        this.usersFreelancer = usersFreelancer;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
