package ru.first;

public class AccountInfo {
    private Account account;
    private Integer count;

    public AccountInfo(Account account,Integer count){
        this.account=account;
        this.count=count;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "account=" + account +
                ", count=" + count +
                '}';
    }
}
