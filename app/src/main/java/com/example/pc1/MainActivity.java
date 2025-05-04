package com.example.pc1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText numero1, numero2;
    Button btn1, btn2, btn3;

    RadioGroup radioGroup;
    RadioButton radioSuma, radioResta, radioMultiplica, radioDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        radioGroup = findViewById(R.id.radioGroupOperaciones);
        radioSuma = findViewById(R.id.radioSuma);
        radioResta = findViewById(R.id.radioResta);
        radioMultiplica = findViewById(R.id.radioMultiplica);
        radioDivide = findViewById(R.id.radioDivide);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor1 = numero1.getText().toString(); // Obtener el valor de numero1

                // Validar que el valor no esté vacío
                if (!valor1.isEmpty()) {
                    try {
                        // Crear un Intent para abrir SecondActivity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("valor1", valor1); // Pasar solo el valor de numero1
                        Toast.makeText(MainActivity.this, "Valor 1: " + valor1, Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                    } catch (Exception e) {
                        // Mostrar mensaje de error si ocurre una excepción
                        e.printStackTrace();
                        numero1.setError("Error al procesar el valor");
                    }
                } else {
                    // Mostrar un mensaje si el valor está vacío
                    numero1.setError("Por favor, ingresa un valor en el primer campo");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor1 = numero1.getText().toString(); // Obtener el valor de numero1
                String valor2 = numero2.getText().toString(); // Obtener el valor de numero2

                // Validar que los valores no estén vacíos
                if (!valor1.isEmpty() && !valor2.isEmpty()) {
                    // Crear un Intent para abrir SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("valor1", valor1); // Pasar el valor de numero1
                    intent.putExtra("valor2", valor2); // Pasar el valor de numero2
                    Toast.makeText(MainActivity.this, "Valor 1: " + valor1 + ", Valor 2: " + valor2, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    // Mostrar mensaje de error si algún campo está vacío
                    if (valor1.isEmpty()) {
                        numero1.setError("Por favor, ingresa un valor en el primer campo");
                    }
                    if (valor2.isEmpty()) {
                        numero2.setError("Por favor, ingresa un valor en el segundo campo");
                    }
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor1 = numero1.getText().toString(); // Obtener el valor de numero1
                String valor2 = numero2.getText().toString(); // Obtener el valor de numero2
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Por favor, selecciona una operación", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadio = findViewById(selectedId);
                String operacion = selectedRadio.getText().toString();


                // Validar que los valores no estén vacíos y que la operación no esté vacía
                if (!valor1.isEmpty() && !valor2.isEmpty() && !operacion.isEmpty()) {
                    try {
                        // Crear un Intent para abrir SecondActivity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("valor1", valor1); // Pasar el valor de numero1
                        intent.putExtra("valor2", valor2); // Pasar el valor de numero2
                        intent.putExtra("operacion", operacion); // Pasar la operación seleccionada
                        Toast.makeText(MainActivity.this, "Valor 1: " + valor1 + ", Valor 2: " + valor2 + ", Operación: " + operacion, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } catch (Exception e) {
                        // Manejo de excepciones
                        e.printStackTrace();
                    }
                } else {
                    // Mostrar mensaje de error si algún campo está vacío
                    if (valor1.isEmpty()) {
                        numero1.setError("Por favor, ingresa un valor en el primer campo");
                    }
                    if (valor2.isEmpty()) {
                        numero2.setError("Por favor, ingresa un valor en el segundo campo");
                    }
                }
            }
        });

    }
}
