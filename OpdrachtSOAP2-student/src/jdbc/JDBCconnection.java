package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCconnection {
	public static JDBCconnection instance = null;
	public Connection conn = null;
	
	private JDBCconnection(){
		System.out.println("Instantiated");
	}
	
	public static synchronized JDBCconnection getJDBCconnection() {
		if(instance == null) {
            instance = new JDBCconnection();
        }
        return instance;
	}
	
	public void openConnection(String database, String user, String pwd) {        
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/" + database;
		    conn = DriverManager.getConnection (url, user, pwd);
		    System.out.println("Connection opened");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
			System.out.println("Connection closed");
		}
		catch (Exception e) {
		    System.out.println(e);
		}
	}
	
	public void executeInsert(String sql) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
	}
	
	public ArrayList<String> selectAll(String sql) {
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				result.add(rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getInt(4));
			}
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
		return result;
	}
}
