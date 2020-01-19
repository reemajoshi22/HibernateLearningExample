package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Manufacturer")
public class Manufacturer {
    @Id
    int manufacturer_id;
    String country;

    @Column(name="manufacturername")
    String manufacturername;

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturername() {
        return manufacturername;
    }

    public void setManufacturername(String manufacturername) {
        this.manufacturername = manufacturername;
    }
}
