package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {

    /**
     *
     */
    public static short ID = 1;


    //  Attributes

    /**
     *
     */
    private int customerId = 0;

    /**
     *
     */
    private String address = null;

    /**
     *
     */
    private String phoneNumber = null;

    /**
     *
     */
    private CustomerTyp profile = null;

    /**
     *
     */
    private String email = null;

    /**
     *
     */
    private final List<Account> accountsList = new ArrayList<Account>(10);


    //  Getter

    /**
     *
     */
    public int getCustomerId() {
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
    public Customer(int customerId, String address, String phoneNumber, CustomerTyp profile, String email) {
        this.customerId = customerId;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.profile = profile;
        this.email = email;
    }

}

