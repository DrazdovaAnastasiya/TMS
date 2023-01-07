public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Writer writer = new Writer();

        double result = calculator.calculate();
        writer.write("\nYour result: " + result);

        Arrays1 array = new Arrays1();
        int[] arr = {54, 5, 638, -7, 74, -45, -931, 11, 121, 1234554321};
        array.maxMin(arr);
        array.evenOdd(arr);
        array.lengthShort(arr);
        array.sort(arr);
        array.palindrome(arr);

        Arrays2 array2 = new Arrays2();
        array2.array100();
        array2.arrTriangle();
        array2.arrTriangle1();

    }
}