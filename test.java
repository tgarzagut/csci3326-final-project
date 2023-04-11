import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class test {
    public static void main(String[] args) throws Exception {
        test app = new test();  
        app.selectAnimals(); 
    }

    public Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:sampleData.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }
    public void selectAnimals(){  
        String sql = "SELECT * FROM animals";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                if(rs.getString("animal").equals("pug")){
                System.out.println(rs.getString("dog")); 
                }
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }    
}