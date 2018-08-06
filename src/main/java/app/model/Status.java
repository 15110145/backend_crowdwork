package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "status")
@DynamicInsert
@DynamicUpdate
public class Status extends Auditable<Integer> implements Serializable {

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

    public List<Jobs> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<Jobs> jobsList) {
        this.jobsList = jobsList;
    }

    public List<UsersFreelancer> getUsersFreelancerList() {
        return usersFreelancerList;
    }

    public void setUsersFreelancerList(List<UsersFreelancer> usersFreelancerList) {
        this.usersFreelancerList = usersFreelancerList;
    }

    public List<Contracts> getContractsList() {
        return contractsList;
    }

    public void setContractsList(List<Contracts> contractsList) {
        this.contractsList = contractsList;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }
}
