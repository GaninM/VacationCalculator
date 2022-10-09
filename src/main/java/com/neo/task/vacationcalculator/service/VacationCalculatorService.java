package com.neo.task.vacationcalculator.service;

import com.neo.task.vacationcalculator.model.Vacation;
import com.neo.task.vacationcalculator.utils.Constants;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

@Service
public class VacationCalculatorService {

    public void setVacationData(Vacation vacation) {
        vacation.setHolidaysInVacation(checkVacationOnHolidays(vacation.getVacationStart(), vacation.getVacationEnd()));
        vacation.setVacationsDays(calculateVacationDays(vacation.getVacationStart(), vacation.getVacationEnd()));
        vacation.setVacationPay(calculateVacationPay(vacation));
    }


    public double calculateVacationPay(Vacation vacation) {
        double averageSalaryPerDays = vacation.getAverageSalary() / Constants.AVERAGE_CALENDAR_DAYS_IN_MONTH;
        double scale = Math.pow(10, 2);
        return Math.ceil((averageSalaryPerDays * calculateVacationDays(vacation.getVacationStart(),
                vacation.getVacationEnd())) * scale) / scale;
    }

    public int calculateVacationDays(Date vacationsStart, Date vacationEnd) {
        long timeBetween = vacationEnd.getTime() - vacationsStart.getTime();
        int vacationDays = (int) TimeUnit.DAYS.convert(timeBetween, TimeUnit.MILLISECONDS) + 1;
        return vacationDays - checkVacationOnHolidays(vacationsStart, vacationEnd);
    }

    public int checkVacationOnHolidays(Date vacationsStart, Date vacationEnd) {
        int holidaysInVacation = 0;
        for (Date holidays : Constants.HOLIDAYS_IN_2022) {
            if (!(holidays.before(vacationsStart) || holidays.after(vacationEnd))) {
                holidaysInVacation++;
            }
        }
        return holidaysInVacation;
    }
}
