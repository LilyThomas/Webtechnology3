package list;

import java.util.ArrayList;

import jdbc.JDBCconnection;

public class ListStudents {
	
	public ListStudents(){}
	
	public String[] selectAll(){
		JDBCconnection conn = JDBCconnection.getJDBCconnection();
		conn.openConnection("Students", "root", "MySqlPass");
		ArrayList<String> array = conn.selectAll("SELECT * FROM grades;");
		
		String[] result = new String[array.size()];
		array.toArray(result);
		
		conn.closeConnection();

		return result;
	}
}
