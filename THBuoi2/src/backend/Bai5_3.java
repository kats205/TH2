package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_3 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận
        int[][] matrix = MatrixUtils.inputMatrix();

        // 2. In ma trận vừa nhập
        MatrixUtils.printMatrix(matrix, "1. Ma trận vừa nhập:");

        // 3. Tìm số lẻ lớn thứ 2
        System.out.println("\n2. Số lẻ lớn thứ 2: " + findSecondLargestOdd(matrix));

        // 4. Tìm phần tử lớn nhất trên 2 đường chéo
        System.out.println("\n3. Phần tử lớn nhất trên 2 đường chéo: " + findLargestOnDiagonals(matrix));

        // 5. Thay thế phần tử bị thiếu trên cột
        System.out.print("\n4. Nhập chỉ số cột để thay thế: ");
        int colIndex = scanner.nextInt();
        replaceMissingElementsInColumn(matrix, colIndex);
        MatrixUtils.printMatrix(matrix, "Ma trận sau khi thay thế:");
    }

    // Tìm số lẻ lớn thứ 2
    private static String findSecondLargestOdd(int[][] matrix) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num % 2 != 0) {
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

    // Tìm phần tử lớn nhất trên 2 đường chéo
    private static int findLargestOnDiagonals(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int largestElement = Integer.MIN_VALUE;

        // Đường chéo chính
        for (int i = 0; i < Math.min(rows, cols); i++) {
            largestElement = Math.max(largestElement, matrix[i][i]);
        }

        // Đường chéo phụ
        for (int i = 0; i < Math.min(rows, cols); i++) {
            largestElement = Math.max(largestElement, matrix[i][cols - 1 - i]);
        }

        return largestElement;
    }

    // Thay thế các phần tử bị thiếu trên cột
    private static void replaceMissingElementsInColumn(int[][] matrix, int colIndex) {
        // Tìm phần tử lớn nhất trên cột
        int maxElement = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (row[colIndex] != -1) {
                maxElement = Math.max(maxElement, row[colIndex]);
            }
        }

        // Nếu không tìm thấy phần tử nào, dùng 0
        if (maxElement == Integer.MIN_VALUE) {
            maxElement = 0;
        }

        // Thay thế các phần tử -1
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][colIndex] == -1) {
                matrix[i][colIndex] = maxElement;
            }
        }
    }
}