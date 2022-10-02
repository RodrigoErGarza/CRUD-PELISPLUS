/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelisplus;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import datos.Peliculas;
import dominio.AccesoDatosExtraImpl;
import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;
import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author Walter Garcia
 */
public class PelisPlus {
    
    
    
    
    public static void main(String[] args) {
        Peliculas pelicul= new Peliculas();
        PeliculaAmpliado actu=new PeliculaAmpliado();
        actu.setNip(5);
        actu.setNombre("Rey Leon");
        actu.setGenero("Infantil");
        actu.setYear(1997);
        pelicul.actua(actu);
       
        
        List<PeliculaAmpliado> todpelis=pelicul.select();
        for(PeliculaAmpliado pelicula: todpelis){
            System.out.println("Pelicula: "+pelicula);
        }
        
        
        
        
    }

    
    
    
}
