import java.util.*; import java.io.*;
import static java.lang.System.*;

public class Calculator {
public static void main(String[] args) throws IOException {

    /* String request[] = new String[2];
    try { request = readFile("D:\\temp\\input.txt").split(" "); }
    catch (IOException ex) { System.out.println(ex.getMessage()); }
    oldWays(request); */

    File file = new File("D:\\temp\\input.txt");
    reportFile(file);

    // String request[] = {"2", "*", "2"};
    // oldWays(request);


    } // Конец метода main

public static void reportFile (File inputFile) throws IOException {
    FileReader fr = new FileReader(inputFile);
    Scanner sc = new Scanner(fr);
    String sample = "";
    
    String result = "\n";
    File outputFile = new File("D:\\temp\\output.txt");
    FileWriter fw = new FileWriter (outputFile, true); 
    while (sc.hasNextLine()) {
        sample = sc.nextLine() + " = ";
        fw.write(sample);

        fw.write(oldWays(sample) + result);
        }
    sc.close();
    fr.close();
    fw.close();
    }
public static void writeFile(double d) throws IOException {
    File fileOut = new File("D:\\temp\\output.txt");
    FileWriter fw = new FileWriter (fileOut);
    String outcome = "" + d;
    fw.write(outcome);
    fw.close();
    }
public static String readFile(String path) throws IOException {
    FileReader fr = new FileReader(path);
    Scanner scanf = new Scanner(fr);
    String s = scanf.nextLine();
    while (scanf.hasNextLine()) s = scanf.nextLine();
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
public static String oldWays (String input) {
    String request[] = new String[2];
    request = input.split(" ");
    int state = 0;
    double whatIsFor = 0.0;
    boolean isNumbers = false;
    boolean isOperable = false;
    if (isNumerical(request[0]) && isNumerical(request[2]))
        {
        isNumbers = true;
        if (checkOperation(request)) isOperable = true;
        else state = 2;
        }
    else state = 1;    
    if (isOperable && isNumbers) {
        try {
            double sarg = Double.parseDouble(request[2]);
            if (request[1].equals("/") && sarg == 0) {
                state = 3;
                throw new Exception("Error! Division by zero");
            }
            else {  whatIsFor = calculate(request);
                    state = 4;} }
        catch (Exception ex) {System.out.println(ex.getMessage());}
        }
    //try { writeFile(whatIsFor); }
    //catch (IOException ex2) { System.out.println(ex2.getMessage()); }
    
    switch (state) {
        case (1): return "Error! Not number";
        case (2): return "Operation Error!";
        case (3): return "Error! Division by zero";
        case (4): return "" + whatIsFor;  
        default: return "";
      }
    }
public static String[] inputString(String s) { // Незавершено!
    // Scanner sc = new Scanner(in);
    // String request[] = sc.nextLine().split(" ");
    // sc.close();
    return null;
    } 
}