import java.util.Arrays;
import java.util.IntSummaryStatistics;
public class Main {
    public static void main(String[] args) {

        int[] arr = {54, 5, 638, -7, 74, -45, -931, 11, 121, 1234554321};

//        1. Вывести макс и мин числа

        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();

        System.out.println("Min element is " + stats.getMin());
        System.out.println("Max element is " + stats.getMax());

//        2. Вывести чет и не чет числа

        System.out.print("Even numbers: ");

        for (int j : arr) {
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }

        System.out.print("\nOdd numbers: ");

        for (int j : arr) {
            if (j % 2 != 0) {
                System.out.print(j + " ");
            }
        }

//        3. Вывести самое длинное и короткое число

        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int elementLength = Integer.toString(Math.abs(arr[i])).length();
            if (elementLength > maxLength) {
                maxLength = elementLength;
            }
        }

        System.out.print("\nThe longest number is ");
        for (int j : arr) {
            int elementLength = Integer.toString(Math.abs(j)).length();
            if (maxLength == elementLength) {
                System.out.print(j + " ");
            }
        }

        System.out.print("\nThe shortest number is ");
        int minLength = 1;
        for (int j : arr) {
            int elementLength = Integer.toString(Math.abs(j)).length();
            if (minLength == elementLength) {
                System.out.print(j + " ");
            }
        }

//        4. Выводить только те числа которые идут в порядке возрастания

        System.out.println("\nNumbers in ascending order: ");

        for (int i = 0; i < arr.length; i++) {
            if (i < (arr.length - 1) && arr[i] < arr[i + 1]) {
                System.out.print(arr[i] + ", ");
            } else if (i >= 1 && arr[i - 1] < arr[i]) {
                System.out.println(arr[i]);
            }
        }

//        5. Вывести все числа палиндромы в массиве

       System.out.print("Palindromes: ");
        for (int j : arr) {
            String str = Integer.toString(Math.abs(j));
            if (str.length() == 1) {
                continue;
            }
            boolean isPalindrome = false;
            for (int i = 0; i <= (str.length() / 2); i++) {
                if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                System.out.print(j + " ");
            }
        }
    }
}