package com.neo.task.vacationcalculator.service;

import com.neo.task.vacationcalculator.model.Vacation;
import com.neo.task.vacationcalculator.utils.Constants;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

@Service
public class VacationCalculatorService {

    public void setVacationData(Vacation vacation) {
        vacation.setHolidaysInVacation(checkVacationInHolidays(vacation.getVacationStart(), vacation.getVacationEnd()));
        vacation.setVacationsDays(calculateVacationDays(vacation.getVacationStart(), vacation.getVacationEnd()));
        vacation.setVacationPay(calculateVacationPay(vacation));
    }


    public double calculateVacationPay(Vacation vacation) {
        double averageSalaryPerDays = vacation.getAverageSalary() / Constants.AVERAGE_CALENDAR_DAYS_IN_YEAR;
        return averageSalaryPerDays * calculateVacationDays(vacation.getVacationStart(), vacation.getVacationEnd());
    }

    public int calculateVacationDays(Date vacationsStart, Date vacationEnd) {
        long timeBetween = vacationEnd.getTime() - vacationsStart.getTime();
        int vacationDays = (int) TimeUnit.DAYS.convert(timeBetween, TimeUnit.MILLISECONDS) + 1;
        return vacationDays + checkVacationInHolidays(vacationsStart, vacationEnd);
    }

    public int checkVacationInHolidays(Date vacationsStart, Date vacationEnd) {
        int holidaysInVacation = 0;
        for (Date holidays : Constants.HOLIDAYS_IN_2022) {
            if (!(holidays.before(vacationsStart) || holidays.after(vacationEnd))) {
                holidaysInVacation++;
            }
        }
        return holidaysInVacation;
    }
}
