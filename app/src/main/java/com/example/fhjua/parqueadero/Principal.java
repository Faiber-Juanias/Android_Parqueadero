package com.example.fhjua.parqueadero;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Principal extends AppCompatActivity implements ComunicaMenu{

    //Creamos un array que contendra todos los fragmentos
    Fragment[] arrayFragment;

    private ImageView imgPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imgPrincipal = (ImageView) findViewById(R.id.img_principal);

        //Instanciamos el array
        arrayFragment = new Fragment[3];
        arrayFragment[0]=new FragmentRegistro();
        arrayFragment[1]=new FragmentCapacidad();
        arrayFragment[2]=new FragmentInforme();
    }

    @Override
    public void menu(int boton) {
        //Llamamos al método getFragmentManager y almacenamos lo que devuelve en un objeto de tipo FragmentManager
        FragmentManager objManejadorFragments = getFragmentManager();
        //Conseguimos o iniciamos la transaccion
        FragmentTransaction objTransaccion = objManejadorFragments.beginTransaction();
        //Ocultamos la imagen del Relative layout en la Activity principal
        imgPrincipal.setVisibility(View.GONE);
        //Reemplazamos el fragment actual

        //Creamos el nuevo menu a reemplazar
        Fragment newMenu = new Menu();
        //Creamos un objeto de tipo menu
        Bundle dato = new Bundle();
        //cargamos el id del boton a pasar
        dato.putInt("BTNSELECT", boton);
        //pasamos el id del boton
        newMenu.setArguments(dato);
        //Reemplazamos el menua actual por newMenu
        objTransaccion.replace(R.id.menu, newMenu);

        objTransaccion.replace(R.id.content_fragment, arrayFragment[boton]);
        //Iniciamos la transaccion
        objTransaccion.commit();
    }
}
