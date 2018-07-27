package com.example.fhjua.parqueadero;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConfiguraCapacidad {

    private Context objContext;

    private int autosDisponibles;
    private int motosDisponibles;

    private int capacidadAutos;
    private int capacidadMotos;

    public ConfiguraCapacidad(Context objContext){
        this.objContext = objContext;
    }

    //Muestra y actualiza la disponibilidad de autos y de motos

    public int getAutosDisponibles() {

        return autosDisponibles;
    }

    public void setAutosDisponibles(int autosDisponibles) {
        try{
            String dato = String.valueOf(autosDisponibles);
            //Creamos un archivo para guardar la capacidad de autos
            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("autosDisponibles", Activity.MODE_PRIVATE));
            //Escribimos en el archivo
            objCreaArchivo.write(dato);
            //Limpiamos a objCreaArchivo
            objCreaArchivo.flush();
            //Cerramos a objCreaArchivo
            objCreaArchivo.close();
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public int getMotosDisponibles() {
        return motosDisponibles;
    }

    public void setMotosDisponibles(int motosDisponibles) {
        this.motosDisponibles = motosDisponibles;
    }

    //Muestra y configura la capacidad de autos y motos

    public int getCapacidadAutos() {
        try{
            //Obtengo todos los archivos
            String[] archivo = objContext.fileList();
            for (int i = 0; i < archivo.length; i++) {
                if (archivo[i].equalsIgnoreCase("capacidadAutos")) {
                    //Abre el archivo
                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    //Leemos el archivo
                    BufferedReader objBuffered = new BufferedReader(objAbreArchivo);
                    //Almacenamos el valor del archivo
                    this.capacidadAutos = Integer.parseInt(objBuffered.readLine());
                }
            }
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.capacidadAutos;
    }

    public void setCapacidadAutos(int capacidadAutos) {
        try{
            String dato = String.valueOf(capacidadAutos);
            //Creamos un archivo para guardar la capacidad de autos
            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("capacidadAutos", Activity.MODE_PRIVATE));
            //Escribimos en el archivo
            objCreaArchivo.write(dato);
            //Limpiamos a objCreaArchivo
            objCreaArchivo.flush();
            //Cerramos a objCreaArchivo
            objCreaArchivo.close();
            Toast.makeText(objContext, "Configurado con exito.", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public int getCapacidadMotos() {
        try{
            //Obtengo todos los archivos
            String[] archivo = objContext.fileList();
            for (int i = 0; i < archivo.length; i++) {
                if (archivo[i].equalsIgnoreCase("capacidadMotos")) {
                    //Abre el archivo
                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    //Lee el archivo
                    BufferedReader objBuffered = new BufferedReader(objAbreArchivo);
                    //Almacenamos el valor del archivo
                    this.capacidadMotos = Integer.parseInt(objBuffered.readLine());
                }
            }
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.capacidadMotos;
    }

    public void setCapacidadMotos(int capacidadMotos) {
        try{
            String dato = String.valueOf(capacidadMotos);
            //Creamos un archivo para guardar la capacidad de autos
            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("capacidadMotos", Activity.MODE_PRIVATE));
            //Escribimos en el archivo
            objCreaArchivo.write(dato);
            //Limpia a objCreaArchivo
            objCreaArchivo.flush();
            //Cierra a objCreaArchivo
            objCreaArchivo.close();
            Toast.makeText(objContext, "Configurado con exito.", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
