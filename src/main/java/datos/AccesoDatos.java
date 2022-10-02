/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;
import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.*;
import java.util.List;

/**
 *
 * @author Walter Garcia
 */
public interface AccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<Pelicula> listar  (String nombreArchivo) throws LecturaDatosEx;
    void escribir(PeliculaAmpliado pelicula,String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    public void crear (String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo)throws AccesoDatosEx;
}
