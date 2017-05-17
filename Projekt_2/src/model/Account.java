package model;

import java.util.*;


public class Account {

    /**
     *
     */
    public static long IBAN = 1000;


    /**
     *
     */
    private long accountNumber;

    /**
     *
     */
    private double accountBalance;


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
    private LinkedList<Transaction> transactionsList = new LinkedList<Transaction>();


    /**
     *
     * @param transaction
     * @return
     */
    public boolean addTransaction(Transaction transaction) {
        if(transaction.getTransType() == TransactionType.DESPOSIT)
            this.accountBalance += transaction.getAmount();

        if(transaction.getTransType() == TransactionType.DISBURSEMENT)
            this.accountBalance -= transaction.getAmount();

        return transactionsList.add(transaction);
    }

    /**
     *
     * @return
     */
    public int getTransListSize() {
        return this.transactionsList.size();
    }

    /**
     *
     * @param option
     * @return
     */
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

    public Account() {}




    /**
     *
     */
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
            return Account.this.accountNumber + ";"+  this.timestamp + ";" + ((this.transType == TransactionType.DESPOSIT) ? "Einzahlung;" : "Auszahlung;" ) + this.description + ";" + this.amount + " €";
        }

        public Transaction(Date timestamp, TransactionType transType, double amount, String description) {
            this.timestamp = timestamp;
            this.transType = transType;
            this.amount = amount;
            this.description = description;
        }
    }


}


