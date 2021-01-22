package vehicleManagementSystem;


import javax.swing.*;
import vehicleManagementSystem.UserClass;
import vehicleManagementSystem.VehicleClass;

@SuppressWarnings("unused")
public class MainClass {
	static final JFrame userClassFrame = new JFrame("Login");
	static JFrame vehicleClassFrame=new JFrame("Dashboard");
   public static void main(String[] args) {
	    UserClass uc=new UserClass();
	    uc.loginFunc(userClassFrame,vehicleClassFrame);
	    new VehicleClass(userClassFrame,vehicleClassFrame);
   }
}
