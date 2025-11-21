package com.mcas2.first2526;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mcas2.first2526.ui.frmanager.Paginador;

public class MainActivity extends AppCompatActivity {

    Button mainButton;

    Button btnIrApeces;
    Button btnIrCalculadora;
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

        mainButton = findViewById(R.id.mainButton);
        mainTV = findViewById(R.id.mainTV);
        btnIrCalculadora = findViewById(R.id.btnIrCalculadora);
        btnIrApeces = findViewById(R.id.btnPeces);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String saludoInicial = "¡Bienvenido/a!";
        String loginUserNameTIL = bundle.getString("userName");
        saludoInicial = "¡Bienvenido/a, " + String.valueOf(loginUserNameTIL);
        Toast.makeText(this, saludoInicial, Toast.LENGTH_SHORT).show();
        if (bundle != null) {
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

        if (btnIrApeces != null) {
            btnIrApeces.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, Paginador.class);
                    startActivity(i);
                }
            });
        }


        if (btnIrCalculadora != null) {
            btnIrCalculadora.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, Calculator.class);
                    startActivity(i);
                }
            });
        }
    }
}