package com.example.fhjua.parqueadero;

import android.content.Context;
import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRegistro extends Fragment {

    public static int capacidadAutos = 0;
    public static int capacidadMotos = 0;

    private TextView objViewAutos;
    private TextView objViewMotos;
    private Spinner objSpinner;
    private RadioGroup objGroup;
    private Button objBtnRegistra;

    public FragmentRegistro() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragmentRegistro = inflater.inflate(R.layout.fragment_fragment_registro, container, false);

        //Creamos las referencias con la interfaz
        objViewAutos = (TextView) viewFragmentRegistro.findViewById(R.id.view_autos_dis);
        objViewMotos = (TextView) viewFragmentRegistro.findViewById(R.id.view_motos_dis);
        objSpinner = (Spinner) viewFragmentRegistro.findViewById(R.id.spinner_registro);
        objGroup = (RadioGroup) viewFragmentRegistro.findViewById(R.id.radio_group_ent_sal);
        objBtnRegistra = (Button) viewFragmentRegistro.findViewById(R.id.btn_registra);

        //Asignamos el texto a los TextView
        objViewAutos.setText("Autos diponibles: " + capacidadAutos);
        objViewMotos.setText("Motos diponibles: " + capacidadMotos);

        //Llenamos el Spinner de la interfaz
        ArrayList<String> objListSpinner = new ArrayList<>();
        objListSpinner.add("Seleccione la clase de vehiculo");
        objListSpinner.add("carro");
        objListSpinner.add("moto");
        //Adaptamos el Spinner
        final ArrayAdapter objAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, objListSpinner);
        objSpinner.setAdapter(objAdapter);

        //Ponemos en escucha el boton de registrar
        objBtnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Almacenamos la seleccion del Spinner
                String selectSpinner = objSpinner.getSelectedItem().toString();
                //Almacenamos la seleccion de RadioButton
                int selectRadio = objGroup.getCheckedRadioButtonId();
                //Validamos el RadioButton presionado
                switch (selectRadio){
                    //Si es una entrada
                    case R.id.radio_entrada:
                        try {
                            Context objContext = new ContextWrapper(getContext());
                            int contador = 1;
                            //Creamos un archivo
                            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput(""+contador+"1", Activity.MODE_PRIVATE));
                            //Escribimos en el archivo
                            objCreaArchivo.write(selectSpinner);
                            //Limpiamos el archivo
                            objCreaArchivo.flush();
                            //Cerramos el archivo
                            objCreaArchivo.close();
                            contador++;
                        }catch (IOException e){

                        }
                        break;
                    //Si es una salida
                    case R.id.radio_salida:
                        try {
                            Context objContext = new ContextWrapper(getContext());
                            int contador = 1;
                            //Creamos un archivo
                            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput(""+contador+"2", Activity.MODE_PRIVATE));
                            //Escribimos en el archivo
                            objCreaArchivo.write(selectSpinner);
                            //Limpiamos el archivo
                            objCreaArchivo.flush();
                            //Cerramos el archivo
                            objCreaArchivo.close();
                            contador++;
                        }catch (IOException e){

                        }
                        break;
                }
            }
        });

        return viewFragmentRegistro;
    }
}
