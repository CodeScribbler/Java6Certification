package Kontoverwaltung.model;


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
    public Account(long accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return "IBAN: " + accountNumber + " Kontostand: " + accountBalance;
    }
}
