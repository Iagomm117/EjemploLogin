package ejemplologin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDB {
    private final Connection connect;

    public GestorDB(String nombreDB) {
        Connection conn;
        
        try{
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/"+nombreDB+"","usuario","abc123."); 
        }
        catch(SQLException e){
            conn = null;
            System.out.println(e.getMessage());
        }
        connect = conn;
    }
    
    public synchronized USUARIO buscarUsuario(String valor, String criterio) throws SQLException {
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM USUARIO WHERE " + criterio + " = '" + valor +"'");
        while(rs.next()){
            if(rs.getString(criterio).equals(valor)){
                USUARIO resultado = new USUARIO(rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("password"),rs.getBoolean("tipo"));
                st.close();
                return resultado;
            }
        }
        st.close();
        return null;
    }
    
    /*
    public synchronized String guardarUsuario(USUARIO newUser) throws SQLException{
        Statement st = connect.createStatement();
    }
    
    */
}

