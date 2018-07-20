package com.example.fhjua.parqueadero;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityFragments extends AppCompatActivity implements ComunicaMenu{

    //Creamos un array que contendra todos los fragmentos
    Fragment[] arrayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        //Instanciamos el array
        arrayFragment = new Fragment[3];
        arrayFragment[0]=new FragmentRegistro();
        arrayFragment[1]=new FragmentCapacidad();
        arrayFragment[2]=new FragmentInforme();

        //Obtenemos la información del Bundle al ejecutar el método onCreate
        //Almacenamos en un objeto de tipo Bundle lo que llega como parámetros de la actividad Principal
        Bundle extras = getIntent().getExtras();
        //Pasamos el parámetro al método menu
        menu(extras.getInt("boton"));
    }

    @Override
    public void menu(int boton) {
        //Llamamos al método getFragmentManager y almacenamos lo que devuelve en un objeto de tipo FragmentManager
        FragmentManager objManejadorFragments = getFragmentManager();
        //Conseguimos o iniciamos la transaccion
        FragmentTransaction objTransaccion = objManejadorFragments.beginTransaction();
        //Reemplazamos el fragment actual
        objTransaccion.replace(R.id.content_fragment, arrayFragment[boton]);
        //Iniciamos la transaccion
        objTransaccion.commit();
    }
}
