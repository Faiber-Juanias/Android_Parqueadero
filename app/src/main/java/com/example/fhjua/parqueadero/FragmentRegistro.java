package com.example.fhjua.parqueadero;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
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
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRegistro.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRegistro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistro extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //---------
    public static int capacidadAutos = 0;
    public static int capacidadMotos = 0;

    private TextView objViewAutos;
    private TextView objViewMotos;
    private Spinner objSpinner;
    private RadioGroup objGroup;
    private Button objBtnRegistra;
    private static int contadorArchivo = 1;

    Activity objActivity = null;
    Context objContext = null;

    private OnFragmentInteractionListener mListener;

    public FragmentRegistro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRegistro.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegistro newInstance(String param1, String param2) {
        FragmentRegistro fragment = new FragmentRegistro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        objActivity = getActivity();
        objContext = objActivity.getApplicationContext();

        //Llenamos el Spinner de la interfaz
        ArrayList<String> objListSpinner = new ArrayList<>();
        objListSpinner.add("Seleccione la clase de vehiculo");
        objListSpinner.add("carro");
        objListSpinner.add("moto");
        //Adaptamos el Spinner
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(objContext, android.R.layout.simple_spinner_dropdown_item, objListSpinner);
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
                            //Creamos un archivo
                            //String nombreArchivo = "" + contadorArchivo + "1";
                            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("11", Activity.MODE_PRIVATE));
                            //Escribimos en el archivo
                            objCreaArchivo.write(selectSpinner);
                            //Limpiamos el archivo
                            objCreaArchivo.flush();
                            //Cerramos el archivo
                            objCreaArchivo.close();

                            contadorArchivo++;

                            Toast.makeText(objContext, "Archivo guardado.", Toast.LENGTH_SHORT).show();

                        }catch (IOException e){
                            Toast.makeText(objContext, "Error al grabar el archivo.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    //Si es una salida
                    case R.id.radio_salida:
                        try {
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
