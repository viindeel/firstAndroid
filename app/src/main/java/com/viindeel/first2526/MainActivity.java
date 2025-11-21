package com.viindeel.first2526;

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

import com.viindeel.first2526.ui.frmanager.TabsActivity; // Cambiado de Paginador a TabsActivity

public class MainActivity extends AppCompatActivity {

    Button mainButton;
    Button btnIrANombres;
    Button btnIrCalculadora;
    TextView mainTV;
    int contador;
    String userName;

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
        btnIrANombres = findViewById(R.id.btnNombres);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String saludoInicial = "¡Bienvenido/a!";

        if (bundle != null) {
            userName = bundle.getString("userName");
            if (userName != null && !userName.isEmpty()) {
                saludoInicial = "¡Bienvenido/a, " + userName + "!";
                Toast.makeText(this, saludoInicial, Toast.LENGTH_SHORT).show();
            }
        }
        mainTV.setText(saludoInicial);

        contador = 0;
        mainButton.setOnClickListener(v -> {
            contador++;
            mainTV.setText(String.valueOf(contador));
        });

        if (btnIrANombres != null) {
            btnIrANombres.setOnClickListener(v -> {
                // Apuntamos a TabsActivity para que la app no crashee
                Intent i = new Intent(MainActivity.this, TabsActivity.class);
                i.putExtra("userName", userName);
                Toast.makeText(this, "Intenta adivinar todos", Toast.LENGTH_SHORT).show();
                startActivity(i);
            });
        }

        if (btnIrCalculadora != null) {
            btnIrCalculadora.setOnClickListener(v -> {
                Intent i = new Intent(MainActivity.this, Calculator.class);
                startActivity(i);
            });
        }
    }
}
