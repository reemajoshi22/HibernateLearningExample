package oneToMAny;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id @GeneratedValue
    private int v_id;
    private String name;

    // for revserse relationship
    @ManyToOne
    private UserDetails userDetails;
    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }


    public int getId() {
        return v_id;
    }

    public void setId(int v_id) {
        this.v_id = v_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

