package Kontoverwaltung.model;


public class Counterpart {

    // Attributes

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
    private String phoneNumber;


    //  Getter

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
    public String getPhoneNumber() {
        return phoneNumber;
    }


    //  Constructor

    /**
     *
     */
    public Counterpart(String firstName, String lastname, String phoneNumber) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

}
