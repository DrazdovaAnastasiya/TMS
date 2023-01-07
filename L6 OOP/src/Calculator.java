public class Calculator {

    double calculate () {

        Reader reader = new Reader();
        Writer writer = new Writer();

            while (true) {

                writer.write("Write the first value: ");
                double num1 = reader.readNumber();

                writer.write("Write the second value: ");
                double num2 = reader.readNumber();

                writer.write("Write the desired action (sum, sub, mul, div): ");
                String type = reader.readStr();

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
                        writer.write("Operation not found!");
                        continue;
                }
                writer.write("Result: " + result);
                writer.write("\nWould you like to continue? (yes/no) ");
                String next = reader.readStr();

                switch (next) {
                    case "yes":
                        break;
                    case "no":
                        writer.write("Bye!");

                        return (result);
                }

            }


    }

}
