package com.example.fhjua.parqueadero;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInforme extends Fragment {

    private Button btnEntradas, btnSalidas;
    private ListView listaInforme;
    private ArrayList<Datos> lista;

    public FragmentInforme() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragmentInforme = inflater.inflate(R.layout.fragment_fragment_informe, container, false);

        btnEntradas = (Button) viewFragmentInforme.findViewById(R.id.btn_entradas);
        btnSalidas = (Button) viewFragmentInforme.findViewById(R.id.btn_salidas);
        listaInforme = (ListView) viewFragmentInforme.findViewById(R.id.lista_informe);

        lista = new ArrayList<Datos>();
        lista.add(new Datos(1,"Animal", "Aguila", R.drawable.estacionamiento));

        AdapterListView objMiAdapter = new AdapterListView(getContext(), lista);
        listaInforme.setAdapter(objMiAdapter);

        return viewFragmentInforme;
    }

}
