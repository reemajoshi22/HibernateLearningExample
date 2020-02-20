package oneToMAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetails {
    @Id
    @GeneratedValue
    // when we want to use embedded object as the embedded key(primary key) combinateion of some filelds is prmary key then we will use @Embedded id
    private int id;
    private String name;


    @OneToMany
    @JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name = "USER_ID"),
    inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
    private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();


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

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

}
