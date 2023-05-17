package week10;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.lang.System.out;
import java.util.concurrent.*;


public class SmartPhoneApp {
	private List<SmartPhone> phoneList;

	public List<SmartPhone> getPhoneList() {
		return phoneList;
	}

	public SmartPhoneApp(String filename) throws IOException {
		phoneList = new LinkedList<>();
		readData(filename);

	}

	public void readData(String filename) throws IOException {
		Path path = new File(filename).toPath();
		List<String> content = Files.readAllLines(path);
		for (String phone: content) {
			String phone_brand = phone.split(",")[0];
			double phone_price = Double.parseDouble(phone.split(",")[1]);
			double phone_inch = Double.parseDouble(phone.split(",")[2]);
			phoneList.add(new SmartPhone(phone_brand, phone_price, phone_inch));
		}
	}
	// code to calculate the cheapest phone in records
	public SmartPhone getCheapest() {
		double cheapest_price=phoneList.get(0).getPrice();
		SmartPhone cheapest_phone=null;
		for(SmartPhone phone : phoneList) {
			if(cheapest_price>phone.getPrice()) {
				cheapest_price=phone.getPrice();
			}
		}
		for(SmartPhone phone : phoneList) {
			if(cheapest_price==phone.getPrice()) {
				cheapest_phone=phone;
			}
		}
		return cheapest_phone;
	}
	// code that counts the amount of phones in list
	public int countPhones() {
		int phone_inch=0; //Phones with screen size 5-7 inches
		for (SmartPhone phone : phoneList) {
			if (phone.getScreenSize()>=5 && phone.getScreenSize()<=7) {
				phone_inch++;
			}
		}
		out.println();// for pretty output
		return phone_inch;
	}

	public void randomPhoneList() {
		int random_num; 
		List<SmartPhone> phs1 = new LinkedList<>();
		List<SmartPhone> phs2 = new LinkedList<>();
		List<SmartPhone> phs3 = new LinkedList<>();
		for (SmartPhone phone : phoneList) {
			random_num=ThreadLocalRandom.current().nextInt(1, 4);
			if (random_num==1) {
				phs1.add(phone);
			}
			else if (random_num==2) {
				phs2.add(phone);
			}
			else {
				phs3.add(phone);
			}
		}

		//output lists
		out.printf("\n%s phones in list #1:\n", phs1.size());
		for(SmartPhone phone : phs1) {
			out.printf("%s %s %s\n",phone.getBrand(),phone.getPrice(),phone.getScreenSize());
		}
		out.printf("\n%s phones in list #2:\n", phs2.size());
		for(SmartPhone phone : phs2) {
			out.printf("%s %s %s\n",phone.getBrand(),phone.getPrice(),phone.getScreenSize());
		}
		out.printf("\n%s phones in list #3:\n", phs3.size());
		for(SmartPhone phone : phs3) {
			out.printf("%s %s %s\n",phone.getBrand(),phone.getPrice(),phone.getScreenSize());
		}
	}
}