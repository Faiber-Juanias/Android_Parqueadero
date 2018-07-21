package com.example.fhjua.parqueadero;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRegistro extends Fragment {

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

        objViewAutos = (TextView) viewFragmentRegistro.findViewById(R.id.view_autos_dis);
        objViewMotos = (TextView) viewFragmentRegistro.findViewById(R.id.view_motos_dis);
        objSpinner = (Spinner) viewFragmentRegistro.findViewById(R.id.spinner_registro);
        objGroup = (RadioGroup) viewFragmentRegistro.findViewById(R.id.radio_group_ent_sal);
        objBtnRegistra = (Button) viewFragmentRegistro.findViewById(R.id.btn_registra);

        return viewFragmentRegistro;
    }
}
