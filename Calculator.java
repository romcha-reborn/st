import java.util.*;
import static java.lang.System.*;

public class Calculator {
public static void main(String[] args) {
    Scanner sc = new Scanner(in);
    String request[] = sc.nextLine().split(" ");
    sc.close();
    boolean isNumbers = false;
    boolean isOperable = false;
    if (isNumerical(request[0]) && isNumerical(request[2]))
        {
        isNumbers = true;
        if (checkOperation(request)) isOperable = true;
        }
    if (isOperable && isNumbers) {
        try {
            double sarg = Double.parseDouble(request[2]);
            if (request[1].equals("/") && sarg == 0) throw new Exception("Error! Division by zero");
            else System.out.print(calculate(request));
            }
        catch (Exception ex)
            {
            System.out.println(ex.getMessage());
            }
        }
    }
public static double calculate(String[] request) {
    double farg = Double.parseDouble(request[0]); 
    double sarg = Double.parseDouble(request[2]);
    double result = 0.0;
    if (request[1].equals("+")) result = farg + sarg;
    if (request[1].equals("-")) result = farg - sarg;
    if (request[1].equals("*")) result = farg * sarg;
    if (request[1].equals("/")) result = farg / sarg;
    return result;
    }
public static boolean checkOperation(String[] array) {
    boolean b = false;
    String s = array[1];
    if (s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")) b = true;
    if (!b) System.out.print("Operation Error!");
    return b;
    }
public static boolean isNumerical(String a) {
    try {
        Double.parseDouble(a);
        return true;
    } catch(NumberFormatException e){
        System.out.print("Error! Not number");
        return false;
        }
    }    
}