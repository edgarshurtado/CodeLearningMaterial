package DAO;

import java.sql.Connection;

public class ConexionBD {

    public Connection abrirConexion() throws Exception {

        Connection con = null;

        try {
            //CARREGAR EL DRIVER con Class.forName//
            Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://localhost:3306/carreras";  //hem creat el estil de conexio
            con = java.sql.DriverManager.getConnection(urlOdbc,"root","");
            return con;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());   //fem un nou error de excepcio
        }
    }

    ///TANQUEM LA CONEXION//
    public void cerrarConexion(Connection con) throws Exception {

        try {
            if (con != null) {
                con.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ha sido imposible establecer la conexion" + e.getMessage());
        }

    }
    
 

}
