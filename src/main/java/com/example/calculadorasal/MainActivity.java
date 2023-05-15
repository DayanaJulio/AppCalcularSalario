package com.example.calculadorasal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.calculadorasal.modelo.SalarioCalculo;

public class MainActivity extends AppCompatActivity {
//declarado elementos
    private TextView textViewResul;
    private EditText idSalario, idHorasExtras;

    private RadioButton radioButton1, radioButton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// instanciando los elementos anteriormente declarados
        textViewResul = findViewById(R.id.textViewResul);
        idSalario = findViewById(R.id.idSalario);
        idHorasExtras = findViewById(R.id.idHorasExtras);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);

    }

    /**public void CalculoObjeto(View View) {


        SalarioCalculo calcSalEmpleado = new SalarioCalculo(
                idSalario.getText().toString(),
                idHorasExtras.getText().toString(),
                radioButton1.getText().toString(),
                radioButton2.getText().toString());
        textViewResul.setText((int)calcSalEmpleado.calcularSalario());
    }**/



    public void Calcular(View view) {
        SalarioCalculo calculo = new SalarioCalculo();

       textViewResul.setText((int) calculo.calcularSalario());
}
}
