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
import java.sql.SQLException;
import java.sql.Statement;
public class Customer_Workings {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static Scanner sc= new Scanner(System.in);
    JFrame a;
    JMenu m;
    JMenuBar M;
    JMenuItem m1,m2,m3,m4,m5,m6,m7; 
    JPanel po,p0,p4;
    JButton br4,b3;
    JTable t;
    JTextField t5,t6,t7,t8,t9;
    JLabel l0,l5,l6,l7,l8,l9,l11;
    Font f = new Font("SansSerif", Font.PLAIN, 20);
    Font f1 = new Font("SansSerif", Font.BOLD, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Customer_Workings() throws SQLException{
    	a= new JFrame("Customers");
        m = new JMenu("Customer Operations");m.setFont(f1);
        M = new JMenuBar();
        m1 = new JMenuItem("View Event Details");m1.setFont(f1);
        m2 = new JMenuItem("View Venue Details");m2.setFont(f1);
        m3 = new JMenuItem("View Food Details");m3.setFont(f1);
        m4 = new JMenuItem("View Sub_event Details");m4.setFont(f1);
        m5 = new JMenuItem("Place Order");m5.setFont(f1);
        m6 = new JMenuItem("Close");m6.setFont(f1);
        m7 = new JMenuItem("Go Back To HomePage");m7.setFont(f1);
        m.add(m1);m.add(m2);m.add(m3);m.add(m4);m.add(m5);m.add(m6);m.add(m7);
        M.add(m);
        po= new JPanel(new BorderLayout());po.setBounds(0,0,400,400);po.setBackground(Color.white);
        p0= new JPanel(new BorderLayout());p0.setBounds(0,0,800,300);p0.setBackground(Color.white);
        p4= new JPanel();p4.setBounds(0,0,400,300);p4.setBackground(Color.white);
	    

        br4=new JButton("Reset");br4.setFont(f1);
        l0=new JLabel("  Welcome to Event_Management Database!!You are logged in as Customer");l0.setFont(f);l0.setBounds(100, 135, 120, 40);
		b3=new JButton("Place Order");b3.setFont(f1);
		l5=new JLabel("Enter id: ");l5.setFont(f1);
		t5=new JTextField("");t5.setFont(f2);
		l6=new JLabel("Enter Event: ");l6.setFont(f1);
		t6=new JTextField("");t6.setFont(f2);
		l7=new JLabel("Enter Venue: ");l7.setFont(f1);
		t7=new JTextField("");t7.setFont(f2);
		l8=new JLabel("Enter Food_items: ");l8.setFont(f1);
		t8=new JTextField("");t8.setFont(f2);
		l9=new JLabel("Enter Sub_Event: ");l9.setFont(f1);
		t9=new JTextField("");t9.setFont(f2);
		l11=new JLabel("Available Options ");l11.setFont(f1);
		
		p0.add(l0,BorderLayout.CENTER);
		p4.add(l5);p4.add(t5);
		p4.add(l6);p4.add(t6);
		p4.add(l7);p4.add(t7);
		p4.add(l8);p4.add(t8);
		p4.add(l9);p4.add(t9);
		p4.add(br4);p4.add(b3);p4.setLayout(new GridLayout(6,2));
		
		a.add(p0);a.add(p4);a.add(po);
        a.setJMenuBar(M);
        a.setSize(400,365);
        a.setLayout(null);
        a.setVisible(true);
        p0.setVisible(true);
        p4.setVisible(false);
        po.setVisible(false);

    	try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Event_management","postgres", "vasudha27");
			statement = connect.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	finally {
    		po.add(l11,BorderLayout.NORTH);
    	}
        
        ActionListener x=new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==m1) {
                	p0.setVisible(false);
                    p4.setVisible(false);
                    po.setVisible(true);
            		try {
        				display();
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==m2) {
        			p0.setVisible(false);
        	        p4.setVisible(false);
        	        po.setVisible(true);
        	        try {
        				display1();
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==m3) {
        			p0.setVisible(false);
        	        p4.setVisible(false);
        	        po.setVisible(true);
        	        try {
        				display2();
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==m4) {
        			p0.setVisible(false);
        	        p4.setVisible(false);
        	        po.setVisible(true);
        	        try {
        				display3();
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==m5) {
        			p0.setVisible(false);
        	        p4.setVisible(true);
        	        po.setVisible(false);
        		}
        		if(e.getSource()==m6) {
        			exit();
        		}
        		if(e.getSource()==m7) {
                	p0.setVisible(false);
                    p4.setVisible(false);
                    po.setVisible(true);
            		try {
        				new Customer_Workings();
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getActionCommand()=="Reset") {
            		t6.setText("");
            		t7.setText("");
            		t8.setText("");
            		t9.setText("");
        		}
        		if(e.getSource()==b3) {
        			String id=(t5.getText());
        			int Event=Integer.parseInt(t6.getText());
        			String Venue=(t7.getText());
        			String Food_item=(t8.getText());
        			String Sub_Event=(t9.getText());
        			try {
        				insert(id,Event,Venue,Food_item,Sub_Event);
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		        		
            }
       };
       m1.addActionListener(x);
       m2.addActionListener(x);
       m3.addActionListener(x);
       m4.addActionListener(x);
       m5.addActionListener(x);
       m6.addActionListener(x);
       m7.addActionListener(x);
       b3.addActionListener(x);
       br4.addActionListener(x);
    }
    public void display() throws SQLException {
    	try{
    		resultSet = statement.executeQuery("select E_id,ename,categor_level,event_cost from Events natural join Books");
	    	int i=0;
	    	while (resultSet.next()) i++;
	    	String column[]={"ID" , "Name" , "Category_level" , "Price"}; 
	    	String[][] rows=new String[i][4];
	    	i=0;
	    	resultSet = statement.executeQuery("select E_id,ename,categor_level,event_cost from Events natural join Books");
	    	while (resultSet.next()) {
	            rows[i][0] = String.valueOf(resultSet.getInt("E_id"));
	            rows[i][1] = resultSet.getString("ename");
	            rows[i][2] = resultSet.getString("categor_level");
	            rows[i][3] = String.valueOf(resultSet.getInt("event_cost"));
	            i++;
	        }
	    	t=new JTable(rows,column);
			JScrollPane sp=new JScrollPane(t);
			t.setFocusable(false);
			po.add(sp,BorderLayout.CENTER);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    public void display1() throws SQLException {
    	try{
    		resultSet = statement.executeQuery("select v_id,vname,Location from Venue");
	    	int i=0;
	    	while (resultSet.next()) i++;
	    	String column[]={"ID" , "Name" , "Location" }; 
	    	String[][] rows=new String[i][3];
	    	i=0;
	    	resultSet = statement.executeQuery("select v_id,vname,Location from Venue");
	    	while (resultSet.next()) {
	            rows[i][0] = resultSet.getString("v_id");
	            rows[i][1] = resultSet.getString("vname");
	            rows[i][2] = resultSet.getString("Location");
	            i++;
	        }
	    	t=new JTable(rows,column);
			JScrollPane sp=new JScrollPane(t);
			t.setFocusable(false);
			po.add(sp,BorderLayout.CENTER);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    public void display2() throws SQLException {
    	try{
    		resultSet = statement.executeQuery("select f_id,fname,price from Food");
	    	int i=0;
	    	while (resultSet.next()) i++;
	    	String column[]={"ID" , "Name" , "Price" }; 
	    	String[][] rows=new String[i][3];
	    	i=0;
	    	resultSet = statement.executeQuery("select f_id,fname,price from Food");
	    	while (resultSet.next()) {
	            rows[i][0] = resultSet.getString("f_id");
	            rows[i][1] = resultSet.getString("fname");
	            rows[i][2] = String.valueOf(resultSet.getInt("price"));
	            i++;
	        }
	    	t=new JTable(rows,column);
			JScrollPane sp=new JScrollPane(t);
			t.setFocusable(false);
			po.add(sp,BorderLayout.CENTER);
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(a,"Display Failed.","Error",JOptionPane.WARNING_MESSAGE);
    	}
    	
    }
    public void display3() throws SQLException {
    	try{
    		resultSet = statement.executeQuery("select s_id,sname from Sub_Events");
	    	int i=0;
	    	while (resultSet.next()) i++;
	    	String column[]={"ID" , "Name" }; 
	    	String[][] rows=new String[i][2];
	    	i=0;
	    	resultSet = statement.executeQuery("select s_id,sname from Sub_Events");
	    	while (resultSet.next()) {
	            rows[i][0] = resultSet.getString("s_id");
	            rows[i][1] = resultSet.getString("sname");
	            i++;
	        }
	    	t=new JTable(rows,column);
			JScrollPane sp=new JScrollPane(t);
			t.setFocusable(false);
			po.add(sp,BorderLayout.CENTER);
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(a,"Display Failed.","Error",JOptionPane.WARNING_MESSAGE);
    	}
    	
    }
    public void insert(String c_id,int Event,String Venue,String Food_item,String Sub_event) throws SQLException {
    	try{
    		preparedStatement = connect.prepareStatement("insert into Orders values (?,?,?,?,?); ");
    		preparedStatement.setString(1,c_id);
	    	preparedStatement.setInt(2,Event);
	    	preparedStatement.setString(3,Venue);
	    	preparedStatement.setString(4,Food_item);
	    	preparedStatement.setString(5,Sub_event);
	        preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(a,"Successfully Inserted.");
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(a,"Insertion Failed.","Error",JOptionPane.WARNING_MESSAGE);
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
		new Customer_Workings();
	}
}
