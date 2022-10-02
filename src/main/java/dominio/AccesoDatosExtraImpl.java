/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import datos.AccesoDatosImpl;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter Garcia
 */
public class AccesoDatosExtraImpl extends AccesoDatosImpl {
    
    
    public List<PeliculaAmpliado> cargarInformacion(String nombreArchivo) throws LecturaDatosEx {
          List <PeliculaAmpliado> peliFecha = new ArrayList();
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                String nombrePe;
                String Year;
                String[] arreglo = linea.split(";");
                nombrePe = arreglo[0];
                Year = arreglo[1];
                //sugerir cómo validar que no de errores esto
                PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePe, Year);
                peliFecha.add(pelicula);
                linea = entrada.readLine();
            }   
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
        return peliFecha;
    }
    
}
