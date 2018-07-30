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

    private int autosDisponibles = 0;
    private int autosActuales = 0;
    private int motosDisponibles = 0;
    private int motosActuales = 0;

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
        /*
        this.autosActuales = this.cantidadAutosMotos(1);
        return this.autosActuales;*/

        try {
            //Obtengo todos los archivos de la aplicacion
            String[] archivo = objContext.fileList();
            //Recorro a archivo
            for (int i=0; i<archivo.length; i++){
                //Si encuentra a autosActuales
                if (archivo[i].equalsIgnoreCase("autosActuales")){
                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    BufferedReader objLeeArchivo = new BufferedReader(objAbreArchivo);

                    this.autosActuales = Integer.parseInt(objLeeArchivo.readLine());

                    objAbreArchivo.close();
                    objLeeArchivo.close();
                }
            }
            return this.autosActuales;
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.autosActuales;
    }

    public void setAutosActuales(int valor){
        try {
            //Creo o sobreescribo el archivo
            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("autosActuales", Activity.MODE_PRIVATE));
            objCreaArchivo.write("" + valor);
            objCreaArchivo.flush();
            objCreaArchivo.close();
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public int getMotosActuales(){
        /*
        this.motosActuales = this.cantidadAutosMotos(2);
        return this.motosActuales;*/

        try {
            //Obtengo todos los archivos de la aplicacion
            String[] archivo = objContext.fileList();
            //Recorro a archivo
            for (int i=0; i<archivo.length; i++){
                //Si encuentra a autosActuales
                if (archivo[i].equalsIgnoreCase("motosActuales")){
                    InputStreamReader objAbreArchivo = new InputStreamReader(objContext.openFileInput(archivo[i]));
                    BufferedReader objLeeArchivo = new BufferedReader(objAbreArchivo);

                    this.motosActuales = Integer.parseInt(objLeeArchivo.readLine());

                    objAbreArchivo.close();
                    objLeeArchivo.close();
                }
            }
            return this.motosActuales;
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.motosActuales;
    }

    public void setMotosActuales(int valor){
        try {
            //Creo o sobreescribo el archivo
            OutputStreamWriter objCreaArchivo = new OutputStreamWriter(objContext.openFileOutput("motosActuales", Activity.MODE_PRIVATE));
            objCreaArchivo.write("" + valor);
            objCreaArchivo.flush();
            objCreaArchivo.close();
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //-----------------Muestra la disponibilidad de autos y de motos-----------------

    public int getAutosDisponibles() {
        try{
            //Obtengo la capacidad de autos
            int capacidadAutos = this.getCapacidadAutos();
            //Obtengo los autos actuales
            int autosActuales = this.getAutosActuales();

            //Hago la resta para saber la disponibilidad de autos
            this.autosDisponibles = capacidadAutos - autosActuales;
            return this.autosDisponibles;
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.autosDisponibles;
    }

    public int getMotosDisponibles() {
        try{
            //Obtengo la capacidad de motos
            int capacidadMotos = this.getCapacidadMotos();
            //Obtengo las motos actuales
            int motosActuales = this.getMotosActuales();

            //Hago la resta para saber la disponibilidad de motos
            this.motosDisponibles = capacidadMotos - motosActuales;
            return this.motosDisponibles;
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return this.motosDisponibles;
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

                    objAbreArchivo.close();
                    objBuffered.close();
                }
            }
            return this.capacidadAutos;
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

            //Formateamos el valor de los autos actuales
            this.setAutosActuales(0);

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
            return this.capacidadMotos;
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

            //Formateamos el valor de las motos actuales
            this.setMotosActuales(0);

            Toast.makeText(objContext, "Configurado con exito.", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(objContext, "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    //-----------------Crea entradas y salidas-----------------

    public int creaEntradaSalida(String selectSpinner, int selectRadio) {
        int capaAutos = this.getCapacidadAutos();
        int capaMotos = this.getCapacidadMotos();
        //Validamos la capacidad de autos y de motos
        if (capaAutos != 0 && capaMotos != 0) {
            //Validamos el RadioButton presionado
            switch (selectRadio) {
                //Si es una entrada
                case R.id.radio_entrada:
                    try {
                        int autoDispo = this.getAutosDisponibles();
                        int motoDispo = this.getMotosDisponibles();
                        //Valido cuando la disponibilidad de autos y de motos sea 0
                        if (selectSpinner.equals("carro") && autoDispo != 0 || selectSpinner.equals("moto") && motoDispo != 0) {
                            int contadorArchivoEntradas = 1;
                            //Creamos un ArrayList para almacenar el orden de los archivos
                            ArrayList<String> arrayOrdenArchivo = new ArrayList<>();
                            //Traemos todos los archivos de la aplicacion
                            String[] archivo = objContext.fileList();
                            for (int i = 0; i < archivo.length; i++) {
                                if (archivo[i].equalsIgnoreCase("instant-run")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("capacidadAutos")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("capacidadMotos")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("autosActuales")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("motosActuales")) {
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

                            //Ya que es una entrada guardo el valor en el archivo interno
                            if (selectSpinner.equalsIgnoreCase("carro")) {
                                //Obtengo los autos actuales
                                int autosActuales = this.getAutosActuales();
                                autosActuales = autosActuales + 1;
                                this.setAutosActuales(autosActuales);
                            } else if (selectSpinner.equalsIgnoreCase("moto")) {
                                //Obtengo las motos actuales
                                int motosActuales = this.getMotosActuales();
                                motosActuales = motosActuales + 1;
                                this.setMotosActuales(motosActuales);
                            }

                            return 1;
                        }else {
                            Toast.makeText(objContext, "Disponibilidad de autos/motos superada.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        Toast.makeText(objContext, "Error al grabar el archivo.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                //Si es una salida
                case R.id.radio_salida:
                    try {
                        int autoActual = this.getAutosActuales();
                        int motoActual = this.getMotosActuales();
                        //Valido si los autos y motos actuales son diferentes a 0
                        if (selectSpinner.equals("carro") && autoActual != 0 || selectSpinner.equals("moto") && motoActual != 0) {
                            int contadorArchivoSalidas = 1;
                            //Creamos un ArrayList para almacenar el orden de los archivos
                            ArrayList<String> arrayOrdenArchivo = new ArrayList<>();
                            //Traemos todos los archivos de la aplicacion)
                            String[] archivo = objContext.fileList();
                            for (int i = 0; i < archivo.length; i++) {
                                if (archivo[i].equalsIgnoreCase("instant-run")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("capacidadAutos")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("capacidadMotos")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("autosActuales")) {
                                    continue;
                                } else if (archivo[i].equalsIgnoreCase("motosActuales")) {
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

                            //Ya que es una entrada guardo el valor en el archivo interno
                            if (selectSpinner.equalsIgnoreCase("carro")) {
                                //Obtengo los autos actuales
                                int autosActuales = this.getAutosActuales();
                                autosActuales = autosActuales - 1;
                                this.setAutosActuales(autosActuales);
                            } else if (selectSpinner.equalsIgnoreCase("moto")) {
                                //Obtengo las motos actuales
                                int motosActuales = this.getMotosActuales();
                                motosActuales = motosActuales - 1;
                                this.setMotosActuales(motosActuales);
                            }

                            return 2;
                        }else {
                            Toast.makeText(objContext, "No pueden haber salidas, ya que el valor actual de autos/motos es 0.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        Toast.makeText(objContext, "Error al grabar el archivo.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        } else {
            Toast.makeText(objContext, "Debe configurar la capacidad de autos/motos.", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
}
