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
public class Admin_Workings {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static Scanner sc= new Scanner(System.in);
    JFrame a;
    JMenu m;
    JMenuBar M;
    JMenuItem m1,m2; 
    JPanel po,p0,p4;
    JButton br4,b3;
    JTable t;
    JTextField t5,t6,t7,t8,t9;
    JLabel l0,l5,l6,l7,l8,l9,l11;
    Font f = new Font("SansSerif", Font.PLAIN, 20);
    Font f1 = new Font("SansSerif", Font.BOLD, 15);
    Font f2 = new Font("SansSerif", Font.PLAIN, 15);
    Admin_Workings() throws SQLException{
    	a= new JFrame("Admins");
        m = new JMenu("Admin Operations");m.setFont(f1);
        M = new JMenuBar();
        m1 = new JMenuItem("Details");m1.setFont(f1);
        m2 = new JMenuItem("Close");m2.setFont(f1);
        m.add(m1);m.add(m2);
        M.add(m);
        po= new JPanel(new BorderLayout());po.setBounds(0,0,400,400);po.setBackground(Color.white);
        p0= new JPanel(new BorderLayout());p0.setBounds(0,0,800,300);p0.setBackground(Color.white);
        p4= new JPanel();p4.setBounds(0,0,400,300);p4.setBackground(Color.white);
	    

        br4=new JButton("Reset");br4.setFont(f1);
        l0=new JLabel("  Welcome to Event_Management Database!!You are logged in as Admin");l0.setFont(f);l0.setBounds(100, 135, 120, 40);
		b3=new JButton("View Order Details");b3.setFont(f1);
		l5=new JLabel("Enter c_id: ");l5.setFont(f1);
		t5=new JTextField("");t5.setFont(f2);
		l11=new JLabel("Available Options ");l11.setFont(f1);
		
		p0.add(l0,BorderLayout.CENTER);
		p4.add(l5);p4.add(t5);
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
        			exit();
        		}
        		if(e.getActionCommand()=="Reset") {
            		t5.setText("");
        		}
        		        		
            }
       };
       m1.addActionListener(x);
       m2.addActionListener(x);
       br4.addActionListener(x);
    }
    public void display() throws SQLException {
    	try {
    		resultSet = statement.executeQuery("select * from Orders");
	        int i=0;
	    	while (resultSet.next()) i++;
	    	String column[]={"c_id","e_id" , "v_id" , "f_id" , "s_id"}; 
	    	String[][] rows=new String[i][5];
	    	i=0;
	    	resultSet=statement.executeQuery("select * from Orders");
	    	while (resultSet.next()) {
	    		rows[i][0] = resultSet.getString("c_id");
	            rows[i][1] = String.valueOf(resultSet.getInt("E_id"));
	            rows[i][2] = resultSet.getString("v_id");
	            rows[i][3] = resultSet.getString("f_id");
	            rows[i][4] = resultSet.getString("s_id");
	            i++;
	        }
	    	t=new JTable(rows,column);
			JScrollPane sp=new JScrollPane(t);
			t.setFocusable(false);
			po.add(sp,BorderLayout.CENTER);
	        po.setVisible(true);
		}catch(Exception e) {
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
		new Admin_Workings();
	}
}
