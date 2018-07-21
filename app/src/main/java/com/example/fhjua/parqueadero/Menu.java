package com.example.fhjua.parqueadero;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    //Creamos un array para almacenar los id de cada boton
    private final int[] IDBOTONES = {R.id.btn_registro, R.id.btn_capacidad, R.id.btn_informe, R.id.btn_salida};

    private int idBoton=-1;

    public Menu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Almacenamos la vista a cargar en un objeto de tipo View
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        if (getArguments() != null) {
            //Almacenamos los argumentos enviados desde Activity principal
            idBoton = getArguments().getInt("BTNSELECT");
        }

        //Declaramos un objeto de tipo ImageButton
        ImageButton objButton;
        //Creamos un bucle para definir los eventos de cada boton
        for (int i=0; i<IDBOTONES.length; i++){
            //Hacemos un casting para cada uno de los botones almacenados en el array
            objButton = (ImageButton) miMenu.findViewById(IDBOTONES[i]);

            if (idBoton==i){
                objButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }

            //Almacenamos i en una variable estatica
            final int boton = i;
            //Ponemos en escucha a cada uno de los botones
            objButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Traemos la clase en la cual nos encontramos
                    Activity objEstaActividad = getActivity();
                    //Hacemos un casting para llamar al metodo de la interfaz ComunicaMunu y pasarle los parámetros correspondientes
                    ((ComunicaMenu)objEstaActividad).menu(boton);
                }
            });
        }

        //Retornamos el objeto de tipo View
        return miMenu;
    }

}