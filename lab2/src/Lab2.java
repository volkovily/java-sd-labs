public class Lab2 {
    // C5 = 3; C7 = 2; C11 = 8;
    public static void main(String[] args) {
        try {
            short[][] matrixA = {
                    {1, 2, 3},
                    {2, 3, 1}
            };
            short[][] matrixB = {
                    {1, 6},
                    {0, 1}
            };

            if (isWrongMatrix(matrixA) || isWrongMatrix(matrixB)) {
                return;
            }

            short[][] resultMatrix = performDirectSum(matrixA, matrixB);
            System.out.println("C = A ⊕ B:");
            printMatrix(resultMatrix);

            System.out.println("\nAverage value of elements in each row of matrix C:");
            findRowAverage(resultMatrix);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static short[][] performDirectSum(short[][] matrixA, short[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        short[][] resultMatrix = new short[rowsA + rowsB][colsA + colsB];

        for (int i = 0; i < rowsA; i++) {
            System.arraycopy(matrixA[i], 0, resultMatrix[i], 0, colsA);
        }

        for (int i = 0; i < rowsB; i++) {
//            System.arraycopy(matrixB[i], 0, resultMatrix[i + rowsA], colsA, colsB);
            for (int j = 0; j < colsB; j++) {
                resultMatrix[i + rowsA][j + colsA] = matrixB[i][j];
            }
        }

        return resultMatrix;
    }

    private static void findRowAverage(short[][] matrix) {
        for (short[] row : matrix) {
            double rowSum = 0;
            for (short element : row) {
                rowSum += element;
            }
            double rowAverage = rowSum / row.length;
            System.out.println(rowAverage);
        }
    }

    private static boolean isWrongMatrix(short[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.err.println("Error: Empty matrix");
            return true;
        }

        int rowLength = matrix[0].length;

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != rowLength) {
                throw new IllegalArgumentException("Error: Invalid matrix. Number of elements in rows are not the same");

            }
        }

        return false;
    }

    private static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            for (short element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}