package com.example.fhjua.parqueadero;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Principal extends AppCompatActivity implements
        FragmentRegistro.OnFragmentInteractionListener,
        FragmentCapacidad.OnFragmentInteractionListener,
        FragmentInforme.OnFragmentInteractionListener, ComunicaDialogo {

    //Almaceno todos los id de los botones
    private int[] botones = new int[]{R.id.btn_registro, R.id.btn_capacidad, R.id.btn_informe};
    //Almaceno todas las instancias de los fragmentos
    Fragment[] objFragments = new Fragment[3];
    private ImageView imgPrincipal;
    private ImageButton objBotones;
    private ImageButton btnSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Creo cada una de las referencias
        imgPrincipal = (ImageView) findViewById(R.id.img_principal);
        btnSalida = (ImageButton) findViewById(R.id.btn_salida);

        //Almaceno cada una de las instancias de cada fragmento
        objFragments[0] = new FragmentRegistro();
        objFragments[1] = new FragmentCapacidad();
        objFragments[2] = new FragmentInforme();

        //Creo un bucle que crea la referencia y eventos de cada uno de los botones
        for (int i=0; i<botones.length; i++){
            objBotones = (ImageButton) findViewById(botones[i]);
            final int n = i;
            objBotones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Ocultamos la imagen de Activity principal
                    imgPrincipal.setVisibility(View.GONE);

                    FragmentManager objManager = getFragmentManager();
                    FragmentTransaction objTransaction = objManager.beginTransaction();
                    objTransaction.replace(R.id.content_fragment, objFragments[n]);
                    objTransaction.commit();
                }
            });
        }

        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviaInfo(int id) {
        //Creamos la transaccion
        FragmentTransaction objTransaction = getFragmentManager().beginTransaction();
        //Creamos la instancia de DialogoCapacidad
        DialogoCapacidad objDialogo = new DialogoCapacidad();
        //Creamos un Bundle para pasar el id a DialogoCapacidad
        Bundle args = new Bundle();
        args.putInt("id", id);
        //Asignamos el Bundle a DialogoCapacidad
        objDialogo.setArguments(args);
        //Mostramos a DialogoCapacidad
        objDialogo.show(objTransaction, "DialogoCapacidad");
    }

    @Override
    public void recibeInfo(int capacidad, int id) {
        //Creamos la transaccion
        FragmentTransaction objTransaction = getFragmentManager().beginTransaction();
        //Creamos la instancia de FragmentCapacidad

        FragmentCapacidad objCapacidad = new FragmentCapacidad();
        //Creamos un Bundle para pasar el texto y el id a FragmentCapacidad
        Bundle args = new Bundle();
        args.putInt("capacidad", capacidad);
        args.putInt("id", id);
        //Asignamos el Bundle a FragmentCapacidad
        objCapacidad.setArguments(args);

        //Mostramos a FragmentCapacidad en el contenedor conten_fragment
        objTransaction.replace(R.id.content_fragment, objCapacidad);
        //Guardamos los cambios
        objTransaction.commit();
    }
}
