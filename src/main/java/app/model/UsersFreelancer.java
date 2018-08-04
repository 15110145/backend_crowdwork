package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users_freelancer")
public class UsersFreelancer implements Serializable {

    @Id
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "working_time")
    private String workingTime;

    @Column(name = "salary_per_hour")
    private Long salaryPerHour;

    @Column(name = "about")
    private String about;

    @Column(name = "username_github")
    private String usernameGithub;

    @Column(name = "degree")
    private String degree;

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
    @MapsId("userId")
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<UserFreelancerHasSkill> userFreelancerHasSkillList;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<UserFreelancerHasJob> userFreelancerHasJobs;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<Contracts> contracts;

    @JsonIgnore
    @OneToMany(mappedBy = "usersFreelancer")
    private List<UserFreelancerJobRequirement> userFreelancerJobRequirementList;

    public UsersFreelancer() {
    }


}
