package vehicleManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;


public class VehicleClass {
	
	JButton dashboardButton=new JButton("Dashboard");
	JButton searchVehicleButton=new JButton("Search Vehicle");
	JButton addVehicleButton=new JButton("Add Vehicle");
	JButton viewSalesHistoryButton=new JButton("View Sales History");
	JButton viewVehiclesButton=new JButton("View Vehicles");
	
	JPanel dashboardPanel = new JPanel();
	JPanel searchPanel1 = new JPanel();
	JPanel searchPanel2 = new JPanel();
	JPanel searchPanel3 = new JPanel();
	JPanel addPanel = new JPanel();
	JPanel deletePanel = new JPanel();
	JPanel viewSalesHistoryPanel = new JPanel();
	JPanel viewVehiclesPanel=new JPanel();
	
	//textFields for add vehicle
	JTextField addNameTF=new JTextField();
	JTextField addEngineTF=new JTextField();
	JTextField addMileageTF=new JTextField();
	JTextField addCompanyTF=new JTextField();
	JTextField addPriceTF=new JTextField();
	JTextField addCountTF=new JTextField();
	
	//In search panel
		//panel 1
		JTextField searchTextField=new JTextField();
		JLabel searchLabel=new JLabel("Enter Number of vehicle to search");
		JButton searchButton=new JButton("Search");
			//labels
		JLabel searchIdLabel=new JLabel();
		JLabel searchNameLabel=new JLabel();
		JLabel searchEngineLabel=new JLabel();
		JLabel searchMileageLabel=new JLabel();
		JLabel searchCompanyLabel=new JLabel();
		JLabel searchPriceLabel=new JLabel();
		JLabel searchCountLabel=new JLabel();
		JLabel searchHeadingLabel=new JLabel();
		//sell button
		JButton searchSellButton=new JButton("Sell");
		
		//panel 2
		JLabel search2CutomerLabel=new JLabel("Customer Information");
		JLabel search2NameLabel=new JLabel("Name");
		JLabel search2AddressLabel=new JLabel("Address");
		JLabel search2MbNoLabel=new JLabel("Mobile Number");
		JLabel search2EmailLabel=new JLabel("Email");
		JTextField search2NameTF=new JTextField();
		JTextField search2AddressTF=new JTextField();
		JTextField search2MbNoTF=new JTextField();
		JTextField search2EmailTF=new JTextField();
		
		JLabel search2SalesLabel=new JLabel("Sales Information");
		JLabel search2DateLabel=new JLabel("Date");
		JLabel search2PriceLabel=new JLabel("Price");
		JTextField search2DateTF=new JTextField();
		JTextField search2PriceTF=new JTextField();
		//sell button
		JButton search2InvoiceButton=new JButton("Invoice");
		
		//sold vehicle info
		String soldVehiclenamestr;
		int soldCustomerId;
		String soldSalesDate;
		
		
		//panel 3
		JLabel search3InvoiceLabel=new JLabel("");
		JLabel search3CustomerNameLabel=new JLabel();
		JLabel search3CustomerAddressLabel=new JLabel();
		JLabel search3CustomerEmailLabel=new JLabel();
		JLabel search3CustomerMbNoLabel=new JLabel();
		JLabel search3VehicleNameLabel=new JLabel();
		JLabel search3VehicleCompanyLabel=new JLabel();
		JLabel search3VehicleMileageLabel=new JLabel();
		JLabel search3SalesPriceLabel=new JLabel();
		JLabel search3SalesDateLabel=new JLabel();
		
	//In Dashboard panel
	JLabel dashboardVehicleNumberLabel=new JLabel();
	JLabel dashboardCustomerNumberLabel=new JLabel();
	JLabel dashboardSalesNumberLabel=new JLabel();	
		
	//view sales history panel
	JTable salesHistoryTable;
	
	//view sales history panel
	JTable viewVehicleTable;
	
