import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Write the first value:");
            Double num1 = scanner.nextDouble();

            System.out.println("Write the second value:");
            Double num2 = scanner.nextDouble();

            System.out.println("Write the desired action (sum, sub, mul, div):");
            String type = scanner.next();

            double result;
            switch (type) {
                case "sum":
                    result = num1 + num2;
                    break;
                case "sub":
                    result = num1 - num2;
                    break;
                case "mul":
                    result = num1 * num2;
                    break;
                case "div":
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Operation not found!");
                    continue;
            }

            System.out.println("Result: " + result);
            System.out.println("Would you like to continue? (yes/no)");
            String next = scanner.next();

            switch (next) {
                case "yes":
                    break;
                case "no":
                    System.out.println("Bye!");
                    return;
            }

        }

    }
}
