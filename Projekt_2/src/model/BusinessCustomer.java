package model;


public class BusinessCustomer extends Customer {

    //  Attributes

    /**
     *
     */
    private String companyName;

    /**
     *
     */
    private Counterpart contact;

    /**
     *
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     *
     */
    public Counterpart getContact() {
        return contact;
    }


    //  Constructor

    /**
     *
     */
    public BusinessCustomer(String address, String phoneNumber, CustomerTyp profile, String email, String companyName, Counterpart contact) {
        super(address, phoneNumber, profile, email);
        this.companyName = companyName;
        this.contact = contact;
    }

}
