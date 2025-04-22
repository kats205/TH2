package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_5 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận
        int[][] matrix = MatrixUtils.inputMatrix();

        // 2. In ma trận vừa nhập
        MatrixUtils.printMatrix(matrix, "1. Ma trận vừa nhập:");

        // 3. Tìm phần tử lớn thứ 2 trên 2 đường chéo
        System.out.println("\n2. Phần tử lớn thứ 2 trên 2 đường chéo: " + findSecondLargestOnDiagonals(matrix));

        // 4. Tính tổng các phần tử trên 2 đường chéo
        System.out.println("\n3. Tổng các phần tử trên 2 đường chéo: " + sumOfDiagonals(matrix));

        // 5. Thay thế phần tử biên bị thiếu bằng giá trị biên lớn nhất
        replaceMissingBorderWithLargestBorder(matrix);
        MatrixUtils.printMatrix(matrix, "4. Ma trận sau khi thay thế:");
    }

    // Tìm phần tử lớn thứ 2 trên 2 đường chéo
    private static String findSecondLargestOnDiagonals(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Đường chéo chính
        for (int i = 0; i < Math.min(rows, cols); i++) {
            int num = matrix[i][i];
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        // Đường chéo phụ
        for (int i = 0; i < Math.min(rows, cols); i++) {
            int num = matrix[i][cols - 1 - i];
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest == Integer.MIN_VALUE ? "rỗng" : String.valueOf(secondLargest);
    }

    // Tính tổng các phần tử trên 2 đường chéo
    private static int sumOfDiagonals(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sum = 0;

        // Đường chéo chính
        for (int i = 0; i < Math.min(rows, cols); i++) {
            sum += matrix[i][i];
        }

        // Đường chéo phụ (trừ điểm giao nếu ma trận có số lẻ)
        for (int i = 0; i < Math.min(rows, cols); i++) {
            if (i != rows - 1 - i) {
                sum += matrix[i][cols - 1 - i];
            }
        }

        return sum;
    }

    // Thay thế phần tử biên bị thiếu bằng giá trị biên lớn nhất
    private static void replaceMissingBorderWithLargestBorder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int largestBorder = findLargestBorderElement(matrix);

        // Hàng đầu và cuối
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == -1) matrix[0][j] = largestBorder;
            if (matrix[rows - 1][j] == -1) matrix[rows - 1][j] = largestBorder;
        }

        // Cột đầu và cuối
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == -1) matrix[i][0] = largestBorder;
            if (matrix[i][cols - 1] == -1) matrix[i][cols - 1] = largestBorder;
        }
    }

    // Tìm phần tử biên lớn nhất
    private static int findLargestBorderElement(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int largest = Integer.MIN_VALUE;

        // Hàng đầu và cuối
        for (int j = 0; j < cols; j++) {
            largest = Math.max(largest, matrix[0][j]);
            largest = Math.max(largest, matrix[rows - 1][j]);
        }

        // Cột đầu và cuối
        for (int i = 0; i < rows; i++) {
            largest = Math.max(largest, matrix[i][0]);
            largest = Math.max(largest, matrix[i][cols - 1]);
        }

        return largest;
    }
}