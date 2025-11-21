package com.viindeel.first2526;

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
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);

        tvResultado = findViewById(R.id.pantallaResultados);

        View.OnClickListener numberListener = v -> {
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
        };

        int[] numberIds = {R.id.button17, R.id.button13, R.id.button14, R.id.button15, R.id.button12,
                R.id.button11, R.id.button10, R.id.button8, R.id.button7, R.id.button6, R.id.button19};

        for (int id : numberIds) {
            Button btn = findViewById(id);
            if (btn != null) btn.setOnClickListener(numberListener);
        }

        View.OnClickListener opListener = v -> {
            Button b = (Button) v;
            String op = b.getText().toString();
            String aux = tvResultado.getText().toString();

            if (op.equals("%")) {
                if (!aux.isEmpty()) {
                    double valor = Double.parseDouble(aux);
                    double resultado = valor / 100;
                    tvResultado.setText(String.valueOf(resultado));
                    isNewOp = true;
                }
                return;
            }

            if (!aux.isEmpty()) {
                num1 = Double.parseDouble(aux);
                operacion = op;
                isNewOp = true;
            }
        };

        int[] opIds = {R.id.button16, R.id.button9, R.id.button5, R.id.button1, R.id.button2};
        for (int id : opIds) {
            Button btn = findViewById(id);
            if (btn != null) btn.setOnClickListener(opListener);
        }

        Button btnIgual = findViewById(R.id.button20);
        if (btnIgual != null) {
            btnIgual.setOnClickListener(v -> calcular());
        }

        Button btnClear = findViewById(R.id.button4);
        if (btnClear != null) {
            btnClear.setOnClickListener(v -> {
                tvResultado.setText("0");
                num1 = 0;
                num2 = 0;
                operacion = "";
                isNewOp = true;
            });
        }

        Button btnMasMenos = findViewById(R.id.button3);
        if (btnMasMenos != null) {
            btnMasMenos.setOnClickListener(v -> {
                String aux = tvResultado.getText().toString();
                if (!aux.isEmpty() && !aux.equals("0")) {
                    try {
                        double valor = Double.parseDouble(aux);
                        valor = valor * -1;
                        if (valor % 1 == 0) {
                            tvResultado.setText(String.valueOf((int) valor));
                        } else {
                            tvResultado.setText(String.valueOf(valor));
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            });
        }
    }

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
                case "*":
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
            isNewOp = true;
        }
    }
}
