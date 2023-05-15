package com.example.calculadorasal.modelo;

public class SalarioCalculo {
    double salario;
   double horasExtras;
    boolean bonificacion;



    //metodo
public double calcularSalario(){

    double horas = salario / 192;
    double numeroHorasExtras = 1.25 * horas * horasExtras;
    double bonificaciones = 0 ;

    //Utilizaremos una estructura de control para conocer si recibe bonificaciones o si no
     if (bonificacion){
         bonificaciones = 0.05 * salario;
     }

     double salarioSinDescuento = salario +  numeroHorasExtras + bonificaciones;

     //formulas para calcular Descuentos
    double descSalud = salario * 0.035;
    double descCaja = salario * 0.01;
    double descPension = salario * 0.04;

    double totalAPagar = salarioSinDescuento - descPension - descCaja - descSalud;

    return totalAPagar;
}


}
