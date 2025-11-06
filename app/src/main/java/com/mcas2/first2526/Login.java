package com.mcas2.first2526;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginButton = findViewById(R.id.loginButton);
        TextView loginTVRegister = findViewById(R.id.loginTVRegister);
        TextInputLayout loginUserNameTIL = findViewById(R.id.loginTILuserName);
        TextInputLayout loginPasswordTIL = findViewById(R.id.loginTILpassword);
        FormUtils formUtils = new FormUtils();

        // Nombre del archivo de preferencias
        String PREFS_FILE_NAME = "credenciales";

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. OBTENER DATOS (dentro del onClick para frescura)
                SharedPreferences sharedPref = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);

                // Obtenemos el hash guardado (la clave "password" del registro)
                String hashedPassword = sharedPref.getString("password", "");

                // Obtenemos la contraseña plana que el usuario acaba de introducir
                String plainPassword = formUtils.getTILText(loginPasswordTIL);

                Log.d("LOGIN_DEBUG", "Hash guardado: " + hashedPassword);
                Log.d("LOGIN_DEBUG", "Contraseña Plana: " + plainPassword);

                boolean canContinue = true;

                // 2. VALIDACIÓN DE CAMPOS VACÍOS
                if (formUtils.isTILEmpty(loginUserNameTIL)) {
                    loginUserNameTIL.setErrorEnabled(true);
                    loginUserNameTIL.setError("Necesitas acceder con un nombre de usuario.");
                    canContinue = false;
                }

                if (plainPassword.isEmpty()) {
                    loginPasswordTIL.setErrorEnabled(true);
                    loginPasswordTIL.setError("La contraseña está vacía.");
                    canContinue = false;
                }
                // 3. VERIFICACIÓN ANTI-CRASH (Si no hay hash guardado, no hay cuenta)
                else if (hashedPassword.isEmpty()) {
                    loginPasswordTIL.setErrorEnabled(true);
                    loginPasswordTIL.setError("Usuario no encontrado. Por favor, regístrate.");
                    canContinue = false;
                }
                // 4. VERIFICACIÓN BCrypt (Solo si el hash existe y la contraseña no está vacía)
                else if (!formUtils.checkPassword(plainPassword, hashedPassword)) {
                    loginPasswordTIL.setErrorEnabled(true);
                    loginPasswordTIL.setError("La contraseña es incorrecta.");
                    canContinue = false;
                }

                // 5. ACCESO EXITOSO
                if (canContinue) {
                    Intent intentMain = new Intent(Login.this, MainActivity.class);

                    // Recuperar el nombre para el saludo
                    String userName = sharedPref.getString("userName", "Usuario");

                    // Enviar el nombre en el Intent (BUNDLE)
                    intentMain.putExtra("userName", userName);

                    startActivity(intentMain);
                }
            }
        });


        loginTVRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Login.this, Register.class);
                startActivity(intentRegister);
            }
        });

    }
}