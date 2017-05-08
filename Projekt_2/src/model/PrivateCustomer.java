package model;

import java.util.Date;

public class PrivateCustomer extends Customer {

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastname;

    /**
     *
     */
    private Date birthdate;


    /**
     *
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     */
    public Date getBirthdate() {
        return birthdate;
    }


    //  Construktor

    /**
     *
     */
    public PrivateCustomer(int customerId, String address, String phoneNumber, CustomerTyp profile, String email, String firstName, String lastname, Date birthdate) {
        super(customerId, address, phoneNumber, profile, email);
        this.firstName = firstName;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

}
