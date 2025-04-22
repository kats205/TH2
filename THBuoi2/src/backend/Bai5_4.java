package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_4 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận
        int[][] matrix = MatrixUtils.inputMatrix();

        // 2. In ma trận vừa nhập
        MatrixUtils.printMatrix(matrix, "1. Ma trận vừa nhập:");

        // 3. Tìm phần tử biên lớn thứ 2
        System.out.println("\n2. Phần tử biên lớn thứ 2: " + findSecondLargestBorderElement(matrix));

        // 4. Tìm phần tử biên nhỏ nhất
        System.out.println("\n3. Phần tử biên nhỏ nhất: " + findSmallestBorderElement(matrix));

        // 5. Thay thế phần tử bị thiếu bằng phần tử lớn nhất trên đường chéo chính
        replaceMissingElementsWithMainDiagonalMax(matrix);
        MatrixUtils.printMatrix(matrix, "4. Ma trận sau khi thay thế:");
    }

    // Tìm phần tử biên lớn thứ 2
    private static String findSecondLargestBorderElement(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Duyệt các phần tử biên
        for (int i = 0; i < rows; i++) {
            // Cột đầu và cuối của hàng đầu và cuối
            int[] borderElements = {
                    matrix[i][0],                 // Cột đầu
                    matrix[i][cols - 1],           // Cột cuối
                    (i == 0 || i == rows - 1) ? matrix[i][0] : Integer.MIN_VALUE,   // Hàng đầu tiên
                    (i == 0 || i == rows - 1) ? matrix[i][cols - 1] : Integer.MIN_VALUE   // Hàng cuối cùng
            };

            for (int num : borderElements) {
                if (num != Integer.MIN_VALUE) {
                    if (num > largest) {
                        secondLargest = largest;
                        largest = num;
                    } else if (num > secondLargest && num != largest) {
                        secondLargest = num;
                    }
                }
            }
        }

        return secondLargest == Integer.MIN_VALUE ? "rỗng" : String.valueOf(secondLargest);
    }

    // Tìm phần tử biên nhỏ nhất
    private static int findSmallestBorderElement(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int smallest = Integer.MAX_VALUE;

        // Duyệt các phần tử biên
        for (int i = 0; i < rows; i++) {
            // Cột đầu và cuối
            smallest = Math.min(smallest, matrix[i][0]);
            smallest = Math.min(smallest, matrix[i][cols - 1]);
        }

        // Hàng đầu và cuối
        for (int j = 0; j < cols; j++) {
            smallest = Math.min(smallest, matrix[0][j]);
            smallest = Math.min(smallest, matrix[rows - 1][j]);
        }

        return smallest;
    }

    // Thay thế các phần tử bị thiếu bằng phần tử lớn nhất trên đường chéo chính
    private static void replaceMissingElementsWithMainDiagonalMax(int[][] matrix) {
        // Tìm phần tử lớn nhất trên đường chéo chính
        int mainDiagonalMax = findMainDiagonalMax(matrix);

        // Thay thế các phần tử -1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = mainDiagonalMax;
                }
            }
        }
    }

    // Tìm phần tử lớn nhất trên đường chéo chính
    private static int findMainDiagonalMax(int[][] matrix) {
        int maxElement = Integer.MIN_VALUE;
        int diagonalLength = Math.min(matrix.length, matrix[0].length);

        for (int i = 0; i < diagonalLength; i++) {
            maxElement = Math.max(maxElement, matrix[i][i]);
        }

        return maxElement == Integer.MIN_VALUE ? 0 : maxElement;
    }
}