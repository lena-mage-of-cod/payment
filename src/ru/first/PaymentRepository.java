package ru.first;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public abstract class PaymentRepository {


    public abstract  Stream<Payment> findAll();

    // найти все платежи за указанный интервал
    public abstract  List<Payment> findAllInPeriod(LocalDateTime start, LocalDateTime end);

    // найти общее количество денег, потраченных на еду за указанный интервал
    public abstract  Double spentOnFood(LocalDateTime start, LocalDateTime end);

    // найти категории продуктов, на которые было потрачено больше чем планировалось
    public abstract List<ProductCategory> spentMoreThanPlanned(Double planned);

    // найти все платежи со счета, сгруппированные по категориям
    public abstract Map<ProductCategory, List<Payment>> groupedByCategory(String accountNumber, String bic);

    // найти все платежи между разными счетами
    public abstract List<Payment> paymentsBetweenDifferentAccounts();

    // найти сумму платежей за период
    public abstract Double paymentSumInPeriod(LocalDateTime start, LocalDateTime end);

    // получить дни с самым большим платежом
    public abstract List<LocalDate> findDaysWithBiggestPayment();

    // получить первый попавшийся день с самым большим платежом
    public abstract LocalDate findFirstDayWithBiggestPayment();

    // получить информацию по количеству переводов на счета получателя
    public abstract List<AccountInfo> findPaymentsCountForAccount();

    // получить количество переводов на заданный счет
    public abstract long paymentsCount(String accountNumber, String bic);
}


