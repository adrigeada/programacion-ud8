package org.example.demo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public static void main(String[] args) {

        Connection bd = conexion();
        System.out.println("Realizando consultas...");
//        insertar(bd);
//        consulta(bd);
//        modificar(bd);
//        borrar(bd);
//        consulta(bd);
        consulta_a_lista(bd);

        desconectar(bd);

    }

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3310/";
        String user = "root";
        String psw = "";
        String bd = "instituto";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion){

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void consulta(Connection conexion){
        String query = "SELECT * FROM estudiante";

        Statement stmt;
        ResultSet respuesta;

        try{

            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while(respuesta.next()){
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");
                System.out.println("NIA: "+nia+" - Nombre: "+nombre+" - Fecha nacimiento: "+fecha_nacimiento);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw  new RuntimeException();
        }



    }

    public static void insertar(Connection conexion){
        String query = "INSERT INTO ESTUDIANTE (nia,nombre,fecha_nacimiento) VALUES (123456789,'Juanito','1998-05-02')";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public static void modificar(Connection conexion){
        System.out.println("Modificando...");

        String query = "UPDATE ESTUDIANTE set nombre = 'Patri' where nombre = 'Patricia'";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public static void borrar(Connection conexion){

        System.out.println("Borrando...");

        String query = "DELETE FROM estudiante WHERE nombre = 'Juanito'";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void consulta_a_lista(Connection conexion){
        listaEstudiantes.clear();

        String query = "SELECT * FROM estudiante";

        Statement stmt;
        ResultSet respuesta;

        try{

            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while(respuesta.next()){
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");
//                listaEstudiantes.add(new Estudiante(nia,nombre,fecha_nacimiento));
            }

            System.out.println(listaEstudiantes);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw  new RuntimeException();
        }



    }

}