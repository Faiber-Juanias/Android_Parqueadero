package com.example.fhjua.parqueadero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public void menu(int boton) {
        Intent objIntent = new Intent(Principal.this, ActivityFragments.class);
        objIntent.putExtra("boton", boton);
        startActivity(objIntent);
    }
}
