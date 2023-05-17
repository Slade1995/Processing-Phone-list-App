package week10;
import static java.lang.System.out;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String txtfile = "data/phone.txt";
		try {
			SmartPhoneApp app = new SmartPhoneApp(txtfile);
			SmartPhone cheapest = app.getCheapest();
			if(cheapest != null) {
				out.println("Cheapest phone:");
				cheapest.displayInfo();
			}
			out.printf("Phones with screen size 5-7 inches: %d\n", app.countPhones());
			app.randomPhoneList();
		}
		catch(IOException ioe) {
			out.printf("Perhaps missing text file: %s/%s? \n\n",
					new Main().getClass().getPackage().getName(), txtfile);
		}
	}
}