package com.example.fhjua.parqueadero;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AdministraArchivo {

    private Context objContext;

    private int autosDisponibles;
    private int autosActuales;
    private int motosDisponibles;
    private int motosActuales;

    private int capacidadAutos;
    private int capacidadMotos;

    public AdministraArchivo(Context objContext){
        this.objContext = objContext;
    }


    //-----------------Muestra la fecha y hora actual-----------------

    public String getFechaHora(){
        String fechaHora;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);

        Calendar objCalendar = Calendar.getInstance();
        int h = objCalendar.get(Calendar.HOUR_OF_DAY);
        int m = objCalendar.get(Calendar.MINUTE);

        String horas = String.valueOf(h);
        String minutos = String.valueOf(m);

        String horaMinuto = "" + horas + ":" + minutos;
        return fechaHora = "" + fecha + " " + horaMinuto;
    }



    //-----------------Muestra la actualidad de autos y de motos-----------------

    /*
    * 1 para listar los autos
    * 2 para listar las motos
    */
    public int getAutosActuales(){
        this.autosActuales = this.cantidadAutosMotos(1);
        return this.autosActuales;
    }

    public int getMotosActuales(){
        this.motosActuales = this.cantidadAutosMotos(2);
        return this.motosActuales;
    }



    //-----------------Muestra y actualiza la disponibilidad de autos y de motos-----------------

    public int getAutosDisponibles() {
        try{
            //Obtengo todos los archivos
            String[] archivo = objContext.fileList();
            for (int i = 0; i < archivo.length; i++) {
                if (archivo[i].equalsIgnoreCase("autosDisponibles")) {
                    //Abre el archivo
                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    //Leemos el archivo
                    BufferedReader objBuffered = new BufferedReader(objAbreArchivo);
                    //Almacenamos el valor del archivo
                    this.autosDisponibles = Integer.parseInt(objBuffered.readLine());
                }
            }
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.autosDisponibles;
    }

    public void setAutosDisponibles(int autosDisponibles) {
        try{
            //Obtenemos la capacidad de autos
            int capacidadAutos = this.getCapacidadAutos();

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
        try{
            //Obtengo todos los archivos
            String[] archivo = objContext.fileList();
            for (int i = 0; i < archivo.length; i++) {
                if (archivo[i].equalsIgnoreCase("motosDisponibles")) {
                    //Abre el archivo
                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    //Leemos el archivo
                    BufferedReader objBuffered = new BufferedReader(objAbreArchivo);
                    //Almacenamos el valor del archivo
                    this.motosDisponibles = Integer.parseInt(objBuffered.readLine());
                }
            }
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.motosDisponibles;
    }

    public void setMotosDisponibles(int motosDisponibles) {
        try{
            String dato = String.valueOf(motosDisponibles);
            //Creamos un archivo para guardar la capacidad de autos
            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("motosDisponibles", Activity.MODE_PRIVATE));
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



    //-----------------Muestra y configura la capacidad de autos y motos-----------------

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



    //-----------------Crea entradas y salidas-----------------

    public boolean creaEntradaSalida(String selectSpinner, int selectRadio){
        //Validamos el RadioButton presionado
        switch (selectRadio) {
            //Si es una entrada
            case R.id.radio_entrada:
                try {
                    int contadorArchivoEntradas = 1;
                    //Creamos un ArrayList para almacenar el orden de los archivos
                    ArrayList<String> arrayOrdenArchivo = new ArrayList<>();
                    //Traemos todos los archivos de la aplicacion
                    String[] archivo = objContext.fileList();
                    //Si archivos en la posicion 0 no esta vacio
                    if (archivo!=null) {
                        for (int i = 0; i < archivo.length; i++) {
                            if (archivo[i].equalsIgnoreCase("instant-run")) {
                                continue;
                            }

                            InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                            BufferedReader objBuffered = new BufferedReader(objAbreArchivo);

                            String fechaHora = objBuffered.readLine();
                            String entrada = objBuffered.readLine();
                            String ordenArchivo = objBuffered.readLine();
                            String vehiculo = objBuffered.readLine();

                            //Verificamos el orden de los archivos
                            if (entrada.equals("1")) {
                                arrayOrdenArchivo.add(ordenArchivo);
                            }
                        }
                    }

                    //recorremos el array para almacenar el numero de posiciones en contadorArchivoEntradas
                    for (int i = 0; i < arrayOrdenArchivo.size(); i++) {
                        contadorArchivoEntradas++;
                    }

                    //Creamos un archivo
                    OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("" + contadorArchivoEntradas + "1", Activity.MODE_PRIVATE));
                    //Escribimos la fecha y la hora
                    objCreaArchivo.write("" + getFechaHora() + "\n");
                    //Escribimos que es una entrada
                    objCreaArchivo.write("1" + "\n");
                    //Escribimos el orden ascendente del archivo
                    objCreaArchivo.write("" + contadorArchivoEntradas + "\n");
                    //Escribimos si es una moto o un carro
                    objCreaArchivo.write("" + selectSpinner);
                    //Limpiamos el archivo
                    objCreaArchivo.flush();
                    //Cerramos el archivo
                    objCreaArchivo.close();

                    return true;
                } catch (IOException e) {
                    Toast.makeText(objContext, "Error al grabar el archivo.", Toast.LENGTH_SHORT).show();
                }
                break;
            //Si es una salida
            case R.id.radio_salida:
                try {
                    int contadorArchivoSalidas = 1;
                    //Creamos un ArrayList para almacenar el orden de los archivos
                    ArrayList<String> arrayOrdenArchivo = new ArrayList<>();
                    //Traemos todos los archivos de la aplicacion)
                    String[] archivo = objContext.fileList();
                    //Si archivos en la posicion 0 no esta vacio
                    if (archivo!=null) {
                        for (int i = 0; i < archivo.length; i++) {
                            if (archivo[i].equalsIgnoreCase("instant-run")) {
                                continue;
                            }

                            InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                            BufferedReader objBuffered = new BufferedReader(objAbreArchivo);

                            String fechaHora = objBuffered.readLine();
                            String salida = objBuffered.readLine();
                            String ordenArchivo = objBuffered.readLine();
                            String vehiculo = objBuffered.readLine();

                            //Verificamos el orden de los archivos
                            if (salida.equals("2")) {
                                arrayOrdenArchivo.add(ordenArchivo);
                            }
                        }
                    }

                    //recorremos el array para almacenar el numero de posiciones en contadorArchivoSalidas
                    for (int i = 0; i < arrayOrdenArchivo.size(); i++) {
                        contadorArchivoSalidas++;
                    }

                    //Creamos un archivo
                    //String nombreArchivo = "" + contadorArchivo + "1";
                    OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("" + contadorArchivoSalidas + "2", Activity.MODE_PRIVATE));
                    //Escribimos la fecha y la hora
                    objCreaArchivo.write("" + getFechaHora() + "\n");
                    //Escribimos que es una salida
                    objCreaArchivo.write("2" + "\n");
                    //Escribimos el orden ascendente del archivo
                    objCreaArchivo.write("" + contadorArchivoSalidas + "\n");
                    //Escribimos si es una moto o un carro
                    objCreaArchivo.write("" + selectSpinner);
                    //Limpiamos el archivo
                    objCreaArchivo.flush();
                    //Cerramos el archivo
                    objCreaArchivo.close();

                    //Volvemos los campos a la normalidad
                    return true;
                } catch (IOException e) {
                    Toast.makeText(objContext, "Error al grabar el archivo.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return false;
    }

    //Muestra la cantidad actual de autos y de motos
    public int cantidadAutosMotos(int param){
        int  contador = 0;
        try{
            String[] archivo = objContext.fileList();
            if (param == 1){ //Si se listan los autos actuales
                //Si archivo esta completamente vacio
                if (archivo.length != 0){

                }else {
                    return contador;
                }
                //Archivos que no son entradas ni salidas
                int noArchivos = 0;
                for (int i=0; i<archivo.length; i++){
                    String nombreArchivo = archivo[i];
                    if (nombreArchivo.length() > 4){
                        noArchivos++;
                    }
                }
                for (int i = 0; i < archivo.length; i++) {
                    if (archivo[i].equalsIgnoreCase("instant-run")) {
                        continue;
                    }else if (archivo[i].equalsIgnoreCase("capacidadAutos")) {
                        continue;
                    }else if (archivo[i].equalsIgnoreCase("capacidadMotos")) {
                        continue;
                    }

                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    BufferedReader objBuffered = new BufferedReader(objAbreArchivo);

                    String fechaHora = objBuffered.readLine();
                    String salidaEntrada = objBuffered.readLine();
                    String ordenArchivo = objBuffered.readLine();
                    String vehiculo = objBuffered.readLine();

                    if (vehiculo.equals("carro")){
                        contador++;
                    }
                }
                return contador;
            }else if (param == 2){ //Si se listan las motos actuales
                for (int i = 0; i < archivo.length; i++) {
                    if (archivo[i].equalsIgnoreCase("instant-run")) {
                        continue;
                    }

                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    BufferedReader objBuffered = new BufferedReader(objAbreArchivo);

                    String fechaHora = objBuffered.readLine();
                    String salidaEntrada = objBuffered.readLine();
                    String ordenArchivo = objBuffered.readLine();
                    String vehiculo = objBuffered.readLine();

                    //Verificamos el orden de los archivos
                    if (vehiculo.equals("moto")) {
                        contador++;
                    }
                }
                return contador;
            }
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return contador;
    }
}
