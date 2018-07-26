package com.example.fhjua.parqueadero;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class DialogoCapacidad extends DialogFragment implements ComunicaDialogo{

    private String n;
    private int id;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Creamos un AlertDialog
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(getActivity());
        //Inflamos la vista con el recurso XML y lo almacenamos en una vista
        View objView = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment_capacidad, null);

        //Creamos las referencias
        final EditText campoCapacidad = (EditText) objView.findViewById(R.id.campoCapacidad);

        //Asignamos la vista al AlertDialog
        objBuilder.setView(objView);
        //Asignamos un titulo
        objBuilder.setTitle("Capacidad");
        //Creamos el evento para le boton positivo
        objBuilder.setPositiveButton("Aceptar", null);

        //Creamos el cuadro de dialogo
        final AlertDialog objAlert = objBuilder.create();

        objAlert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                //Asignamos este evento al boton positivo
                Button btnPositivo = objAlert.getButton(DialogInterface.BUTTON_POSITIVE);

                //Modificamos el layout del dialogo
                LinearLayout.LayoutParams objLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                objLayout.gravity = Gravity.CENTER;

                //Asignamos las modificaciones del layout al boton
                btnPositivo.setLayoutParams(objLayout);

                //Definimos el evento del boton
                btnPositivo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String campo = campoCapacidad.getText().toString();
                        ((ComunicaDialogo)getActivity()).enviaInfo(campo, id);
                    }
                });
            }
        });

        return objAlert;
    }

    @Override
    public void enviaInfo(String texto, int id) {
        this.n = texto;
        this.id = id;
    }
}
