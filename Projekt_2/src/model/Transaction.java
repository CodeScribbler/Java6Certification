package model;

import java.util.Date;


public class Transaction {

    private Date timestamp;

    private TransactionType transType;

    private String description;

    private double amount;


    public Date getTimestamp() {
        return timestamp;
    }

    public TransactionType getTransType() {
        return transType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return  " Zeitpunkt: " + this.timestamp + "\n" +
                " Transaktionstyp: " + this.transType + "\n" +
                " Betrag: " + this.amount + "\n" +
                " Beschreibung: " + this.description;
    }

    public Transaction(Date timestamp, TransactionType transType, double amount, String description) {
        this.timestamp = timestamp;
        this.transType = transType;
        this.description = description;
        this.amount = amount;
    }


    public enum TransactionType {

        DESPOSIT, DISBURSEMENT

    }

}
