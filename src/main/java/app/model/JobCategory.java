package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_category")
@DynamicInsert
@DynamicUpdate
public class JobCategory extends Auditable<Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="name")
    private  String name;

    @Column(name="del_flag")
    private Boolean delFlag;

    @JsonIgnore
    @OneToMany(mappedBy = "jobCategory")
    private List<Jobs> jobsList;

    public JobCategory() {
    }

    public JobCategory(String name, Boolean delFlag) {
        this.name = name;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

//    public List<Jobs> getJobsList() {
//        return jobsList;
//    }
//
//    public void setJobsList(List<Jobs> jobsList) {
//        this.jobsList = jobsList;
//    }

    @Override
    public String toString() {
        return "JobCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
