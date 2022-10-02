/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.PeliculaAmpliado;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author alumno
 */
public class Peliculas {
    private static final String select="SELECT * FROM peliculas";
    private static final String insert="INSERT INTO peliculas(Nombre,Genero,Año) values (?,?,?);";
    private static final String update="UPDATE peliculas set Nombre=?, Genero=?, Año=? where NIP=?;";
    private static final String delete="DELETE FROM peliculas where NIP=?;";
    
    
    public List<PeliculaAmpliado> select(){
        Connection con=null;
        PreparedStatement stam=null;
        ResultSet resul=null;
        PeliculaAmpliado pelicula=null;
        List<PeliculaAmpliado> peliculas=new ArrayList<PeliculaAmpliado>();
        
        
        try{
            con=conexion.getConnection();
            stam=con.prepareStatement(select);
            resul=stam.executeQuery();
            
            while(resul.next()){
                int Nip=resul.getInt("Nip");
                String Nombre=resul.getString("Nombre");
                String Genero=resul.getString("Genero");
                int Year=resul.getInt("Año");
                
                pelicula= new PeliculaAmpliado();
                pelicula.setNip(Nip);
                pelicula.setNombre(Nombre);
                pelicula.setGenero(Genero);
                pelicula.setYear(Year);
                peliculas.add(pelicula);
                
            }
        }catch(SQLException e){
            System.out.println("Error en: "+e.getMessage());
        }
        finally{
            conexion.close(resul);
            conexion.close(stam);
            conexion.close(con); 
        }
        return peliculas;
    }
    
    
    
    public int actua(PeliculaAmpliado pelicula){
        Connection con=null;
        PreparedStatement stam=null;
        int rows=0;
        
        try{
            con=conexion.getConnection();
            stam=con.prepareStatement(update);
            stam.setString(1,pelicula.getNombre());
            stam.setString(2, pelicula.getGenero());
            stam.setInt(3,pelicula.getYear());;
            stam.setInt(4, pelicula.getNip());
            rows=stam.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Error al actualizar en: "+e.getMessage());
        }
        finally{
            conexion.close(stam);
            conexion.close(con);
        }
        return rows;
    }
    
    
    public int delete(PeliculaAmpliado pelicula){
        Connection con=null;
        PreparedStatement stam=null;
        int rows=0;
        
        try{
            con=conexion.getConnection();
            stam=con.prepareStatement(delete);
            stam.setString(1, pelicula.getNombre());
            stam.setString(2, pelicula.getGenero());
            stam.setInt(3, pelicula.getYear());
            stam.setInt(4,pelicula.getNip());
            rows=stam.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al borrar en: "+e.getMessage());
        }
        finally{
            conexion.close(con);
            conexion.close(stam);
        }
        return rows;
    }
    
    
}
