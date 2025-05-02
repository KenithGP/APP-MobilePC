package com.example.pc1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textoValor1, textoValor2, textoOperacion, textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textoValor1 = findViewById(R.id.textoValor1);
        textoValor2 = findViewById(R.id.textoValor2);
        textoOperacion = findViewById(R.id.textoOperacion);
        textoResultado = findViewById(R.id.textoResultado);

        // Obtener los valores pasados desde MainActivity
        String valor1 = getIntent().getStringExtra("valor1");
        String valor2 = getIntent().getStringExtra("valor2");
        String operacion = getIntent().getStringExtra("operacion");

        // Convertir los valores a números
        double num1 = 0;
        double num2 = 0;
        double resultado = 0;

        try {
            num1 = Double.parseDouble(valor1);
            num2 = Double.parseDouble(valor2);
        } catch (NumberFormatException e) {
            textoResultado.setText("Error: Entrada no válida");
            return;
        }

        // Realizar la operación seleccionada
        switch (operacion) {
            case "Suma":
                resultado = num1 + num2;
                break;
            case "Resta":
                resultado = num1 - num2;
                break;
            case "Multiplica":
                resultado = num1 * num2;
                break;
            case "Divide":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    textoResultado.setText("Error: División por cero");
                    return;
                }
                break;
            default:
                textoResultado.setText("Operación no válida");
                return;
        }

        // Mostrar los valores, operación y resultado en los TextViews
        textoValor1.setText("Valor 1: " + valor1);
        textoValor2.setText("Valor 2: " + valor2);
        textoOperacion.setText("Operación: " + operacion);
        textoResultado.setText("Resultado: " + resultado);
    }
}
