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
public class Owner_Workings {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static Scanner sc= new Scanner(System.in);
    JFrame a;
    JMenu m;
    JMenuBar M;
    JMenuItem m1,m2,m3,m4,m6,m7; 
    JPanel po,p0,p1,p2,p3,p4;
    JButton br1,br2,br3,br4,b3,b1,b2,b4;
    JTable t;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t12;
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l12,l11;
    Font f = new Font("SansSerif", Font.PLAIN, 20);
    Font f1 = new Font("SansSerif", Font.BOLD, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Owner_Workings() throws SQLException{
    	a= new JFrame("Owners");
        m = new JMenu("Owner Operations");m.setFont(f1);
        M = new JMenuBar();
        m1 = new JMenuItem("Add an Event");m1.setFont(f1);
        m2 = new JMenuItem("Add a Venue");m2.setFont(f1);
        m3 = new JMenuItem("Add a food_item");m3.setFont(f1);
        m4 = new JMenuItem("Add a Sub_event");m4.setFont(f1);
        m6 = new JMenuItem("Close");m6.setFont(f1);
        m7 = new JMenuItem("Go Back To HomePage");m7.setFont(f1);
        m.add(m1);m.add(m2);m.add(m3);m.add(m4);m.add(m6);m.add(m7);
        M.add(m);
        po= new JPanel(new BorderLayout());po.setBounds(0,0,400,400);po.setBackground(Color.white);
        p0= new JPanel(new BorderLayout());p0.setBounds(0,0,800,300);p0.setBackground(Color.white);
        p1= new JPanel();p1.setBounds(0,0,400,300);p1.setBackground(Color.white);
        p2= new JPanel();p2.setBounds(0,0,400,300);p2.setBackground(Color.white);
        p3= new JPanel();p3.setBounds(0,0,400,300);p3.setBackground(Color.white);
        p4= new JPanel();p4.setBounds(0,0,400,300);p4.setBackground(Color.white);
	    
        br1=new JButton("Reset");br1.setFont(f1);
        br2=new JButton("Reset");br2.setFont(f1);
        br3=new JButton("Reset");br3.setFont(f1);
        br4=new JButton("Reset");br4.setFont(f1);
        l0=new JLabel("  Welcome to Event_Management Database!!You are logged in as Owner");l0.setFont(f);l0.setBounds(100, 135, 120, 40);
		b3=new JButton("Add");b3.setFont(f1);
		b1=new JButton("Add");b1.setFont(f1);
		b2=new JButton("Add");b2.setFont(f1);
		b4=new JButton("Add");b4.setFont(f1);
		l1=new JLabel("Enter e_id: ");l1.setFont(f1);
		t1=new JTextField("");t1.setFont(f2);
		l2=new JLabel("Ename: ");l2.setFont(f1);
		t2=new JTextField("");t2.setFont(f2);
		l3=new JLabel("Category_level: ");l3.setFont(f1);
		t3=new JTextField("");t3.setFont(f2);
		l4=new JLabel("Enter v_id: ");l4.setFont(f1);
		t4=new JTextField("");t4.setFont(f2);
		l5=new JLabel("vname: ");l5.setFont(f1);
		t5=new JTextField("");t5.setFont(f2);
		l6=new JLabel("Location: ");l6.setFont(f1);
		t6=new JTextField("");t6.setFont(f2);
		l7=new JLabel("Enter f_id: ");l7.setFont(f1);
		t7=new JTextField("");t7.setFont(f2);
		l8=new JLabel("Enter Fname: ");l8.setFont(f1);
		t8=new JTextField("");t8.setFont(f2);
		l9=new JLabel("Price: ");l9.setFont(f1);
		t9=new JTextField("");t9.setFont(f2);
		l10=new JLabel("Entr s_id: ");l10.setFont(f1);
		t10=new JTextField("");t10.setFont(f2);
		l12=new JLabel("sname: ");l12.setFont(f1);
		t12=new JTextField("");t12.setFont(f2);
		l11=new JLabel("Available Options ");l11.setFont(f1);
		
		p0.add(l0,BorderLayout.CENTER);
		p1.add(l1);p1.add(t1);
		p1.add(l2);p1.add(t2);
		p1.add(l3);p1.add(t3);
		p1.add(br1);p1.add(b1);p1.setLayout(new GridLayout(6,2));
		p2.add(l4);p2.add(t4);
		p2.add(l5);p2.add(t5);
		p2.add(l6);p2.add(t6);
		p2.add(br2);p2.add(b2);p2.setLayout(new GridLayout(6,2));
		p3.add(l7);p3.add(t7);
		p3.add(l8);p3.add(t8);
		p3.add(l9);p3.add(t9);
		p3.add(br3);p3.add(b3);p3.setLayout(new GridLayout(6,2));
		p4.add(l10);p4.add(t10);
		p4.add(l12);p4.add(t12);
		p4.add(br4);p4.add(b4);p4.setLayout(new GridLayout(6,2));
		
		a.add(p0);a.add(p4);a.add(po);a.add(p1);a.add(p2);a.add(p3);
        a.setJMenuBar(M);
        a.setSize(400,365);
        a.setLayout(null);
        a.setVisible(true);
        p0.setVisible(true);
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
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
                	p1.setVisible(true);
                	p2.setVisible(false);
                	p3.setVisible(false);
                    p4.setVisible(false);
                    po.setVisible(false);
            		
        		}
        		if(e.getSource()==m2) {
        			p0.setVisible(false);
                	p1.setVisible(false);
                	p2.setVisible(true);
                	p3.setVisible(false);
                    p4.setVisible(false);
                    po.setVisible(false);
        	        
        		}
        		if(e.getSource()==m3) {
        			p0.setVisible(false);
                	p1.setVisible(false);
                	p2.setVisible(false);
                	p3.setVisible(true);
                    p4.setVisible(false);
                    po.setVisible(false);
        	       
        		}
        		if(e.getSource()==m4) {
        			p0.setVisible(false);
                	p1.setVisible(false);
                	p2.setVisible(false);
                	p3.setVisible(false);
                    p4.setVisible(true);
                    po.setVisible(false);
        	        
        		}
        		if(e.getSource()==m6) {
        			exit();
        		}
        		if(e.getSource()==m7) {
        			p0.setVisible(false);
                	p1.setVisible(false);
                	p2.setVisible(false);
                	p3.setVisible(false);
                    p4.setVisible(false);
                    po.setVisible(true);
            		
        		}
        		if(e.getActionCommand()=="Reset") {
        			t1.setText("");
        			t2.setText("");
        			t3.setText("");
        			t4.setText("");
        			t5.setText("");
            		t6.setText("");
            		t7.setText("");
            		t8.setText("");
            		t9.setText("");
            		t10.setText("");
            		t12.setText("");
        		}
        		if(e.getSource()==b1) {
        			int Event=Integer.parseInt(t1.getText());
        			String ename=(t2.getText());
        			String category_level=(t3.getText());
        			try {
        				insert(Event,ename,category_level);
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==b2) {
        			String v_id=(t4.getText());
        			String Vname=(t5.getText());
        			String Location=(t6.getText());
        			try {
        				insert1(v_id,Vname,Location);
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==b3) {
        			String f_id=(t7.getText());
        			String fname=(t8.getText());
        			int Price=Integer.parseInt(t9.getText());
        			try {
        				insert2(f_id,fname,Price);
        			} catch (SQLException e1) {
        				e1.printStackTrace();
        			}
        		}
        		if(e.getSource()==b4) {
        			String s_id=(t10.getText());
        			String sname=(t12.getText());
        			try {
        				insert3(s_id,sname);
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
       m6.addActionListener(x);
       m7.addActionListener(x);
       b1.addActionListener(x);
       b2.addActionListener(x);
       b3.addActionListener(x);
       b4.addActionListener(x);
       br1.addActionListener(x);
       br2.addActionListener(x);
       br3.addActionListener(x);
       br4.addActionListener(x);
    }
    public void insert(int Event,String ename,String category_level) throws SQLException {
    	try{
    		preparedStatement = connect.prepareStatement("insert into Events values (?,?,?); ");
    		preparedStatement.setInt(1,Event);
	    	preparedStatement.setString(2,ename);
	    	preparedStatement.setString(3,category_level);
	        preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(a,"Successfully Inserted.");
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(a,"Insertion Failed.","Error",JOptionPane.WARNING_MESSAGE);
    	}
        
    	
    }
    public void insert1(String v_id,String Vname,String Location) throws SQLException {
    	try{
    		preparedStatement = connect.prepareStatement("insert into Venue values (?,?,?); ");
    		preparedStatement.setString(1,v_id);
	    	preparedStatement.setString(2,Vname);
	    	preparedStatement.setString(3,Location);
	        preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(a,"Successfully Inserted.");
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(a,"Insertion Failed.","Error",JOptionPane.WARNING_MESSAGE);
    	}
        
    	
    }
    public void insert2(String f_id,String fname,int Price) throws SQLException {
    	try{
    		preparedStatement = connect.prepareStatement("insert into Food values (?,?,?); ");
    		preparedStatement.setString(1,f_id);
	    	preparedStatement.setString(2,fname);
	    	preparedStatement.setInt(3,Price);
	        preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(a,"Successfully Inserted.");
    	}catch(SQLException e) {
    		JOptionPane.showMessageDialog(a,"Insertion Failed.","Error",JOptionPane.WARNING_MESSAGE);
    	}
    }
    public void insert3(String s_id,String sname) throws SQLException {
    	try{
    		preparedStatement = connect.prepareStatement("insert into Sub_Events values (?,?); ");
    		preparedStatement.setString(1,s_id);
	    	preparedStatement.setString(2,sname);
	        preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(a,"Successfully Inserted.");
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
		new Owner_Workings();
	}
}
