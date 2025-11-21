package com.viindeel.first2526;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

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
            String buttonText = b.getText().toString();
            String currentText = tvResultado.getText().toString();

            if (isNewOp || currentText.equals(getString(R.string.error))) {
                tvResultado.setText("");
                isNewOp = false;
                currentText = "";
            }

            if (buttonText.equals(".") && currentText.contains(".")) {
                return;
            }

            if (buttonText.equals(".") && currentText.isEmpty()) {
                tvResultado.append("0.");
            } else {
                tvResultado.append(buttonText);
            }
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

            if (aux.equals(getString(R.string.error)) || aux.isEmpty()) {
                return;
            }

            if (op.equals("%")) {
                double valor = safeParseDouble(aux);
                double resultado = valor / 100;
                tvResultado.setText(formatResult(resultado));
                isNewOp = true;
                return;
            }

            num1 = safeParseDouble(aux);
            operacion = op;
            isNewOp = true;
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
                if (!aux.isEmpty() && !aux.equals("0") && !aux.equals(getString(R.string.error))) {
                    double valor = safeParseDouble(aux);
                    valor = valor * -1;
                    tvResultado.setText(formatResult(valor));
                }
            });
        }
    }

    private void calcular() {
        String aux = tvResultado.getText().toString();

        if (aux.isEmpty() || operacion.isEmpty() || aux.equals(getString(R.string.error)) || aux.equals(".")) {
            return;
        }

        num2 = safeParseDouble(aux);
        double resultado = 0;
        boolean error = false;

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
                    error = true;
                }
                break;
        }

        if (error) {
            tvResultado.setText(R.string.error);
        } else {
            tvResultado.setText(formatResult(resultado));
        }

        isNewOp = true;
    }


    private double safeParseDouble(String str) {
        if (str == null || str.isEmpty() || str.equals(".") || str.equals(getString(R.string.error))) {
            return 0;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String formatResult(double val) {
        if (val == (long) val) {
            return String.format(Locale.US, "%d", (long) val);
        } else {
            return String.valueOf(val);
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("NUM1", num1);
        outState.putDouble("NUM2", num2);
        outState.putString("OPERACION", operacion);
        outState.putBoolean("IS_NEW_OP", isNewOp);
        outState.putString("TEXTO_PANTALLA", tvResultado.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num1 = savedInstanceState.getDouble("NUM1");
        num2 = savedInstanceState.getDouble("NUM2");
        operacion = savedInstanceState.getString("OPERACION");
        isNewOp = savedInstanceState.getBoolean("IS_NEW_OP");
        tvResultado.setText(savedInstanceState.getString("TEXTO_PANTALLA"));
    }
}