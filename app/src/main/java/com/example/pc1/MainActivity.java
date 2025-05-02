package com.example.pc1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText numero1, numero2, suma;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        suma = findViewById(R.id.suma);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor1 = numero1.getText().toString(); // Obtener el valor de numero1

                // Validar que el valor no esté vacío
                if (!valor1.isEmpty()) {
                    // Crear un Intent para abrir SecondActivity
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("valor1", valor1); // Pasar solo el valor de numero1
                    startActivity(intent);
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
                String operacion = suma.getText().toString(); // Obtener la operación (Suma, Resta, etc.)

                // Validar que los valores no estén vacíos y que la operación no esté vacía
                if (!valor1.isEmpty() && !valor2.isEmpty() && !operacion.isEmpty()) {
                    try {
                        // Crear un Intent para abrir SecondActivity
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("valor1", valor1); // Pasar el valor de numero1
                        intent.putExtra("valor2", valor2); // Pasar el valor de numero2
                        intent.putExtra("operacion", operacion); // Pasar la operación seleccionada
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
                    if (operacion.isEmpty()) {
                        suma.setError("Por favor, ingresa una operación");
                    }
                }
            }
        });



    }
}
