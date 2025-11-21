package com.mcas2.first2526.mainfr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.mcas2.first2526.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrecifes extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vistaArrecifes  = inflater.inflate(R.layout.fragment_arrecifes, container, false);

        List<ConstraintLayout> tarjetas = new ArrayList<>(Arrays.asList(
                        vistaArrecifes.findViewById(R.id.tarjeta1),
                        vistaArrecifes.findViewById(R.id.tarjeta2),
                        vistaArrecifes.findViewById(R.id.tarjeta3),
                        vistaArrecifes.findViewById(R.id.tarjeta4)
        ));

        for (ConstraintLayout tarjeta : tarjetas) {
            if (tarjeta != null) {
                tarjeta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mostrarDialogoDeAlerta();
                    }
                });
            }
        }
        return vistaArrecifes;
    }

    public void mostrarDialogoDeAlerta(){
        new AlertDialog.Builder(requireContext())
                .setTitle("Primera alerta del mundo")
                .setMessage("este es el mensaje de la alerta")
                .setPositiveButton("Dale", ((dialog, which) -> {
                    Toast.makeText(getContext(), "Clickaste si", Toast.LENGTH_SHORT).show();
                }))
                .setNegativeButton("ATRAS" , ((dialog, which) -> {
                    Toast.makeText(getContext(), "Clickaste no", Toast.LENGTH_SHORT).show();
                }))
                .setIcon(android.R.drawable.ic_dialog_alert)
                //.setView() //aqui se carga un customdrawable de in inputlayout
                .show();
    }
}
