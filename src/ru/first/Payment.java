package ru.first;

import ru.first.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {
    private Account from;
    private Account to;
    private Double amount;
    private LocalDateTime dateTime;
    private ProductCategory productCategory;

    public Payment(Account from,Account to,Double amount, LocalDateTime dateTime, ProductCategory productCategory){
        this.from = from;
        this.to=to;
        this.amount=amount;
        this.dateTime = dateTime;
        this.productCategory = productCategory;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", productCategory=" + productCategory +
                '}';
    }
}
