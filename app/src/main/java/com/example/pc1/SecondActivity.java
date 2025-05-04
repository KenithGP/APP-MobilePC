package com.example.pc1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
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

        // Obtener los valores del Intent
        String valor1 = getIntent().getStringExtra("valor1");
        String valor2 = getIntent().getStringExtra("valor2");
        String operacion = getIntent().getStringExtra("operacion");

        // Mostrar los datos recibidos
        if (valor1 != null && valor2 == null && operacion == null) {
            // Solo valor1 recibido → Botón 1
            textoValor1.setText("Valor 1: " + valor1);
            textoValor2.setText("");
            textoOperacion.setText("");
            textoResultado.setText("");
            Toast.makeText(this, "Solo se envió el valor 1", Toast.LENGTH_SHORT).show();

        } else if (valor1 != null && valor2 != null && operacion == null) {
            // valor1 y valor2 → Botón 2
            textoValor1.setText("Valor 1: " + valor1);
            textoValor2.setText("Valor 2: " + valor2);
            textoOperacion.setText("");
            textoResultado.setText("");
            Toast.makeText(this, "Se enviaron valor 1 y valor 2", Toast.LENGTH_SHORT).show();

        } else if (valor1 != null && valor2 != null && operacion != null) {
            // valor1, valor2 y operacion → Botón 3
            textoValor1.setText("Valor 1: " + valor1);
            textoValor2.setText("Valor 2: " + valor2);
            textoOperacion.setText("Operación: " + operacion);

            double num1, num2, resultado = 0;
            try {
                num1 = Double.parseDouble(valor1);
                num2 = Double.parseDouble(valor2);

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

                textoResultado.setText("Resultado: " + resultado);
                Toast.makeText(this, "Operación realizada con éxito", Toast.LENGTH_SHORT).show();

            } catch (NumberFormatException e) {
                textoResultado.setText("Error: Números inválidos");
            }

        } else {
            // Si no llegó ningún valor válido
            textoResultado.setText("Error: Datos incompletos");
        }
    }
}
