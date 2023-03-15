package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editNum1;
    EditText editNum2;
    String textNum1;
    String textNum2;
    int num1;
    int num2;
    Button buttonPotencia;
    Button buttonFibonacci;
    Button buttonMultiplicacion;
    int resultadoPotencia;
    int resultadoFibonacci;
    int resultadoMultiplicacion;
    TextView resultado;
    Button reiniciar;
    Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = findViewById(R.id.num1);
        editNum2 = findViewById(R.id.num2);
        buttonPotencia = findViewById(R.id.potencia);
        buttonFibonacci = findViewById(R.id.fibonacci);
        buttonMultiplicacion = findViewById(R.id.multiplicacion);
        resultado = findViewById(R.id.resultado);
        reiniciar = findViewById(R.id.reiniciar);

        buttonPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarDatos(editNum1, editNum2);
                resultadoPotencia = calculadora.potencia(num1, num2);
                String textPotencia = getStringNum(resultadoPotencia);
                resultado.setText(textPotencia);
            }
        });

        buttonFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarDatos(editNum1);
                resultadoFibonacci = calculadora.fibonacci(num1);
                String textFibonacci = getStringNum(resultadoFibonacci);
                resultado.setText(textFibonacci);
            }
        });

        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarDatos(editNum1, editNum2);
                resultadoMultiplicacion = calculadora.multiplicacion(num1, num2);
                String textMultiplicacion = getStringNum(resultadoMultiplicacion);
                resultado.setText(textMultiplicacion);
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNum1.setText("");
                editNum2.setText("");
                resultado.setText("");
            }
        });

    }

    protected void iniciarDatos(EditText editNum1){
        this.calculadora = new Calculadora();
        this.num1 = getIntNum(editNum1);
    }

    protected void iniciarDatos(EditText editNum1, EditText editNum2){
        this.calculadora = new Calculadora();
        this.num1 = getIntNum(editNum1);
        this.num2 = getIntNum(editNum2);
    }

    public int getIntNum(EditText editNum1){
        textNum1 = editNum1.getText().toString();
        int num = Integer.parseInt(textNum1);
        return num;
    }

    public String getStringNum(int resultOperacion){
        String textOperacion = String.valueOf(resultOperacion);
        return  textOperacion;
    }
}