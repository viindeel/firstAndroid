package com.viindeel.first2526.ui.frmanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.viindeel.first2526.R;

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        Paginador sectionsPagerAdapter = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        // Establecer los títulos de las pestañas
        tabs.getTabAt(0).setText("Equipos");
        tabs.getTabAt(1).setText("Selecciones");

        TextView welcomeUser = findViewById(R.id.tv_welcome_user);
        String userName = getIntent().getStringExtra("userName");
        if (userName != null && !userName.isEmpty()) {
            welcomeUser.setText("¡¿Adivinarás todos?!");
        }
    }
}
