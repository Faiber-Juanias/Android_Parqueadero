package com.example.fhjua.parqueadero;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCapacidad extends Fragment {

    private TextView viewMaxAutos;
    private TextView viewMaxMotos;
    private Button btnConfigura;

    public FragmentCapacidad() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragmetnCapacidad = inflater.inflate(R.layout.fragment_fragment_capacidad, container, false);

        viewMaxAutos = (TextView) viewFragmetnCapacidad.findViewById(R.id.view_max_autos);
        viewMaxMotos = (TextView) viewFragmetnCapacidad.findViewById(R.id.view_max_motos);
        btnConfigura = (Button) viewFragmetnCapacidad.findViewById(R.id.btn_configura);

        return viewFragmetnCapacidad;
    }

}
