package com.example.calculadorasal.modelo.service.imple;

import com.example.calculadorasal.modelo.service.SalaryCalculationService;

public class SalaryCalculationServiceImpl implements SalaryCalculationService {
    private final int VALOR_JORNADA_LABORAL_ESTABLECIDA = 192;
    private final float PORCENTAJE_EXTRA_VALOR_HORA = 0.25f;
    private final float PORCENTAJE_BONIFICACION = 0.05f;
    private final float SALUD_PORCENTAJE_DESCUENTO = 3.5f;
    private final float PENSION_PORCENTAJE_DESCUENTO = 4f;
    private final float COMPENSASION_PORCENTAJE_DESCUENTO = 1f;


    @Override
    public float calculateMonthSalary(float baseSalaryPerMonth, int extraHours, boolean hasBonus) {

        float hourValue = calculateWorkHour(baseSalaryPerMonth);
        float extraHoursValue = calculateExtraHour(extraHours, hourValue);
        float totalSalary=baseSalaryPerMonth;
        if (extraHours!=0||hasBonus) {
            totalSalary =Math.round(baseSalaryPerMonth + extraHoursValue);
            totalSalary = addPercent(totalSalary, PORCENTAJE_BONIFICACION);
        }
        return taxDiscount(totalSalary);
    }

    @Override
    public float calculateWorkHour(float baseSalaryPerMoth) {
        return Math.round(baseSalaryPerMoth / VALOR_JORNADA_LABORAL_ESTABLECIDA);
    }

    @Override
    public float calculateExtraHour(int numberExtraHours, float valueWorkHour) {
        return Math.round(addPercent(valueWorkHour, PORCENTAJE_EXTRA_VALOR_HORA) * numberExtraHours);
    }

    @Override
    public float taxDiscount(float totalSalaryPerMonth) {
        float salaryHealthTax = discountPercent(totalSalaryPerMonth, SALUD_PORCENTAJE_DESCUENTO);
        float salaryPensionHealthTax = discountPercent(salaryHealthTax, PENSION_PORCENTAJE_DESCUENTO);
        return Math.round(discountPercent(salaryPensionHealthTax, COMPENSASION_PORCENTAJE_DESCUENTO));
    }

    private float addPercent(float numero, float porcentaje) {

        return numero+Math.round(numero * porcentaje);
    }

    private float discountPercent(float numero, float porcentaje) {
        return Math.round(numero * (1 - porcentaje / 100));
    }
}
