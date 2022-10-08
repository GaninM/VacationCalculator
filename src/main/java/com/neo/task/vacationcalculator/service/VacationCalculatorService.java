package com.neo.task.vacationcalculator.service;

import com.neo.task.vacationcalculator.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {

    public double calculateVacationPay(int vacationDays, double averageSalaryPerYear) {
        double averageSalaryPerDays = averageSalaryPerYear / Constants.AVERAGE_CALENDAR_DAYS_IN_YEAR;
        return averageSalaryPerDays * vacationDays;
    }
}
