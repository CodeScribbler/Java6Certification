package model;

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
    private String birthdate;


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
    public String getBirthdate() {
        return birthdate;
    }


    //  Construktor

    /**
     *
     */
    public PrivateCustomer(String address, String phoneNumber, CustomerTyp profile, String email, String firstName, String lastname, String birthdate) {
        super(address, phoneNumber, profile, email);
        this.firstName = firstName;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

}
