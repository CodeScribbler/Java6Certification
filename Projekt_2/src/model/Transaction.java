package model;


import java.util.Date;


public class Transaction {

    private Date timestamp;

    private TransactionType transType;

    private String description;

    private double amount;


    enum TransactionType {

        DESPOSIT, DISBURSEMENT

    }
}
