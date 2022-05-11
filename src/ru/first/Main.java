package ru.first;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	Account me = new Account("111","11111111");
	Account products = new Account("222","222222");
	Account cafe = new Account("333","33333");
	Account cours = new Account("444","444444");
	Account college = new Account("555","555555");
	Account doctors = new Account("666","6666666");
	Account procedurs = new Account("777","77777");
        LocalDateTime runDate10 = LocalDateTime.of(2022,05,10,13,14,10,2);
        LocalDateTime runDate9 = LocalDateTime.of(2022,05,9,13,14,10,2);
        LocalDateTime runDate8 = LocalDateTime.of(2022,05,8,13,14,10,2);
        LocalDateTime runDate7 = LocalDateTime.of(2022,05,7,13,14,10,2);
        LocalDateTime runDate6= LocalDateTime.of(2022,05,6,13,14,10,2);
        LocalDateTime runDate52 = LocalDateTime.of(2022,05,5,13,14,10,2);
        LocalDateTime runDate51 = LocalDateTime.of(2022,05,5,15,14,10,2);

        LocalDateTime runDate4 = LocalDateTime.of(2022,05,4,13,14,10,2);
        LocalDateTime runDate3 = LocalDateTime.of(2022,05,3,13,14,10,2);
        LocalDateTime runDate2 = LocalDateTime.of(2022,05,2,13,14,10,2);
        LocalDateTime runDate1 = LocalDateTime.of(2022,05,1,13,14,10,2);

	Payment food1 = new Payment(me,products,5000.00,runDate1,ProductCategory.FOOD);
	Payment food2 = new Payment(me,cafe,250.00,runDate2,ProductCategory.FOOD);
	Payment education1 = new Payment(me,cours,2000.00,runDate3,ProductCategory.EDUCATION);
	Payment education2 = new Payment(me,college,5000.00,runDate4,ProductCategory.EDUCATION);
	Payment medicine1 = new Payment(me,doctors,3000.00,runDate51,ProductCategory.MEDICINE);
	Payment medicine2 = new Payment(me,doctors,1000.00,runDate51,ProductCategory.MEDICINE);
	Payment food3= new Payment(me,cafe,500.00,runDate8,ProductCategory.FOOD);
	Payment medicine3 = new Payment(me,procedurs,5000.00,runDate52,ProductCategory.MEDICINE);

	PaymentRepository repository = new PaymentRepositoryImpl(food1,food2,food3,education1,education2,medicine1,medicine2,medicine3);









    }
}
