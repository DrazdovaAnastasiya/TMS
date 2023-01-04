public class Main {
    public static void main(String[] args) {

//        1. Создать дв. массив и проин. его числами от 1 до 100

        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int value = i * 10 + j + 1;
                matrix[i][j] = value;
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
        System.out.println();

//        2. Проин. массив 1 в ввиде треугольника
//           [1,0,0,0,0]
//           [1,1,0,0,0]
//           [1,1,1,0,0]
//           [1,1,1,1,1]

        int[][] matrix2 = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                int value = 0;
                if (j <= i) {
                    value = 1;
                }
                matrix2[i][j] = value;
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
        System.out.println();

//        3. Реализовать удобный вывод тругольника
//        1
//        11
//        111
//        1111

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix2[i][j] > 0) {
                    System.out.printf("%2d ", matrix2[i][j]);
                }
            }
            System.out.println();

        }
    }
}