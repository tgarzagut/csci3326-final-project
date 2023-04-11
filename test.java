import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;
// import java.util.Scanner;


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
        int random = (int)(Math.random()*526)+1;  
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            for(int i = 0; i<=random;i++) {
                rs.next();  
                if(i==random){
                System.out.println(rs.getString("animal")); 
                }
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }    
}