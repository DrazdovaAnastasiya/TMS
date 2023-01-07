public class Arrays2 {

    Writer writer = new Writer();
    void array100() {

        int[][] matrix = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int value = i * 10 + j + 1;
                matrix[i][j] = value;
                writer.writeF(value);
            }
            writer.writeNewLine();
        }
        writer.writeNewLine();
    }

    void arrTriangle () {

        int[][] matrix2 = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (j <= i) {
                    matrix2[i][j] = 1;
                }
                writer.writeF(matrix2[i][j]);
            }
            writer.writeNewLine();
        }
        writer.writeNewLine();
    }

    void arrTriangle1 (){

        int[][] matrix2 = new int[4][5];
        for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (j <= i) {
                        matrix2[i][j] = 1;
                    }
                    if (matrix2[i][j] > 0) {
                        writer.writeF(matrix2[i][j]);
                    }
                }
                writer.writeNewLine();

        }
    }
}
