import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class insert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Event_management", "postgres", "vasudha27");
	         
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO Events(E_id,Ename,categor_level)"+
	        			"VALUES(1,'Wedding','High');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Events(E_id,Ename,categor_level)"+
	        			"VALUES(2,'Annual Day','Medium');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Events(E_id,Ename,categor_level)"+
	        			"VALUES(3,'Birthday Party','Low');";
	        	stmt.executeUpdate(sql);



	        	sql = "INSERT INTO Customers(c_id,cname,DOB,Address,E_id)"+
	        			"VALUES('1c','Spandana','22-09-2002','Nlgn','1');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Customers(c_id,cname,DOB,Address,E_id)"+
	        			"VALUES('2c','Sujanya','18-09-2001','Hyd','2');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Customers(c_id,cname,DOB,Address,E_id)"+
	        			"VALUES('3c','Khyathi','19-10-2000','Bhvm','3');";
	        	stmt.executeUpdate(sql);


	        	sql = "INSERT INTO Sub_Events(s_id,sname,E_id)"+
	        			"VALUES('1s','Sangeet','1');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Sub_Events(s_id,sname,E_id)"+
	        			"VALUES('2s','Felistation','2');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Sub_Events(s_id,sname,E_id)"+
	        			"VALUES('3s','Magic Show','3');";
	        	stmt.executeUpdate(sql);


	        	sql = "INSERT INTO Venue(v_id,vname,Location,E_id)"+
	        			"VALUES('1v','Westin','Madhapur','1');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Venue(v_id,vname,Location,E_id)"+
	        			"VALUES('2v','Sheraton','BHEL','2');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Venue(v_id,vname,Location,E_id)"+
	        			"VALUES('3v','Novotel','Hitec City','3');";
	        	stmt.executeUpdate(sql);



	        	sql = "INSERT INTO Food(f_id,fname,price,E_id)"+
	        			"VALUES('1f','Gulab Jamun','50','3');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Food(f_id,fname,price,E_id)"+
	        			"VALUES('2f','Biryani','500','1');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Food(f_id,fname,price,E_id)"+
	        			"VALUES('3f','KFC','600','2');";
	        	stmt.executeUpdate(sql);


	        	sql = "INSERT INTO Books(E_id,c_id,event_cost)"+
	        			"VALUES('1','1c','100000');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Books(E_id,c_id,event_cost)"+
	        			"VALUES('2','2c','50000');";
	        	stmt.executeUpdate(sql);
	        	sql = "INSERT INTO Books(E_id,c_id,event_cost)"+
	        			"VALUES('3','3c','20000');";
	        	stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	}

}