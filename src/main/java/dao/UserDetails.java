package dao;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    // when we want to use embedded object as the embedded key(primary key) combinateion of some filelds is prmary key then we will use @Embedded id
    private int id;
    private String name;


    @ElementCollection(fetch=FetchType.EAGER) // this is used when we want to save the embeddeble list as
    // collection into other table
    // as storing 5 addresses in the collection would be tough so we want a table
    // hiubernbtae gives name as name of n=main tablke_ jcollection
    // so now we give name on our own using join table
   /* @JoinTable(name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "user_id")
    )*/
   // join column gives the name to the join id i.e foreign key
    /* private Set<Address> address=new HashSet<Address>();*/

   /* @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = @Column(name = "ADDRESS_ID"), type = @Type(type = "long"), generator = "hilo-gen")*/
    private Collection<Address> address = new ArrayList<Address>(); // arraylist supports id so we have used it
    // we have no primary key in address so we provide it with auto generate
    private String phone;
    private Date dob;

   /* @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
            @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE"))

    })
    private Address homeAddress;
    @Embedded
    private Address officeAddress;*/
    // here we  have used two  adresses bt if a user has many addresses and we dont know in that case we will design our\
    // table to have separate table for the Address so commenting home address and officeaddress
   /* public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }*/

    /*   public Set<Address> getAddress() {
           return address;
       }

       public void setAddress(Set<Address> address) {
           this.address = address;
       }*/
    public Collection<Address> getAddress() {
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }

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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

}
