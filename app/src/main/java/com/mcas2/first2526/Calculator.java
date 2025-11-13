package com.mcas2.first2526;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private TextView tvResultado;
    private double num1 = 0;
    private double num2 = 0;
    private String operacion = "";
    private boolean isNewOp = true; // Para saber si debemos limpiar la pantalla al escribir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);

        // 1. Vincular la pantalla
        tvResultado = findViewById(R.id.pantallaResultados);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (isNewOp) {
                    tvResultado.setText("");
                    isNewOp = false;
                }
                String currentText = tvResultado.getText().toString();
                if (b.getText().toString().equals(".") && currentText.contains(".")) {
                    return;
                }
                tvResultado.append(b.getText().toString());
            }
        };

        int[] numberIds = {R.id.button17, R.id.button13, R.id.button14, R.id.button15, R.id.button12,
                R.id.button11, R.id.button10, R.id.button8, R.id.button7, R.id.button6, R.id.button19};

        for (int id : numberIds) {
            Button btn = findViewById(id);
            if (btn != null) btn.setOnClickListener(numberListener);
        }

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String aux = tvResultado.getText().toString();
                if (!aux.isEmpty()) {
                    num1 = Double.parseDouble(aux);
                    operacion = b.getText().toString();
                    isNewOp = true;
                }
            }
        };

        int[] opIds = {R.id.button16, R.id.button9, R.id.button5, R.id.button1};
        for (int id : opIds) {
            Button btn = findViewById(id);
            if (btn != null) btn.setOnClickListener(opListener);
        }

        // 4. Botón Igual (=)
        Button btnIgual = findViewById(R.id.button20);
        if (btnIgual != null) {
            btnIgual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcular();
                }
            });
        }

        // 5. Botón Limpiar (C)
        Button btnClear = findViewById(R.id.button4);
        if (btnClear != null) {
            btnClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvResultado.setText("0");
                    num1 = 0;
                    num2 = 0;
                    operacion = "";
                    isNewOp = true;
                }
            });
        }
    }

    // Lógica matemática
    private void calcular() {
        String aux = tvResultado.getText().toString();
        if (!aux.isEmpty() && !operacion.isEmpty()) {
            num2 = Double.parseDouble(aux);
            double resultado = 0;

            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*": // Asegúrate de que el texto del botón en XML sea "*" o "x"
                case "x":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        tvResultado.setText("Error");
                        return;
                    }
                    break;
            }
            tvResultado.setText(String.valueOf(resultado));
            isNewOp = true; // Listo para la siguiente operación
        }
    }
}