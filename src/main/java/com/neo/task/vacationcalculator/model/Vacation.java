package com.neo.task.vacationcalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Getter
@Setter
public class Vacation {

    private Date vacationStart = new Date(2022 - 1900, 0, 1);
    private Date vacationEnd = new Date(2022 - 1900, 0, 1);
    private int vacationsDays;
    private int holidaysInVacation;
    private double averageSalary;
    private double vacationPay = 0.0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacation vacation = (Vacation) o;

        if (vacationsDays != vacation.vacationsDays) return false;
        if (holidaysInVacation != vacation.holidaysInVacation) return false;
        if (Double.compare(vacation.averageSalary, averageSalary) != 0) return false;
        if (Double.compare(vacation.vacationPay, vacationPay) != 0) return false;
        if (!Objects.equals(vacationStart, vacation.vacationStart))
            return false;
        return Objects.equals(vacationEnd, vacation.vacationEnd);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vacationStart != null ? vacationStart.hashCode() : 0;
        result = 31 * result + (vacationEnd != null ? vacationEnd.hashCode() : 0);
        result = 31 * result + vacationsDays;
        result = 31 * result + holidaysInVacation;
        temp = Double.doubleToLongBits(averageSalary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(vacationPay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vacation.class.getSimpleName() + "[", "]")
                .add("vacationStart=" + vacationStart)
                .add("vacationEnd=" + vacationEnd)
                .add("vacationsDays=" + vacationsDays)
                .add("holidaysInVacation=" + holidaysInVacation)
                .add("averageSalary=" + averageSalary)
                .add("vacationPay=" + vacationPay)
                .toString();
    }
}
