/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author Walter Garcia
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
        this.datos=new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula,String fecha_produccion, String nombreArchivo) {
       PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePelicula, fecha_produccion);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listaPelicula(String nombreArchivo) {
         try {
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            for(Pelicula pelicula : peliculas){
                System.out.println("Pelicula: "+pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
           
            resultado = datos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar la peli"+ ex.getMessage());
           
        }
         System.out.println("Resultado Busqueda:"+resultado);
    
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    

    
}
