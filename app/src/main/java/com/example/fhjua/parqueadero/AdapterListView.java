package com.example.fhjua.parqueadero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterListView extends BaseAdapter{

    Context objContext;
    List<Datos> objListaObjetos;

    public AdapterListView(Context objContext, List<Datos> objListaObjetos) {
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
        return objListaObjetos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater objInflater = LayoutInflater.from(objContext);
        vista = objInflater.inflate(R.layout.item_list_view, null);
        ImageView objImagen = (ImageView) vista.findViewById(R.id.img_list_view);
        TextView objViewFecha = (TextView) vista.findViewById(R.id.view_fecha);
        TextView objViewNIngreso = (TextView) vista.findViewById(R.id.view_n_ingreso);

        objViewFecha.setText(objListaObjetos.get(position).getTitulo().toString());
        objViewNIngreso.setText(objListaObjetos.get(position).getDetalle().toString());
        objImagen.setImageResource(objListaObjetos.get(position).getImagen());

        return vista;
    }
}
