import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
public class Register {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static Scanner sc= new Scanner(System.in);
    JFrame a;
    JPanel p1;
    JButton br1, b1;
    JTable t;
    JTextField t1,t2,t3,t4;
    JLabel l0,l1,l2,l3,l4;
    Font f = new Font("SansSerif", Font.PLAIN, 20);
    Font f1 = new Font("SansSerif", Font.BOLD, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Register() throws SQLException{
    	a= new JFrame("Register");
        p1= new JPanel();p1.setBounds(0,0,400,300);p1.setBackground(Color.white);
        br1=new JButton("Reset");br1.setFont(f1);
		b1=new JButton("Add");b1.setFont(f1);
		l1=new JLabel("Enter c_id: ");l1.setFont(f1);
		t1=new JTextField("");t1.setFont(f2);
		l2=new JLabel("cname: ");l2.setFont(f1);
		t2=new JTextField("");t2.setFont(f2);
		l3=new JLabel("DOB: ");l3.setFont(f1);
		t3=new JTextField("");t3.setFont(f2);
		l4=new JLabel("Address: ");l4.setFont(f1);
		t4=new JTextField("");t4.setFont(f2);		

		p1.add(l1);p1.add(t1);
		p1.add(l2);p1.add(t2);
		p1.add(l3);p1.add(t3);
		p1.add(l4);p1.add(t4);
		p1.add(br1);p1.add(b1);p1.setLayout(new GridLayout(6,2));
		
		a.add(p1);
        a.setSize(400,365);
        a.setLayout(null);
        a.setVisible(true);
        p1.setVisible(true);

    	try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Event_management","postgres", "vasudha27");
			statement = connect.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        ActionListener x=new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	
        		if(e.getActionCommand()=="Reset") {
        			t1.setText("");
        			t2.setText("");
        			t3.setText("");
        			t4.setText("");
        		}
        		if(e.getSource()==b1) {
        			String c_id=(t1.getText());
        			String cname=(t2.getText());
        			String DOB=(t3.getText());
        			String Address=(t4.getText());
        			try {
        				insert(c_id,cname,DOB,Address);
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		        		
            }
       };


       b1.addActionListener(x);

    }
    public void insert(String c_id,String cname,String DOB,String Address) throws SQLException {
    	try{
    		preparedStatement = connect.prepareStatement("insert into Registers values (?,?,?,?); ");
    		preparedStatement.setString(1,c_id);
	    	preparedStatement.setString(2,cname);
	    	preparedStatement.setString(3,DOB);
	    	preparedStatement.setString(4,Address);
	        preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(a,"Successfully Registered.");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
           	
    }

	public void exit() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connect != null) connect.close();
        } 
        catch (Exception e) {}
        finally {
        	if (JOptionPane.showConfirmDialog(a, 
                    "Are you sure you want to close the Application?", "Close Window?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
        }
    }
	public static void main(String[] args) throws Exception {
		new Register();
	}
}
