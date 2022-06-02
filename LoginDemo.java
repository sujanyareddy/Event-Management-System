import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
public class LoginDemo extends JFrame implements ActionListener {
   JPanel panel;
   JLabel user_label, password_label, message;
   JTextField userName_text;
   JPasswordField password_text;
   JButton LoginCustomer,LoginOwner,LoginAdmin,Sign_Up;
   LoginDemo() {
      // Username Label
      user_label = new JLabel();
      user_label.setText("User Name :");
      userName_text = new JTextField();
      // Password Label
      password_label = new JLabel();
      password_label.setText("Password :");
      password_text = new JPasswordField();
      // Submit
      LoginCustomer = new JButton("LoginCustomer");
      LoginOwner = new JButton("LoginOwner");
      LoginAdmin = new JButton("LoginAdmin");
      Sign_Up = new JButton("Sign_Up");
      panel = new JPanel(new GridLayout(9, 3));
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      message = new JLabel();
      panel.add(message);
      panel.add(LoginCustomer);
      panel.add(LoginOwner);
      panel.add(LoginAdmin);
      panel.add(Sign_Up);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Adding the listeners to components..
      LoginCustomer.addActionListener(this);
      LoginOwner.addActionListener(this);
      LoginAdmin.addActionListener(this);
      Sign_Up.addActionListener(this);
      add(panel, BorderLayout.CENTER);
      setTitle("Please Login Here !");
      setSize(450,350);
      setVisible(true);
   }
   public static void main(String[] args) {
      new LoginDemo();
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      if (userName.trim().equals("admin") && password.trim().equals("admin")) {
    	  if(ae.getSource()==LoginCustomer) {
      		try {
  				new Customer_Workings();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		}
    	  if(ae.getSource()==LoginOwner) {
      		try {
  				new Owner_Workings();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		}
    	  if(ae.getSource()==LoginAdmin) {
      		try {
  				new Admin_Workings();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		}
    	 
      } 
      else if(ae.getSource()==Sign_Up){
    	  if(ae.getSource()==Sign_Up) {
      		try {
  				new Register();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		}else {
      }
         message.setText(" Invalid user.. ");
      }
   }
}
