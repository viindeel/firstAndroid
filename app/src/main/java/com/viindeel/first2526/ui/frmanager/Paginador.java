package com.viindeel.first2526.ui.frmanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.viindeel.first2526.mainfr.Equipos; // Cambiado de Arrecifes a Equipos
import com.viindeel.first2526.mainfr.Selecciones; // Cambiado de Peces a Selecciones

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Equipos();
            case 1:
                return new Selecciones();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}