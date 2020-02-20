package onetoOne;

import dao.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetails {
    @Id
    @GeneratedValue
    // when we want to use embedded object as the embedded key(primary key) combinateion of some filelds is prmary key then we will use @Embedded id
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name="VEHICLE_ID")
    private Vehicle vehicle;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