	VehicleClass(JFrame ucf,JFrame vcf){
		
		//border for labels for my understanding
		Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
		
		//main heading label 
		JLabel headingLabel = new JLabel("Vehicle Management System",SwingConstants.CENTER);
		headingLabel.setBounds(233,0,803,100);
		headingLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		headingLabel.setBorder(border);
		
		//main heading side bar for date and time
		String timeStamp = new SimpleDateFormat("dd MMM yyyy").format(Calendar.getInstance().getTime());
		JLabel DateTimeLabel = new JLabel("Date : "+timeStamp,SwingConstants.CENTER);
		DateTimeLabel.setBounds(0,0,233,100);
		DateTimeLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		DateTimeLabel.setBorder(border);
		
		//----------------------------------------------------------------------------
		//-------------------------------------DASHBOARD--------------------------
		//----------------------------------------------------------------------------
		
		//dashboard panel
		dashboardPanel.setBounds(237,105,780,480);
		dashboardPanel.setBackground(Color.WHITE);
		dashboardPanel.setVisible(true);
		dashboardPanel.setLayout(null);
		
		//different parameters on dashboard
		dashboardVehicleNumberLabel.setBounds(30,50,600,20);
		dashboardVehicleNumberLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		dashboardCustomerNumberLabel.setBounds(30,130,600,20);
		dashboardCustomerNumberLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		dashboardSalesNumberLabel.setBounds(30,210,600,20);
		dashboardSalesNumberLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		
		dashboardPanel.add(dashboardVehicleNumberLabel);
		dashboardPanel.add(dashboardCustomerNumberLabel);
		dashboardPanel.add(dashboardSalesNumberLabel);
		
		DashboardInfo();
		
		//dashboard button
		dashboardButton.setBounds(0,110,233,50);
		dashboardButton.setBackground(Color.WHITE);
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DashboardInfo();
				dashboardPanel.setVisible(true);
				searchPanel1.setVisible(false);
				addPanel.setVisible(false);
				viewSalesHistoryPanel.setVisible(false);
			}
		});
		
		//----------------------------------------------------------------------------
		//------------------------------------SEARCH-------------------------------
		//----------------------------------------------------------------------------
		
		
		searchPanel1.setBounds(237,105,780,480);
		searchPanel1.setBackground(Color.WHITE);
		searchPanel1.setVisible(false);
		searchPanel2.setBounds(237,105,780,480);
		searchPanel2.setBackground(Color.WHITE);
		searchPanel2.setVisible(false);
		searchPanel3.setBounds(237,105,780,480);
		searchPanel3.setBackground(Color.WHITE);
		searchPanel3.setVisible(true);
		
		
		//search panel 1-----------------------------------------------------------------------------------------------------
		searchLabel.setBounds(70,40,500,20);
		searchLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		searchTextField.setFont(new Font("Verdana", Font.PLAIN, 10));
		searchTextField.setBounds(450,40,150,20);
		
		
		searchButton.setBounds(600,40,100,20);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				searchButtonPressed();
			}
		});
		
		
		//labels which will be visible after clicking search
		searchHeadingLabel.setBounds(70,100,400,30);
		searchIdLabel.setBounds(70,140,400,20);
	   	searchNameLabel.setBounds(70,180,400,20);
	   	searchEngineLabel.setBounds(70,220,400,20);
	   	searchMileageLabel.setBounds(70,260,400,20);
	   	searchCompanyLabel.setBounds(70,300,400,20);
	   	searchPriceLabel.setBounds(70,340,400,20);
	   	searchCountLabel.setBounds(70,380,400,20);
	   	
	   	searchHeadingLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
	   	searchIdLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	searchNameLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	searchEngineLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	searchMileageLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	searchCompanyLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	searchPriceLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	searchCountLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	
	   	searchPanel1Labels(false);
   	 
	   	//button which will be visible after search click
	   	searchSellButton.setBounds(400,400,100,40);
	   	searchSellButton.setVisible(false);
	   	searchSellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				searchSellButtonPressed();
			}
		});
	   	
	   	//adding into panel
		searchPanel1.add(searchButton);
		searchPanel1.add(searchLabel);
		searchPanel1.add(searchTextField);
		
		searchPanel1.add(searchHeadingLabel);
		searchPanel1.add(searchIdLabel);
		searchPanel1.add(searchNameLabel);
		searchPanel1.add(searchEngineLabel);
		searchPanel1.add(searchMileageLabel);
		searchPanel1.add(searchCompanyLabel);
		searchPanel1.add(searchPriceLabel);
		searchPanel1.add(searchCountLabel);
		
		searchPanel1.add(searchSellButton);
		
		searchPanel1.setLayout(null);
		
		
		//search panel2----------------------------------------------------------------------------------------------
		
		
		search2CutomerLabel.setBounds(70,10,400,30);
		search2NameLabel.setBounds(70,60,300,20);
	   	search2AddressLabel.setBounds(70,100,300,20);
	   	search2MbNoLabel.setBounds(70,140,200,20);
	   	search2EmailLabel.setBounds(70,180,300,20);
	   	search2NameTF.setBounds(250,60,200,20);
	   	search2AddressTF.setBounds(250,100,200,20);
	   	search2MbNoTF.setBounds(250,140,200,20);
	   	search2EmailTF.setBounds(250,180,200,20);
	   	
	   	search2SalesLabel.setBounds(400,250,400,30);
	   	search2DateLabel.setBounds(400,300,400,20);
	   	search2PriceLabel.setBounds(400,340,400,20);
	   	search2DateTF.setBounds(550,300,200,20);
	   	search2PriceTF.setBounds(550,340,200,20);
	   	
	   	search2CutomerLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
	   	search2NameLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search2AddressLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search2MbNoLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search2EmailLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	
	   	search2SalesLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
	   	search2DateLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search2PriceLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	
	   	search2InvoiceButton.setBounds(70,400,150,30);
	   	search2InvoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				search2InvoiceButtonClicked();
			}
		});
	   	
	   	searchPanel2.add(search2CutomerLabel);
		searchPanel2.add(search2NameLabel);
		searchPanel2.add(search2AddressLabel);
		searchPanel2.add(search2MbNoLabel);
		searchPanel2.add(search2EmailLabel);
		searchPanel2.add(search2NameTF);
		searchPanel2.add(search2AddressTF);
		searchPanel2.add(search2MbNoTF);
		searchPanel2.add(search2EmailTF);
		
		searchPanel2.add(search2SalesLabel);
		searchPanel2.add(search2DateLabel);
		searchPanel2.add(search2PriceLabel);
		searchPanel2.add(search2DateTF);
		searchPanel2.add(search2PriceTF);
		
		searchPanel2.add(search2InvoiceButton);

	   	searchPanel2.setLayout(null);
		
	   	//search panel3----------------------------------------------------------------------------------------------
	   	search3InvoiceLabel.setBounds(330,30,400,30);
	   	search3InvoiceLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
	   	
	   	search3CustomerNameLabel.setBounds(200,100,400,20);
		search3CustomerAddressLabel.setBounds(200,140,400,20);
	   	search3CustomerMbNoLabel.setBounds(200,180,400,20);
	   	search3CustomerEmailLabel.setBounds(200,220,400,20);
	   	search3CustomerNameLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search3CustomerAddressLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search3CustomerMbNoLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search3CustomerEmailLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	
	   	
	   	search3VehicleNameLabel.setBounds(200,260,400,20);
	   	search3VehicleCompanyLabel.setBounds(200,300,400,20);
	   	search3VehicleMileageLabel.setBounds(200,340,400,20);
	   	search3VehicleNameLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search3VehicleCompanyLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search3VehicleMileageLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	
	   	search3SalesPriceLabel.setBounds(200,380,400,20);
	   	search3SalesDateLabel.setBounds(200,420,400,20);
	   	search3SalesPriceLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	search3SalesDateLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
	   	
	   	searchPanel3.add(search3InvoiceLabel);
		searchPanel3.add(search3CustomerNameLabel);
		searchPanel3.add(search3CustomerAddressLabel);
		searchPanel3.add(search3CustomerMbNoLabel);
		searchPanel3.add(search3CustomerEmailLabel);
		
		searchPanel3.add(search3VehicleNameLabel);
		searchPanel3.add(search3VehicleCompanyLabel);
		searchPanel3.add(search3VehicleMileageLabel);
		
		searchPanel3.add(search3SalesPriceLabel);
		searchPanel3.add(search3SalesDateLabel);

	   	searchPanel3.setLayout(null);
		
		//search vehicle panel button
		searchVehicleButton.setBounds(0,160,233,50);
		searchVehicleButton.setBackground(Color.WHITE);
		searchVehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dashboardPanel.setVisible(false);
				searchPanel1.setVisible(true);
				addPanel.setVisible(false);
				viewSalesHistoryPanel.setVisible(false);
				viewVehiclesPanel.setVisible(false);
			}
		});
		
		//----------------------------------------------------------------------------------
		//-----------------------------------ADD----------------------------------------------
		//----------------------------------------------------------------------------
		
		
		
		//add vehicle Panel
		addPanel.setBounds(237,105,780,480);
		addPanel.setBackground(Color.WHITE);
		
		//Main heading of panel
		JLabel addMainHeadingLabel=new JLabel("Fill Vehicle Information");
		addMainHeadingLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addMainHeadingLabel.setBounds(50,10,400,30);
		
		//vehicle name
		JLabel addNameLabel=new JLabel("NAME");
		addNameLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addNameLabel.setBounds(50,80,200,30);
		addNameTF.setBounds(250,80,200,30);
		
		//vehicle company
		JLabel addCompanyLabel=new JLabel("COMPANY");
		addCompanyLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addCompanyLabel.setBounds(50,115,200,30);
		addCompanyTF.setBounds(250,115,200,30);
		
		//vehicle Engine
		JLabel addEngineLabel=new JLabel("Engine");
		addEngineLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addEngineLabel.setBounds(50,150,200,30);
		addEngineTF.setBounds(250,150,200,30);
		
		//vehicle price
		JLabel addPriceLabel=new JLabel("PRICE");
		addPriceLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addPriceLabel.setBounds(50,185,200,30);
		addPriceTF.setBounds(250,185,200,30);
		
		
		//vehicle Mileage
		JLabel addMileageLabel=new JLabel("Mileage");
		addMileageLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addMileageLabel.setBounds(50,220,200,30);
		addMileageTF.setBounds(250,220,200,30);
		
		//vehicle Count
		JLabel addCountLabel=new JLabel("Count");
		addCountLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addCountLabel.setBounds(50,255,200,30);
		addCountTF.setBounds(250,255,200,30);
		
		
		//Vehicle Added Label
		JLabel addVehicleAddedLabel=new JLabel("Vehicle information added to database");
		addVehicleAddedLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		addVehicleAddedLabel.setBounds(100,350,600,30);
		addVehicleAddedLabel.setVisible(false);
		
		//add button
		JButton addINSERTButton=new JButton("INSERT"); 
		addINSERTButton.setBounds(350,400,100,40);
		addINSERTButton.setBackground(Color.WHITE);
		addINSERTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				addVehicleFunc();
				addVehicleAddedLabel.setVisible(true);
				addNameTF.setText("");
				addEngineTF.setText("");
				addMileageTF.setText("");
				addCompanyTF.setText("");
				addPriceTF.setText("");
				addCountTF.setText("");
			}
		});
		
		addPanel.add(addINSERTButton);
		addPanel.add(addVehicleAddedLabel);
		addPanel.add(addMainHeadingLabel);
		addPanel.add(addNameLabel);
		addPanel.add(addEngineLabel);
		addPanel.add(addPriceLabel);
		addPanel.add(addCompanyLabel);
		addPanel.add(addMileageLabel);
		addPanel.add(addCountLabel);		
		
		addPanel.add(addNameTF);
		addPanel.add(addCountTF);
		addPanel.add(addCompanyTF);
		addPanel.add(addPriceTF);
		addPanel.add(addMileageTF);
		addPanel.add(addEngineTF);
		
		addPanel.setLayout(null);
		addPanel.setVisible(false);
		
		//add vehicle button
		addVehicleButton.setBounds(0,210,233,50);
		addVehicleButton.setBackground(Color.WHITE);
		addVehicleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dashboardPanel.setVisible(false);
				searchPanel1.setVisible(false);
				addPanel.setVisible(true);
				viewSalesHistoryPanel.setVisible(false);
				viewVehiclesPanel.setVisible(false);
			}
		});
		
		
		//----------------------------------------------------------------------------
		//----------------------HISTORY------------------------------------------------
		//----------------------------------------------------------------------------
		
		
		//view sales history panel
		viewSalesHistoryPanel.setBounds(237,105,780,480);
		viewSalesHistoryPanel.setBackground(Color.WHITE);
		viewSalesHistoryPanel.setLayout(null);
		viewSalesHistoryPanel.setVisible(false);

		
		//view sales history
		viewSalesHistoryButton.setBounds(0,260,233,50);
		viewSalesHistoryButton.setBackground(Color.WHITE);
		viewSalesHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				viewSalesHistory();
				dashboardPanel.setVisible(false);
				searchPanel1.setVisible(false);
				addPanel.setVisible(false);
				viewSalesHistoryPanel.setVisible(true);
				viewVehiclesPanel.setVisible(false);
			}
		});
		
		//----------------------------------------------------------------------------
		//----------------------View Vehicle------------------------------------------------
		//----------------------------------------------------------------------------
		//view sales history panel
		viewVehiclesPanel.setBounds(237,105,780,480);
		viewVehiclesPanel.setBackground(Color.WHITE);
		viewVehiclesPanel.setLayout(null);
		viewVehiclesPanel.setVisible(false);

		viewVehiclesButton.setBounds(0,310,233,50);
		viewVehiclesButton.setBackground(Color.WHITE);
		viewVehiclesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				viewVehicles();
				dashboardPanel.setVisible(false);
				searchPanel1.setVisible(false);
				addPanel.setVisible(false);
				viewSalesHistoryPanel.setVisible(false);
				viewVehiclesPanel.setVisible(true);
			}
		});
		//----------------------------------------------------------------------------
		//----------------------ADDING ALL THINGS IN FRAME------------------------------------------------
		//----------------------------------------------------------------------------
		
		
		vcf.add(headingLabel);
		vcf.add(DateTimeLabel);
		
		vcf.add(dashboardPanel);
		vcf.add(addPanel);
		vcf.add(viewSalesHistoryPanel);
		vcf.add(searchPanel1);
		vcf.add(searchPanel2);
		vcf.add(searchPanel3);
		vcf.add(viewVehiclesPanel);
		
		vcf.add(dashboardButton);
		vcf.add(searchVehicleButton);
		vcf.add(addVehicleButton);
		vcf.add(viewSalesHistoryButton);
		vcf.add(viewVehiclesButton);
		
		vcf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vcf.setSize(1040,632);
		vcf.setLayout(null);
		vcf.setVisible(false);//temporary true if login is open make false
	}//constructor ending
	
	void addVehicleFunc()
	{
		  System.out.println("Vehicle Class :: addVehicleFunc called");
		  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
	      String Username = "root";
	      String password = "root";
	      Connection conn = null;
	      PreparedStatement preparedStatement = null;
	      
	      String name=addNameTF.getText();
	      String company=addCompanyTF.getText();
	      String Engine=addEngineTF.getText();
	      String Count=addCountTF.getText();
	      String price=addPriceTF.getText();
	      String Mileage=addMileageTF.getText();
	      
	      if(addNameTF.getText().isEmpty())name="Empty";
	      if(addCompanyTF.getText().isEmpty())company="Empty";
	      if(addEngineTF.getText().isEmpty())Engine="Empty";
	      if(addCountTF.getText().isEmpty())Count="Empty";
	      if(addPriceTF.getText().isEmpty())price="Empty";
	      if(addMileageTF.getText().isEmpty())Mileage="Empty";
	      
	      
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         conn=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         System.out.println("Inserting into database......");
	         preparedStatement = conn.prepareStatement("insert into vehicle values (?, ?, ?, ? ,?, ?)");
	         preparedStatement.setString(1, name);
             preparedStatement.setString(2, company);
             preparedStatement.setString(3, price);
             preparedStatement.setString(4, Mileage);
             preparedStatement.setString(5, Engine);
             preparedStatement.setString(6, Count);
             preparedStatement.executeUpdate();
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }	
	      System.out.println("Inserted sucessfully into database......");
	}
	
	void searchButtonPressed()
	{
		  System.out.println("Vehicle Class :: searchButtonPressed");
		  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
	      String Username = "root";
	      String password = "root";
	      Connection conn = null;
	      ResultSet rs=null;
	      PreparedStatement preparedStatement = null;
	      
	      String vname=searchTextField.getText();
	      
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         conn=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         
	         preparedStatement = conn.prepareStatement("select * from vehicle where vname = ?");
	         preparedStatement.setString(1, vname);
	         rs=preparedStatement.executeQuery();
	         
	         searchPanel1Labels(false);
	         searchSellButton.setVisible(false);
	         
	         if(rs.next()==false)
	         {
	        	 System.out.println("Result set is empty");
	        	 searchHeadingLabel.setText("Please Enter valid id");
	        	 searchHeadingLabel.setVisible(true);
	         }
	         else {
	        	 do
		         {
		        	 
		        	 String namestr=rs.getString("vname");
		        	 String companystr=rs.getString("vcompany");
		        	 String pricestr=rs.getString("vprice");
		        	 String Mileagestr=rs.getString("vMileage");
		        	 String Enginestr=rs.getString("vEngine");
		        	 String Countstr=rs.getString("vCount");
		        	 
		        	 searchHeadingLabel.setText("Vehicle's Information");
		        	 
			     	 searchNameLabel.setText("Vehicle's Name : "+namestr);
		     	   	 searchEngineLabel.setText("Vehicle's Engine : "+Enginestr);
		     	   	 searchMileageLabel.setText("Vehicle's Mileage : "+Mileagestr);
		     	   	 searchCompanyLabel.setText("Vehicle's Company : "+companystr);
		     	   	 searchPriceLabel.setText("Vehicle's Price : "+pricestr);
		     	   	 searchCountLabel.setText("Vehicle's Count : "+Countstr);
		        	 
		     	   	soldVehiclenamestr=namestr;
		     	   	 //labels
		     	   	 searchPanel1Labels(true);
		     	   	 
		     	   	 //button
		     	   	 searchSellButton.setVisible(true);
		         }while(rs.next());
	         }
	         
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	}
	
	void searchPanel1Labels(Boolean t)
	{
		 searchHeadingLabel.setVisible(t);
 		 
 	   	 searchNameLabel.setVisible(t);
 	   	 searchEngineLabel.setVisible(t);
 	   	 searchMileageLabel.setVisible(t);
 	   	 searchCompanyLabel.setVisible(t);
 	   	 searchPriceLabel.setVisible(t);
 	   	 searchCountLabel.setVisible(t);  	 
	}		
	

	void searchSellButtonPressed()
	{
		System.out.print("Sold vehicle name : "+soldVehiclenamestr);
		searchPanel1.setVisible(false);
		searchPanel2.setVisible(true);
	}
	
	void search2InvoiceButtonClicked()
	{
		 System.out.println("Vehicle Class :: search2InvoiceButtonClicked called");
		  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
	      String Username = "root";
	      String password = "root";
	      Connection conn = null;
	      PreparedStatement preparedStatement1 = null;
	      PreparedStatement preparedStatement2 = null;
	      PreparedStatement preparedStatement3 = null;
	      PreparedStatement ps1 = null;
	      ResultSet rs1=null;
	      ResultSet rs3=null;
	      
	      String name=search2NameTF.getText();
	      String address=search2AddressTF.getText();
	      String mbno=search2MbNoTF.getText();
	      String email=search2EmailTF.getText();
	      
	      String price=search2PriceTF.getText();
	      String date=search2DateTF.getText();
	      
	      if(search2NameTF.getText().isEmpty())name="Empty";
	      if(search2AddressTF.getText().isEmpty())address="Empty";
	      if(search2MbNoTF.getText().isEmpty())mbno="Empty";
	      if(search2EmailTF.getText().isEmpty())email="Empty";
	      if(search2PriceTF.getText().isEmpty())price="Empty";
	      if(search2DateTF.getText().isEmpty())date="Empty";
	      
	      System.out.print("Sold vehicle name : "+soldVehiclenamestr);
	      
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         conn=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         System.out.println("Inserting into database......");
	         preparedStatement1 = conn.prepareStatement("insert into customer values (default,? ,?, ?, ?, ?)");
	         preparedStatement1.setString(1, name);
	         preparedStatement1.setString(2, address);
	         preparedStatement1.setString(3, mbno);
	         preparedStatement1.setString(4, email);
	         preparedStatement1.setString(5,soldVehiclenamestr);
	         preparedStatement1.executeUpdate();
	         
	         ps1=conn.prepareStatement("select * from customer where cmbno=?");
             ps1.setString(1, mbno);
	         rs1=ps1.executeQuery();
	         while(rs1.next())
		     {
		        	 soldCustomerId=rs1.getInt("csrno");
		        	 System.out.println("Cutomer id is : "+Integer.toString(soldCustomerId));
		     }
	         
	         String vehCnt="0";
	         ps1=conn.prepareStatement("select * from vehicle where vname=?");
             ps1.setString(1,soldVehiclenamestr );
	         rs1=ps1.executeQuery();
	         while(rs1.next())
		     {
	        	     vehCnt=rs1.getString("vcount");
		        	 System.out.println(soldVehiclenamestr+"count is : "+vehCnt);
		     }
	         int t=Integer.parseInt(vehCnt);
	         t--;
	         vehCnt=Integer.toString(t);
	         
	         preparedStatement1 = conn.prepareStatement("update vehicle set vCount=? where vname=?");
	         preparedStatement1.setString(1, vehCnt);
	         preparedStatement1.setString(2, soldVehiclenamestr);
	         preparedStatement1.executeUpdate();
	         	
	         preparedStatement2 = conn.prepareStatement("insert into sales values (?, ?, ?)");
	         preparedStatement2.setString(1, date);
             preparedStatement2.setString(2, price);
             preparedStatement2.setInt(3, soldCustomerId);
	         preparedStatement2.executeUpdate();
	         
	         soldSalesDate= date;
	         
	         searchPanel2.setVisible(false);
	         searchPanel3.setVisible(true);
	         
	         preparedStatement3 = conn.prepareStatement("select customer.cname ,customer.caddress , customer.cmbno , customer.cemail ,customer.cvname, vehicle.vcompany, sales.sdate ,sales.sprice from sales join customer on customer.csrno=sales.scustNO join vehicle on vehicle.vname=customer.cvname where sales.sdate=?");
	         preparedStatement3.setString(1, soldSalesDate);
	         rs3=preparedStatement3.executeQuery();
	         
	         if(rs3.next()==false)
	         {
	        	 System.out.println("data not found in join query");
	         }
	         else
	         {
	        	 do
			     {
			        	 String cname=rs3.getString("cname");
			        	 String caddress=rs3.getString("caddress");
			        	 String cmbno=rs3.getString("cmbno");
			        	 String cemail=rs3.getString("cemail");
			        	 String vname=rs3.getString("cvname");
			        	 String vcompany=rs3.getString("vcompany");
			        	 String sprice=rs3.getString("sprice");
			        	 String sdate=rs3.getString("sdate");
			        	 
			        	 search3InvoiceLabel.setText("Invoice");
			        	 search3CustomerNameLabel.setText("Customer Name : "+cname);
			        	 search3CustomerAddressLabel.setText("Customer Address : "+caddress);
			        	 search3CustomerMbNoLabel.setText("Customer Mobile Number : "+cmbno);
			        	 search3CustomerEmailLabel.setText("Customer Email : "+cemail);
			        	 search3VehicleNameLabel.setText("Vehicle Name : "+vname);
			        	 search3VehicleCompanyLabel.setText("Vehicle Company : "+vcompany);
			        	 search3SalesDateLabel.setText("Sales Date : "+sdate);
			        	 search3SalesPriceLabel.setText("Sales Price : "+sprice);
			        	 
			     }while(rs3.next());
	         }

	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }	
	      System.out.println("Inserted sucessfully into database......");
	}
	
	void DashboardInfo()
	{
		  System.out.println("Vehicle Class :: addVehicleFunc called");
		  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
	      String Username = "root";
	      String password = "root";
	      Connection conn = null;
	      PreparedStatement ps1 = null;
	      ResultSet rs1=null;
	      
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         conn=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         System.out.println("Inserting into database......");
	         
	         String vrowsno="0";
	         int ans=0;
	         ps1=conn.prepareStatement("select vcount from vehicle");
	         rs1=ps1.executeQuery(); 
	         while(rs1.next())
	         {
	        	 vrowsno=rs1.getString("vcount");
	        	 int t=Integer.parseInt(vrowsno);
	        	 ans+=t;
	        	 System.out.println("no of row in vehicle is "+vrowsno);
	         }
	         vrowsno=Integer.toString(ans);
	         dashboardVehicleNumberLabel.setText("Number of Vehicle's Available : "+vrowsno);
	         
	         String crowsno="";
	         ps1=conn.prepareStatement("select count(*) from customer");
	         rs1=ps1.executeQuery(); 
	         while(rs1.next())
	         {
	        	 crowsno =rs1.getString("count(*)");
	        	 System.out.println("no of row in customer is "+crowsno);
	         }
	         dashboardCustomerNumberLabel.setText("Total number of customer's served : "+crowsno);
	         
	         String srowsno="";
	         ps1=conn.prepareStatement("select count(*) from sales");
	         rs1=ps1.executeQuery(); 
	         while(rs1.next())
	         {
	        	 srowsno =rs1.getString("count(*)");
	        	 System.out.println("no of row in sales is "+srowsno);
	         }
	         dashboardSalesNumberLabel.setText("Total number of Sales : "+srowsno);
	         
	         
	      }
	      catch(Exception e) {
	         e.printStackTrace();
      }	
	      
	}
	
	void viewSalesHistory()
	{
		System.out.println("Vehicle Class :: viewSalesHistory called");
		  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
	      String Username = "root";
	      String password = "root";
	      Connection conn = null;
	      PreparedStatement preparedStatement = null;
	      ResultSet rs=null;
	      
	      try {
		         System.out.println("Connecting to database..............."+JdbcURL);
		         conn=DriverManager.getConnection(JdbcURL, Username, password);
		         System.out.println("Connection is successful!!!!!!");
		         
		         
		         String srowsno="";
		         preparedStatement=conn.prepareStatement("select count(*) from sales");
		         rs=preparedStatement.executeQuery(); 
		         while(rs.next())
		         {
		        	 srowsno =rs.getString("count(*)");
		        	 System.out.println("no of row in sales is "+srowsno);
		         }
		         
		         
		         
		         preparedStatement = conn.prepareStatement("select customer.cname ,customer.caddress , customer.cmbno , customer.cemail ,customer.cvname, vehicle.vcompany, sales.sdate ,sales.sprice from sales join customer on customer.csrno=sales.scustNO join vehicle on vehicle.vname=customer.cvname");
		         rs=preparedStatement.executeQuery();
		         
		         int sales=Integer.parseInt(srowsno);
		         int i=0;
		         String data[][]=new String[sales][8];
		         String columns[]= {"Cus Name","Address","Mb NO","Email","Vehicle Name","Company","price","Purchase Data"};
		         
		         if(rs.next()==false)
		         {
		        	 System.out.println("data not found in join query");
		         }
		         else
		         {
		        	 do
				     {
				        	 String cname=rs.getString("cname");
				        	 String caddress=rs.getString("caddress");
				        	 String cmbno=rs.getString("cmbno");
				        	 String cemail=rs.getString("cemail");
				        	 String vname=rs.getString("cvname");
				        	 String vcompany=rs.getString("vcompany");
				        	 String sprice=rs.getString("sprice");
				        	 String sdate=rs.getString("sdate");
				        	 
				        	 data[i][0]=cname;
				        	 data[i][1]=caddress;
				        	 data[i][2]=cmbno;
				        	 data[i][3]=cemail;
				        	 data[i][4]=vname;
				        	 data[i][5]=vcompany;
				        	 data[i][6]=sprice;
				             data[i][7]=sdate;
				        	 
				        	 i++;
				        	
				        	 
				     }while(rs.next());
		         }
		         
		         salesHistoryTable=new JTable(data,columns);
		         salesHistoryTable.setBounds(0,0,780,1000);
		         JScrollPane scrollPane = new JScrollPane(salesHistoryTable);
		         scrollPane.setBounds(0,0,780,1000);
		         salesHistoryTable.setFillsViewportHeight(true); 
		         viewSalesHistoryPanel.add(scrollPane);
		         
		      }
		      catch(Exception e) {
		         e.printStackTrace();
		      }	
	      
	}
	
	void viewVehicles()
	{
		System.out.println("Vehicle Class :: viewVehicles called");
		  String JdbcURL = "jdbc:mysql://localhost:3306/vms?";
	      String Username = "root";
	      String password = "root";
	      Connection conn = null;
	      PreparedStatement preparedStatement = null;
	      ResultSet rs=null;
	      
	      try {
		         System.out.println("Connecting to database..............."+JdbcURL);
		         conn=DriverManager.getConnection(JdbcURL, Username, password);
		         System.out.println("Connection is successful!!!!!!");
		         
		         
		         String vrowsno="";
		         preparedStatement=conn.prepareStatement("select count(*) from vehicle");
		         rs=preparedStatement.executeQuery(); 
		         while(rs.next())
		         {
		        	 vrowsno =rs.getString("count(*)");
		        	 System.out.println("no of row in vehicle is "+vrowsno);
		         }
		         
		         
		         
		         preparedStatement = conn.prepareStatement("select * from vehicle");
		         rs=preparedStatement.executeQuery();
		         
		         int rows=Integer.parseInt(vrowsno);
		         int i=0;
		         String data[][]=new String[rows][6];
		         String columns[]= {"Vehicle Name","Company","Price","Mileage","Engine","Count"};
		         
		         if(rs.next()==false)
		         {
		        	 System.out.println("data not found in join query");
		         }
		         else
		         {
		        	 do
				     {
				        	 String name=rs.getString("vname");
				        	 String company=rs.getString("vcompany");
				        	 String price=rs.getString("vprice");
				        	 String Mileage=rs.getString("vMileage");
				        	 String Engine=rs.getString("vEngine");
				        	 String Count=rs.getString("vCount");
				        	 
				        	
				        	 data[i][0]=name;
				        	 data[i][1]=company;
				        	 data[i][2]=price;
				        	 data[i][3]=Mileage;
				        	 data[i][4]=Engine;
				        	 data[i][5]=Count;
				        	 
				        	 i++;
				        	
				        	 
				     }while(rs.next());
		         }
		         
		         viewVehicleTable=new JTable(data,columns);
		         viewVehicleTable.setBounds(0,0,780,1000);
		         JScrollPane scrollPane = new JScrollPane(viewVehicleTable);
		         scrollPane.setBounds(0,0,780,1000);
		         viewVehicleTable.setFillsViewportHeight(true); 
		         viewVehiclesPanel.add(scrollPane);
		         
		      }
		      catch(Exception e) {
		         e.printStackTrace();
		      }	
	}
}