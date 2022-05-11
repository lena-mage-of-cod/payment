package ru.first;

public class Account {

    private String accountNumber;
    private String bic;

    public Account(String accountNumber, String bic){
        this.accountNumber = accountNumber;
        this.bic = bic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
