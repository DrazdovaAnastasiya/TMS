import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Arrays1 {

    Writer writer = new Writer();

         void maxMin(int[] arr) {

             IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();

             writer.write("\nMin element is " + stats.getMin());
             writer.write("\nMax element is " + stats.getMax());
         }

         void evenOdd(int[] arr) {

             writer.write("\nEven numbers: ");

             for (int j : arr) {
                 if (j % 2 == 0) {
                     writer.write(j + " ");
                 }
             }

             writer.write("\nOdd numbers: ");

             for (int j : arr) {
                 if (j % 2 != 0) {
                     writer.write(j + " ");
                 }
             }
         }

         void lengthShort (int[] arr) {

             int maxLength = 0;
             for (int i = 0; i < arr.length; i++) {
                 int elementLength = Integer.toString(Math.abs(arr[i])).length();
                 if (elementLength > maxLength) {
                     maxLength = elementLength;
                 }
             }

             writer.write("\nThe longest number is ");
             for (int j : arr) {
                 int elementLength = Integer.toString(Math.abs(j)).length();
                 if (maxLength == elementLength) {
                     writer.write(j + " ");
                 }
             }

             writer.write("\nThe shortest number is ");
             int minLength = 1;
             for (int j : arr) {
                 int elementLength = Integer.toString(Math.abs(j)).length();
                 if (minLength == elementLength) {
                     writer.write(j + " ");
                 }
             }
         }

         void sort (int[] arr) {

             writer.write("\nNumbers in ascending order: ");

             for (int i = 0; i < arr.length; i++) {
                 if (i < (arr.length - 1) && arr[i] < arr[i + 1]) {
                     writer.write(arr[i] + ", ");
                 } else if (i >= 1 && arr[i - 1] < arr[i]) {
                     writer.writeInt(arr[i]);
                 }
             }
         }

         void palindrome (int[] arr){

             writer.write("\nPalindromes: ");

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
                    writer.write(j + " ");
                }
            }
            writer.writeNewLine();
        }

}
