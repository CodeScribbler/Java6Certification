package model;


import java.util.*;


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
    public static long IBAN = 1000;



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



    private LinkedList<Transaction> transactionsList = new LinkedList<Transaction>();


    public boolean addTransaction(Transaction transaction) {
        if(transaction.getTransType() == Transaction.TransactionType.DESPOSIT)
            this.accountBalance += transaction.getAmount();

        if(transaction.getTransType() == Transaction.TransactionType.DISBURSEMENT)
            this.accountBalance -= transaction.getAmount();

        return transactionsList.add(transaction);
    }


    public List<Transaction> getSortedTransList(String option) {
        List<Transaction> result = new ArrayList<Transaction>(transactionsList);
        if (option.equalsIgnoreCase("ASC"))
            Collections.sort(result, byTimestampAsc);
        else
            Collections.sort(result, byTimestampDsc);

        return result;
    }


    private static final Comparator<Transaction> byTimestampAsc = new Comparator<Transaction>() {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            if (t1.getTimestamp().before(t2.getTimestamp()))
                return -1;
            if (t1.getTimestamp().after(t2.getTimestamp()))
                return 1;
            else
                return 0;
        }
    };

    private static final Comparator<Transaction> byTimestampDsc = new Comparator<Transaction>() {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            if (t1.getTimestamp().after(t2.getTimestamp()))
                return -1;
            if (t1.getTimestamp().before(t2.getTimestamp()))
                return 1;
            else
                return 0;
        }
    };



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
