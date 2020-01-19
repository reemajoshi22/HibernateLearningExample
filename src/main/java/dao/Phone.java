package dao;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="phone")
public class Phone {


    @Id
    int phone_id;
    String sim_slots;
    String phone_model;
    OS os;
    Manufacturer manufacturer;

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getSim_slots() {
        return sim_slots;
    }

    public void setSim_slots(String sim_slots) {
        this.sim_slots = sim_slots;
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

}
