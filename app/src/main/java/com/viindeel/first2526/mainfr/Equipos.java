package com.viindeel.first2526.mainfr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.viindeel.first2526.R;

public class Equipos extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vistaEquipos = inflater.inflate(R.layout.fragment_equipos, container, false); // Convierte el XML en una vista


        CardView card1 = vistaEquipos.findViewById(R.id.tarjeta1).findViewById(R.id.tarjeta);
        CardView card2 = vistaEquipos.findViewById(R.id.tarjeta2).findViewById(R.id.tarjeta);
        CardView card3 = vistaEquipos.findViewById(R.id.tarjeta3).findViewById(R.id.tarjeta);
        CardView card4 = vistaEquipos.findViewById(R.id.tarjeta4).findViewById(R.id.tarjeta);

        if (card1 != null) {
            ((ImageView) card1.findViewById(R.id.imagenTarjeta)).setImageResource(R.drawable.atlmadrid);
            ((TextView) card1.findViewById(R.id.textoTarjeta)).setText("Introduce su nombre");
            card1.setOnClickListener(v -> mostrarDialogoDeAlerta(card1));
        }
        if (card2 != null) {
            ((ImageView) card2.findViewById(R.id.imagenTarjeta)).setImageResource(R.drawable.liverpool);
            ((TextView) card2.findViewById(R.id.textoTarjeta)).setText("Introduce su nombre");
            card2.setOnClickListener(v -> mostrarDialogoDeAlerta(card2));
        }
        if (card3 != null) {
            ((ImageView) card3.findViewById(R.id.imagenTarjeta)).setImageResource(R.drawable.olimpiquemarsella);
            ((TextView) card3.findViewById(R.id.textoTarjeta)).setText("Introduce su nombre");
            card3.setOnClickListener(v -> mostrarDialogoDeAlerta(card3));
        }
        if (card4 != null) {
            ((ImageView) card4.findViewById(R.id.imagenTarjeta)).setImageResource(R.drawable.tottenham);
            ((TextView) card4.findViewById(R.id.textoTarjeta)).setText("Introduce su nombre");
            card4.setOnClickListener(v -> mostrarDialogoDeAlerta(card4));
        }

        return vistaEquipos;
    }

    public void mostrarDialogoDeAlerta(CardView cardView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog_custom, null);
        builder.setView(dialogView);

        TextInputEditText input = dialogView.findViewById(R.id.nuevos_nombres);
        TextView cardTextView = cardView.findViewById(R.id.textoTarjeta);

        builder.setTitle("Cambiar Nombre del Equipo")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    String newName = input.getText().toString();
                    if (!newName.isEmpty()) {
                        cardTextView.setText(newName);
                        Toast.makeText(getContext(), "Nombre actualizado", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
