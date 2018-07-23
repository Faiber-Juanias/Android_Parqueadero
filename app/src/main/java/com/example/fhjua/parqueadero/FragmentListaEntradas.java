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
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentListaEntradas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentListaEntradas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentListaEntradas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //
    private ListView objListaEntradas;
    Activity objActivity = null;
    Context objContext = null;

    private OnFragmentInteractionListener mListener;

    public FragmentListaEntradas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentListaEntradas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentListaEntradas newInstance(String param1, String param2) {
        FragmentListaEntradas fragment = new FragmentListaEntradas();
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
        View objVistaListaEntradas = inflater.inflate(R.layout.fragment_fragment_lista_entradas, container, false);

        objListaEntradas = (ListView) objVistaListaEntradas.findViewById(R.id.lista_entradas);

        //obtengo el Contexto
        objActivity = getActivity();
        objContext = objActivity.getApplicationContext();

        String[] valoresLista = new String[]{"faiber","juanias","laura","sofia","daniela"};
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(objContext, android.R.layout.simple_list_item_1, valoresLista);
        objListaEntradas.setAdapter(objAdapter);

        return objVistaListaEntradas;
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
