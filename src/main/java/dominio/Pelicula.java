/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Walter Garcia
 */
public class Pelicula {
    private String nombre;
    
    public Pelicula(String nombre_peli){
        this.nombre=nombre_peli;
    }

    @Override
    public String toString() {
        return this.getNombre();
        //return "PelisPlus{" + "nombre=" + nombre + '}';
    }

    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
