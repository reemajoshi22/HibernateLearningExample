package dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable; // for composite id we shud implemet Serializable

@Entity(name="phone")
public class Phone implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int phone_id;
    int ver;

    String sim_slots;
    /*int price;*/
    Integer price;


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
    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
