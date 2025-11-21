package com.mcas2.first2526.mainfr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mcas2.first2526.R;

public class Peces extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vistaPeces = inflater.inflate(R.layout.fragment_peces, container, false);

        // Aquí puedes inicializar las vistas de tu layout, como TextViews, Buttons, etc.
        // Por ejemplo:
        // TextView miTexto = vistaPeces.findViewById(R.id.mi_texto_en_peces);
        // miTexto.setText("Hola desde el fragmento de Peces");

        return vistaPeces;
    }
}
