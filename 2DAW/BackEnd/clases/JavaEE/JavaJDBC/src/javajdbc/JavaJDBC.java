/*
    Exercise description
*/

package javajdbc;

import com.mysql.jdbc.Connection;
import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Edgar S. Hurtado
 */


public class JavaJDBC {

    
    public static void main(String[] args) {
       
	    try {
		    Connection conn = getConnection();
		    String sql = "INSERT INTO participantes(Dorsal, Nombre, Apellidos, Poblacion, CLUB) "
			    + "VALUES(?,?,?,?,?)";

		    PreparedStatement preStat = conn.prepareStatement(sql);
		    preStat.setInt(1, 999999999);
		    preStat.setString(2, "Pep-Ed");
		    preStat.setString(3, "Garcia Garcia");
		    preStat.setString(4, "Xeraco");
		    preStat.setString(5, "Club Xeraco");
		    preStat.executeUpdate();

		    conn.close();
	    } catch (Exception e) {
		    e.printStackTrace();
	    }
    }

    static private Connection getConnection(){
	    try {
		    String url="jdbc:mysql://localhost:3306/carreras";
		    String user = "root";
		    String pass = "";
		    String driver = "com.mysql.jdbc.Driver";
		    Class.forName(driver);
		    Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
		    return conn;
	    } catch (Exception ex) {
		    ex.printStackTrace();
		    return null;
	    }
 
    }

}
