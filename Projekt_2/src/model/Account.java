package model;

import java.util.*;


public class Account {

    /**
     *
     */
    private String accountNumber;

    /**
     *
     */
    private double accountBalance;


    /**
     *
     */
    public String getAccountNumber() {
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
            return t1.getTimestamp().compareTo(t2.getTimestamp());
        }
    };

    private static final Comparator<Transaction> byTimestampDsc = new Comparator<Transaction>() {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            return Integer.reverse(t1.getTimestamp().compareTo(t2.getTimestamp()));
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
    public Account(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public Account() {}



    /**
     *
     */
    public class Transaction {

        private String iban;

        private String timestamp;

        private TransactionType transType;

        private String description;

        private double amount;


        public String getIban() { return iban; }

        public String getTimestamp() {
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
            return "IBAN " + this.iban + ";"+  this.timestamp + ";" + ((this.transType == TransactionType.DESPOSIT) ? "Einzahlung;" : "Auszahlung;" ) + this.description + ";" + this.amount;
        }

        public Transaction(String iban, String timestamp, TransactionType transType, double amount, String description) {
            this.iban = iban;
            this.timestamp = timestamp;
            this.transType = transType;
            this.amount = amount;
            this.description = description;
        }
    }


}


