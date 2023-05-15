package com.example.calculadorasal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.calculadorasal.modelo.service.SalaryCalculationService;
import com.example.calculadorasal.modelo.service.imple.SalaryCalculationServiceImpl;

public class MainActivity extends AppCompatActivity {
//declarado elementos
    private TextView textViewResul;
    private EditText idSalario;
    private EditText idHorasExtras;
    private RadioButton radioButtonNo;
    private RadioButton radioButtonSi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// instanciando los elementos anteriormente declarados
        textViewResul = findViewById(R.id.textViewResul);
        idSalario = findViewById(R.id.idSalario);
        idHorasExtras = findViewById(R.id.idHorasExtras);
        radioButtonNo = findViewById(R.id.radioButtonNo);
        radioButtonSi = findViewById(R.id.radioButtonSi);

    }


    public void CalcularSalario(View view){
        SalaryCalculationServiceImpl salaryCalculationService = new SalaryCalculationServiceImpl();
        float salarioBase = Float.parseFloat(idSalario.getText().toString());
        int idHorasEx = Integer.parseInt(idHorasExtras.getText().toString());
        String bonusSi = radioButtonSi.getText().toString();
        String bonusNo = radioButtonNo.getText().toString();
        boolean bonus = false;
        if (bonusSi.equals("Si")){
            bonus = true;
        }

        float salarioCalculado = salaryCalculationService.calculateMonthSalary(salarioBase, idHorasEx, bonus);
        textViewResul.setText(String.valueOf(salarioCalculado));
    }


}

