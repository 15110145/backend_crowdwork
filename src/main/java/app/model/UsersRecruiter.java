package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users_recruiter")
public class UsersRecruiter implements Serializable {

    @Id
    private Integer userId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_profile")
    private String companyProfile;

    @Column(name = "approved")
    private Boolean approved;

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
    @OneToMany(mappedBy = "usersRecruiter")
    private List<Contracts> contracts;

    @JsonIgnore
    @OneToMany(mappedBy = "usersRecruiter")
    private List<Jobs> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "usersRecruiter")
    private List<UserRecruiterJobRequirement> userRecruiterJobRequirements;


}
