/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;


/**
 *
 * @author alumno
 */
public class conexion {
    private static final String url="jdbc:mysql://localhost:3306/pelisplus?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String user="root";
    private static final String contra="Umg$2019";
    
    
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url, user, contra);
    }
    
    public static void close(ResultSet resul){
        try{
            resul.close();
        }catch(SQLException e){
            System.out.println("Error en: "+e.getMessage());
        }
    }
    public static void close(PreparedStatement stam){
        try{
            stam.close();
        }catch(SQLException e){
            System.out.println("Error en: "+e.getMessage());
        }
    }
    
    
    public static void close(Connection con){
        try{
            con.close();
        }catch(SQLException e){
            System.out.println("Error en: "+e.getMessage());
        }
    }
    
}
