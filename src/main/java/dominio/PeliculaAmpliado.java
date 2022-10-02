/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Walter Garcia
 */
public class PeliculaAmpliado {
    private int Nip;
    private String Nombre;
    private String Genero;
    private int Year;

    @Override
    public String toString() {
        return "PeliculaAmpliado{" + "Nip=" + Nip + ", Nombre=" + Nombre + ", Genero=" + Genero + ", Year=" + Year + '}';
    }
    

    /**
     * @return the Nip
     */
    public int getNip() {
        return Nip;
    }

    /**
     * @param Nip the Nip to set
     */
    public void setNip(int Nip) {
        this.Nip = Nip;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Genero
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * @param Genero the Genero to set
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * @return the Year
     */
    public int getYear() {
        return Year;
    }

    /**
     * @param Year the Year to set
     */
    public void setYear(int Year) {
        this.Year = Year;
    }
    
    
    
    
}
