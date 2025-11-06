package com.mcas2.first2526;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button mainButton;
    TextView mainTV;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button mainButton = findViewById(R.id.mainButton);
        TextView mainTV = findViewById(R.id.mainTV);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String saludoInicial = "¡Bienvenido/a!";

        // Verificación para que no craashee. Hay datos del Login?
        if (bundle != null) {
            // Usamos la clave correcta desde Login.java
            String userName = bundle.getString("EXTRA_USER");

            if (userName != null && !userName.isEmpty()) {
                saludoInicial = "¡Bienvenido/a de nuevo, " + userName + "!";
            }
        }

        mainTV.setText(saludoInicial);

        contador = 0;

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                mainTV.setText(String.valueOf(contador));
            }
        });
    }
}