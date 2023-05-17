package week10;
import static java.lang.System.out;

public class SmartPhone extends Phone {
	private double price, screenSize;

	SmartPhone(String brand, double price, double screenSize){
		super(brand);
		this.price=price;
		this.screenSize=screenSize;
	}
	// code omitted for cheapest phone section (first section of output)
	public void displayInfo() {
		out.printf("Phone brand  %s\n", getBrand());
		out.printf("Price tag    %s\n", price);
		out.printf("Screen size  %s\n", screenSize);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}


}
