import java.util.Scanner;

public class ConsoleReader implements Reader{

        private Scanner scanner = new Scanner(System.in);

        public double readNumber() {
            return scanner.nextDouble();
        }

        public int readIntNumber() {return scanner.nextInt();}

        public String readOperationType() {
            return scanner.next();
        }
    }

