package vehicleManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//for action listeners

public class UserClass {
	
	void loginFunc(JFrame f,JFrame d)
	{
		//Button creation
		JButton loginButton=new JButton("Login");
		loginButton.setBounds(340,530,350,50);

		//textfield creation
		JTextField usernameTextField=new JTextField();
		usernameTextField.setBounds(340,230,350,50);
		usernameTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		JTextField passwordTextField=new JTextField();
		passwordTextField.setBounds(340,390,350,50);
		passwordTextField.setFont(new Font("Verdana", Font.PLAIN, 20));
		

		//heading label
		JLabel headingLabel = new JLabel("Vehicle Management System",SwingConstants.CENTER);
		headingLabel.setBounds(10,10,1030,50);
		headingLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		JLabel usernameLabel = new JLabel("User name",SwingConstants.CENTER);
		usernameLabel.setBounds(340,181,350,30);
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		JLabel passwordLabel = new JLabel("Password",SwingConstants.CENTER);
		passwordLabel.setBounds(340,335,350,30);
		passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

		f.add(headingLabel);
		f.add(usernameLabel);
		f.add(passwordLabel);
		f.add(usernameTextField);
		f.add(passwordTextField);
		f.add(loginButton);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1040,632);
		f.setLayout(null);
		f.setVisible(true);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String uname=usernameTextField.getText();
				String pword=passwordTextField.getText();
				if(checkCredentials(uname,pword)==1)
				{
					System.out.println("user logged into system......");
					f.dispose();
					d.setVisible(true);
				}
				else
				{
					System.out.println("username/password incorrect");
				}
			}
		});
	}
	
   int checkCredentials(String uname,String pword)
   {
	  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
      String Username = "root";
      String password = "root";
      Connection conn = null;
      Statement stmt=null;
      ResultSet rs=null;
       
      try {
         System.out.println("Connecting to database..............."+JdbcURL);
         conn=DriverManager.getConnection(JdbcURL, Username, password);
         System.out.println("Connection is successful!!!!!!");
         stmt=conn.createStatement();
         stmt.execute("select * from login");
         rs=stmt.getResultSet();
         System.out.println("Checking Credentials......");
         while(rs.next())
         {
        	 String unametable=rs.getString("username");
        	 String pwordtable=rs.getString("password");
        	 if(unametable.equals(uname)&&pwordtable.equals(pword))
        		 return 1;
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }	
	  return 0; 
   }
}