package com.example.fhjua.parqueadero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter{

    Context objContext;
    ArrayList<Datos> objListaObjetos;

    public AdapterListView(Context objContext, ArrayList<Datos> objListaObjetos) {
        this.objContext = objContext;
        this.objListaObjetos = objListaObjetos;
    }

    @Override
    public int getCount() {
        return objListaObjetos.size(); //Retorna la cantidad de elementos de la lista
    }

    @Override
    public Object getItem(int position) {
        return objListaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Datos objDatos = (Datos) getItem(position);

        //Inflo la vista
        View vista = convertView;
        LayoutInflater objInflater = LayoutInflater.from(objContext);
        vista = objInflater.inflate(R.layout.item_list_view, null);

        //Creo cada referencia
        ImageView objImagen = (ImageView) vista.findViewById(R.id.img_list_view);
        TextView objViewFecha = (TextView) vista.findViewById(R.id.view_fecha);
        TextView objViewNIngreso = (TextView) vista.findViewById(R.id.view_n_ingreso);

        //Asigno los datos a los componentes
        objImagen.setImageResource(objDatos.getImagen());
        objViewFecha.setText(objDatos.getFechaHora());
        objViewNIngreso.setText(objDatos.getNumeroIngreso());

        return vista;
    }
}
