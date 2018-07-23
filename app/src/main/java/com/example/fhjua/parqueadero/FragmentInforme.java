package com.example.fhjua.parqueadero;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInforme extends Fragment {

    private Button btnEntradas, btnSalidas;
    FragmentListaEntradas objListaEntradas = new FragmentListaEntradas();
    FragmentListaSalidas objListaSalidas = new FragmentListaSalidas();


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

        final FragmentManager objManager = getFragmentManager();

        btnEntradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction objTransaction = objManager.beginTransaction();
                objTransaction.replace(R.id.content_fragment_lista, objListaEntradas);
                objTransaction.commit();
            }
        });

        btnSalidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return viewFragmentInforme;
    }

}
