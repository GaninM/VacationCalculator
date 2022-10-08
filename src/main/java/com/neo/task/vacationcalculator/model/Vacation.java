package com.neo.task.vacationcalculator.model;

public class Vacation {

    private int vacationsDays;
    private double averageSalary;
    private double vacationPay = 0.0;

    public Integer getVacationsDays() {
        return vacationsDays;
    }

    public void setVacationsDays(Integer vacationsDays) {
        this.vacationsDays = vacationsDays;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public Double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(Double vacationPay) {
        this.vacationPay = vacationPay;
    }
}
