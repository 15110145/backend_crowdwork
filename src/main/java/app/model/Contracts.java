package app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "contracts")
public class Contracts implements Serializable {

    private Integer user_freelancer_user_id;

}
