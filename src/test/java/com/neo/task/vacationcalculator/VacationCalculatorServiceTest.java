package com.neo.task.vacationcalculator;

import com.neo.task.vacationcalculator.model.Vacation;
import com.neo.task.vacationcalculator.service.VacationCalculatorService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class VacationCalculatorServiceTest {

    public Vacation testVacation = new Vacation();
    public VacationCalculatorService vacationCalculatorService = new VacationCalculatorService();


    @Before
    public void setUp() {
        testVacation.setVacationStart(new Date(2022 - 1900, 2, 1));
        testVacation.setVacationEnd(new Date(2022 - 1900, 2, 14));
        testVacation.setVacationsDays(14);
        testVacation.setAverageSalary(28000);
        testVacation.setHolidaysInVacation(1);

    }


    @Test
    void checkVacationOnHolidays_AssertTrue() {
        Assertions.assertEquals(vacationCalculatorService.checkVacationOnHolidays(testVacation.getVacationStart(),
                testVacation.getVacationEnd()), 1);
    }

    @Test
    void checkVacationOnHolidays_AssertFalse() {
        Assertions.assertNotEquals(vacationCalculatorService.checkVacationOnHolidays(testVacation.getVacationStart(),
                testVacation.getVacationEnd()), 5);
    }

    @Test
    void calculateVacationDays_AssertTrue(){
        testVacation.setVacationStart(new Date(2022 - 1900, 2, 1));
        testVacation.setVacationEnd(new Date(2022 - 1900, 2, 14));
        Assertions.assertEquals(vacationCalculatorService.calculateVacationDays(testVacation.getVacationStart(),
                testVacation.getVacationEnd()), 13);
    }

    @Test
    void calculateVacationDays_AssertFalse(){
        Assertions.assertNotEquals(vacationCalculatorService.calculateVacationDays(testVacation.getVacationStart(),
                testVacation.getVacationEnd()), 12);
    }

    @Test
    void calculateVacationPay_AssertTrue() {
        testVacation.setVacationStart(new Date(2022 - 1900, 2, 1));
        testVacation.setVacationEnd(new Date(2022 - 1900, 2, 14));
        testVacation.setAverageSalary(28000.00);
        Assertions.assertEquals(vacationCalculatorService.calculateVacationPay(testVacation), 12423.21);
    }

    @Test
    void calculateVacationPay_AssertFalse() {
        testVacation.setVacationStart(new Date(2022 - 1900, 2, 1));
        testVacation.setVacationEnd(new Date(2022 - 1900, 2, 14));
        testVacation.setAverageSalary(28000.00);
        Assertions.assertNotEquals(vacationCalculatorService.calculateVacationPay(testVacation), 15000.00);
    }
}
