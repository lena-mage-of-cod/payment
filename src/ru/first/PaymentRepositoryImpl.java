package ru.first;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentRepositoryImpl extends PaymentRepository {

    private final List<Payment> payments;

    public PaymentRepositoryImpl(Payment... payments) {
        this.payments = Arrays.asList(payments);
    }

    @Override
    public Stream<Payment> findAll() {
        return payments.stream();
    }

    @Override
    public List<Payment> findAllInPeriod(LocalDateTime start, LocalDateTime end) {
        return findAll().filter(s -> s.getDateTime().isAfter(start) && s.getDateTime().isBefore(end)).collect(Collectors.toList());
    }

    @Override
    public Double spentOnFood(LocalDateTime start, LocalDateTime end) {


        return findAll().filter(s -> s.getDateTime().isAfter(start) && s.getDateTime().isBefore(end)).
                filter(s -> s.getProductCategory().equals(ProductCategory.FOOD)).mapToDouble(Payment::getAmount).sum();
    }

    @Override
    public List<ProductCategory> spentMoreThanPlanned(Double planned) {
        List<ProductCategory> listOfCategory = new ArrayList<>();
        for (ProductCategory category : ProductCategory.values()) {
            Double sum = findAll().filter(s -> s.getProductCategory().equals(category)).
                    mapToDouble(Payment::getAmount).sum();
            if (sum > planned) {
                listOfCategory.add(category);
            }

        }
        return listOfCategory;
    }

    @Override
    public Map<ProductCategory, List<Payment>> groupedByCategory(String accountNumber, String bic) {
        Map<ProductCategory, List<Payment>> categoryListMap = new HashMap<>();
        for (ProductCategory category : ProductCategory.values()) {
            categoryListMap.put(category, findAll().filter(s -> s.getFrom().getAccountNumber().equals(accountNumber)
                    && s.getFrom().getBic().equals(bic) && s.getProductCategory().equals(category)).
                    collect(Collectors.toList()));
        }
        return categoryListMap;
    }

    @Override
    public List<Payment> paymentsBetweenDifferentAccounts() {
        return findAll().filter(s -> !s.getFrom().equals(s.getTo())).collect(Collectors.toList());
    }

    @Override
    public Double paymentSumInPeriod(LocalDateTime start, LocalDateTime end) {

        return findAll().filter(s -> s.getDateTime().isAfter(start) && s.getDateTime().isBefore(end)).
                mapToDouble(Payment::getAmount).sum();
    }

    @Override
    public List<LocalDate> findDaysWithBiggestPayment() {
        List<LocalDate> listOfDays = new ArrayList<>();
        findAll().filter(s -> s.getAmount().equals(findAll().mapToDouble(Payment::getAmount).max().getAsDouble())).
                forEach(s -> listOfDays.add(s.getDateTime().toLocalDate()));
        return listOfDays;
    }

    @Override
    public LocalDate findFirstDayWithBiggestPayment() {
        return findAll().filter(s -> s.getAmount().equals(findAll().mapToDouble(Payment::getAmount).max().getAsDouble())).
                findFirst().get().getDateTime().toLocalDate();

    }

    @Override
    public List<AccountInfo> findPaymentsCountForAccount() {
        List<AccountInfo> infoOfRecepient = new ArrayList<>();
        for (Payment payment : payments) {
            AccountInfo recepient = new AccountInfo(payment.getTo(),
                    Long.valueOf(findAll().filter(s -> s.getTo().equals(payment.getTo())).count()).intValue());
            infoOfRecepient.add(recepient);
        }
        return infoOfRecepient;
    }

    @Override
    public long paymentsCount(String accountNumber, String bic) {
        return findAll().filter(s -> s.getTo().getAccountNumber().equals(accountNumber) && s.getTo().getBic().equals(bic)).
                count();
    }

}
