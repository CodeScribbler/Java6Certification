package model;

import java.util.LinkedList;


public class Account {

    /**
     *
     */
    private final long accountNumber;

    /**
     *
     */
    private double accountBalance;

    /**
     *
     */
    public static long ledgerNumber = 1000;


    private LinkedList<Transaction> transactionsList = new LinkedList<Transaction>();


    public void addTransaction(Transaction transaction) {
        this.transactionsList.add(transaction);
    }

    /**
     *
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     *
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     *
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    /**
     *
     */
    @Override
    public String toString() {
        return "IBAN: " + accountNumber + " Kontostand: " + accountBalance;
    }


    /**
     *
     */
    public Account(long accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

}
