import java.util.*;

public class Transport {
	public static void main(String[] args) {

try{
    int[] numbers = new int[3];
    numbers[4]=45;
    System.out.println(numbers[4]);
}
catch(Exception ex){
    int i = 4;
    System.out.println("Chhose correct index between 0 and " + 3);
    Scanner sc = new Scanner(System.in);
    while (i < 0 || i > 3) i = sc.nextInt();
}
System.out.println("Программа завершена");


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