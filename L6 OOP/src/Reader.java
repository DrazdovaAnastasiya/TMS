import java.util.Scanner;

public class Reader {

        Scanner scanner = new Scanner(System.in);

        double readNumber(){
            return scanner.nextDouble();
        }


        String readStr(){
            return scanner.next();
        }



}

