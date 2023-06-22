import java.util.*; import java.io.*;
import static java.lang.System.*;

public class Calculator {
public static void main(String[] args) throws IOException {
    // Scanner sc = new Scanner(in);
    // String request[] = sc.nextLine().split(" ");
    // sc.close();

    String request[] = new String[2];

    try {
        request = readFile("D:\\temp\\text.txt").split(" ");
    } catch (IOException ex) 
        {
        System.out.println(ex.getMessage());
        }

    double whatIsFor = 0.0;
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
            else 
                {whatIsFor = calculate(request); System.out.println(whatIsFor);}
            }
        catch (Exception ex)
            {
            System.out.println(ex.getMessage());
            }
        }
    
    try {writeFile(whatIsFor);}
    catch (IOException ex2) {System.out.println(ex2.getMessage());} 


    } // Конец метода main

public static void writeFile(double d) throws IOException {
    FileWriter fw = new FileWriter ("D:\\temp\\output.txt");
    String outcome = "" + d;
    fw.write(outcome);
    fw.close();
    }
public static String readFile(String path) throws IOException {
    FileReader fr = new FileReader(path);
    Scanner scanf = new Scanner(fr);
    String s = scanf.nextLine();
    fr.close();
    return s;
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