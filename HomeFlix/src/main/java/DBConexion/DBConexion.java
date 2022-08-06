package DBConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {

    protected Connection conexion;
    private final String DB_URL= "jdbc:mysql://localhost:3306/proto";

    private final String USER = "root";
    private final String PASSWORD = "toor";

    public void conectar() throws SQLException {
        try {
            conexion= DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cerrar() throws SQLException {
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
