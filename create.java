import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class create {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Event_management", "postgres", "vasudha27");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sq="Drop table Events";
	         String sql = "CREATE TABLE Events  " +
	            "(E_id varchar(6) PRIMARY KEY," +
	            " Ename varchar(20) NOT NULL, " +
	            "categor_level varchar(6) )";
	         stmt.executeUpdate(sql);
	         String sql1 = "CREATE TABLE Customers  " +
	 	            "(c_id varchar(6) PRIMARY KEY," +
	 	            " cname  varchar(20) NOT NULL, " +
	 	            " DOB date, " +
	 	            " Address varchar(6), " +
	 	            "E_id varchar(6), FOREIGN KEY(E_id) REFERENCES Events(E_id) )";
	         stmt.executeUpdate(sql1);
	         String sql2 = "CREATE TABLE Sub_Events  " +
		 	            "(s_id varchar(6) PRIMARY KEY," +
		 	            " sname varchar(20) NOT NULL, " +
		 	            "E_id varchar(6), FOREIGN KEY(E_id) REFERENCES Events(E_id) )";
	         stmt.executeUpdate(sql2);
	         String sql3 = "CREATE TABLE Venue  " +
		 	            "(v_id varchar(6) PRIMARY KEY," +
		 	            " vname varchar(20) NOT NULL, " +
		 	           " Location varchar(15), " +
		 	            "E_id varchar(6), FOREIGN KEY(E_id) REFERENCES Events(E_id) )";
	         stmt.executeUpdate(sql3);
	         String sql4 = "CREATE TABLE Food  " +
		 	            "(f_id varchar(6) PRIMARY KEY," +
		 	            " fname varchar(20) NOT NULL, " +
		 	           " price int, " +
		 	            "E_id varchar(6), FOREIGN KEY(E_id) REFERENCES Events(E_id) )";
	         stmt.executeUpdate(sql4);
	         String sql5 = "CREATE TABLE Books " +
	 	            "(E_id varchar(6), FOREIGN KEY(E_id) REFERENCES Events(E_id)," +
	 	            "c_id varchar(6), FOREIGN KEY(c_id) REFERENCES Customers(c_id), " +
	 	            "event_cost int, PRIMARY KEY (e_id,c_id) )";
	         stmt.executeUpdate(sql5);
	         String sql6 = "CREATE TABLE Orders " +
		 	            "(c_id varchar(6), FOREIGN KEY(c_id) REFERENCES Customers(c_id)," +
		 	            " E_id varchar(6), FOREIGN KEY(E_id) REFERENCES Events(E_id), " +
		 	           "v_id varchar(6), FOREIGN KEY(v_id) REFERENCES Venue(v_id), " +
		 	          "f_id varchar(6), FOREIGN KEY(f_id) REFERENCES Food(f_id), " +
		 	            "s_id varchar(6), FOREIGN KEY(s_id) REFERENCES Sub_Events(s_id),PRIMARY KEY(c_id) )";
	         stmt.executeUpdate(sql6);
	         stmt.close();
	         c.close();
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}

}
