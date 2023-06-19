import java.util.*;

public class Transport {
	public static void main(String[] args) {

	Bus b = new Bus();
	b.maxSpeed = 500.4;
	System.out.println(b.toString() + b.maxSpeed);

	}

	public interface commercial {}
	public interface personal {}

	public interface land {
		
	}
	public interface air {}
	public interface sea {}

	



}

class Bus implements Transport.land, Transport.commercial {
	double maxSpeed = 0.0;
}