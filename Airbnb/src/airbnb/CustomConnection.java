
package airbnb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomConnection {
    
    Connection connect;
    
    public Connection getConnect(){
        return this.connect;
    }
    
    public void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(CustomConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
