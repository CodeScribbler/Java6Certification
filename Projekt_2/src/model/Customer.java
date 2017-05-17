package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    //  Attributes

    /**
     *
     */
    private String customerId;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private String phoneNumber;

    /**
     *
     */
    private CustomerTyp profile;

    /**
     *
     */
    private String email;


    /**
     *
     */
    private final List<Account> accountsList = new ArrayList<Account>(10);

//    {
//        accountsList.add(new Account(1000, 1500));
//    }


    //  Getter

    /**
     *
     */
    public String getCustomerId() {
        return this.customerId;
    }



    //  Methods

    /**
     *
     */
    public int getAccountSize() {
        return this.accountsList.size();
    }

    /**
     *
     */
    public boolean addAccount(Account obj) {
        return this.accountsList.add(obj);
    }

    /**
     *
     */
    public List<Account> getAccounts() {
        return this.accountsList;
    }


    // Constructor

    /**
     *
     */
    public Customer(String address, String phoneNumber, CustomerTyp profile, String email) {
        this.customerId = CustomerNumberGenerator.getInstance().getNumber();
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.profile = profile;
        this.email = email;
    }

}

