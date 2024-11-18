import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static boolean check_input(String input){
        String regex = "^([1-9]|10) [-+*/] ([1-9]|10)$";
        Pattern pattern = Pattern.compile(regex);

        if(!pattern.matcher(input).matches())
            throw new ArithmeticException("Выражение не является корректным!");

        return true;
    }

    public static String calc(String input){
        String[] input_args = input.split(" ");
        int a = Integer.parseInt(input_args[0]),
                b = Integer.parseInt(input_args[2]),
                res = Integer.MIN_VALUE;

        switch (input_args[1]){
            case ("+"):
                res = a + b;
                break;
            case ("-"):
                res = a - b;
                break;
            case ("*"):
                res = a * b;
                break;
            case ("/"):
                res = a / b;
                break;
        }

        return Integer.toString(res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();

        if(check_input(input))
            System.out.println(calc(input));
    }
}