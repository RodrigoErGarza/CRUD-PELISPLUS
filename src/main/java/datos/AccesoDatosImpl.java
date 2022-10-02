/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter Garcia
 */
public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo= new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Pelicula> peliculas= new ArrayList();
        try{
            BufferedReader entrada=null;
            File archivo= new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            linea =entrada.readLine();
            
            while( linea != null){
                Pelicula pelicula=new Pelicula(linea);
                peliculas.add(pelicula);
                linea= entrada.readLine();
            }
            entrada.close();
        }catch (FileNotFoundException ex){
            System.out.println("El archivo no existe");
        }catch(IOException ex){
            
        }
        return peliculas;
        
    }

    @Override
    public void escribir(PeliculaAmpliado pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida= null;
        try{
            File archivo=new File(nombreArchivo);
            salida= new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
        }catch (IOException ex){
            System.out.println("Problema al escribir en el archivo");
        }finally{
            salida.close();
        }
    }

    @Override
    public String buscar(String nombreArchivo,String buscar){
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=0;
            linea = entrada.readLine();
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula: "+ linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }   entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    public void crear(String nombreArchivo){
    PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo=new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
    
    
}
