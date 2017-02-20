/**
 * Created by Rachel Stowell on 8/31/2016.
 */
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;

public class CPS315assignment1 {

    public static void main(String[] args) {
        System.out.print("Hello! This is a postfix expression calculator.");
        String fileName = "testing.dat";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while( (line = br.readLine()) != null){
                System.out.println("The value of " + line + " is " + evaluate(line));
            }
        }
        catch (IOException e){
            System.out.println("Error reading file");
        }
        System.out.print("Bye-bye!");
    }

    public static double evaluate(String line) throws IOException{
        Scanner scan = new Scanner(line);
        Stack<Double> numbers = new Stack<Double>();
        String next;
        Double a, b;
        Double zero = new Double(0);

        while (scan.hasNext()) {
            if (scan.hasNext(UNSIGNED_DOUBLE)) {
                next = scan.findInLine(UNSIGNED_DOUBLE);
                numbers.push(new Double(next));
            } else {
                next = scan.findInLine(CHARACTER);
                switch (next.charAt(0)) {
                    case '+':
                        a = numbers.pop();
                        b = numbers.pop();
                        numbers.push(a + b);
                        break;
                    case '-':
                        a = numbers.pop();
                        b = numbers.pop();
                        numbers.push(b - a);
                        break;
                    case '*':
                        a = numbers.pop();
                        b = numbers.pop();
                        numbers.push(a * b);
                        break;
                    case '/':
                        a = numbers.pop();
                        b = numbers.pop();
                        if (a == zero){
                            throw new IllegalArgumentException("Cannot divide by 0");
                        }
                        numbers.push(b / a);
                        break;
                    case '_':
                        a = numbers.pop();
                        numbers.push(a * (-1));
                        break;
                    case '#':
                        a = numbers.pop();
                        if ( a < 0) {
                            throw new IllegalArgumentException("Error: Square root of negative number");
                        }
                        numbers.push(Math.sqrt(a));
                        break;
                    case '^':
                        a = numbers.pop();
                        b = numbers.pop();
                        numbers.push(Math.pow(b, a));
                        break;
                    default :
                        throw new IllegalArgumentException("Illegal character");

                }


            }

        }
        return numbers.pop();

    }
    public static final Pattern CHARACTER =
            Pattern.compile("\\S.*?");
    public static final Pattern UNSIGNED_DOUBLE =
            Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
}

