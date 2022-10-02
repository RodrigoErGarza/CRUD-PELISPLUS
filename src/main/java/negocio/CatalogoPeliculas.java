/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author Walter Garcia
 */
public interface CatalogoPeliculas {
    public void agregarPelicula(String nombrePelicula, String fecha_produccion, String nombreArchivo);
    public void listaPelicula(String nombreArchivo);
    public void buscarPeliculas(String nombreArchivo, String buscar);
    public void iniciarArchivo(String nombreArchivo);
    
}
