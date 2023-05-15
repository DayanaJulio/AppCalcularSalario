package com.example.calculadorasal.modelo.service;

public interface SalaryCalculationService {
    float calculateMonthSalary(float baseSalaryPerMonth, int extraHours, boolean hasBonus);

    float calculateWorkHour(float baseSalaryPerMoth);

    float calculateExtraHour( int extraHours, float workHour);

    float taxDiscount(float salaryPerMonth);
}
