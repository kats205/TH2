package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_1 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận
        int[][] matrix = MatrixUtils.inputMatrix();

        // 2. In ma trận vừa nhập
        MatrixUtils.printMatrix(matrix, "Ma trận vừa nhập:");

        // 3. Tìm số nguyên tố lớn thứ 2
        System.out.println("\n1. Số nguyên tố lớn thứ 2: " + findSecondLargestPrime(matrix));

        // 4. Tính tổng hàng
        System.out.print("\n2. Nhập chỉ số hàng để tính tổng (0-" + (matrix.length - 1) + "): ");
        int rowIndex = scanner.nextInt();
        System.out.println("Tổng hàng " + rowIndex + ": " + sumRow(matrix, rowIndex));
        System.out.println();

        // 5. Thay thế phần tử biên bị thiếu
        replaceMissingBorderElements(matrix);
        MatrixUtils.printMatrix(matrix, "3. Ma trận sau khi thay thế phần tử biên:");
    }

    // Tìm số nguyên tố lớn thứ 2
    private static String findSecondLargestPrime(int[][] matrix) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int num : row) {
                if (isPrime(num)) {
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

    // Tính tổng các phần tử trên hàng
    private static int sumRow(int[][] matrix, int rowIndex) {
        int sum = 0;
        for (int num : matrix[rowIndex]) {
            sum += num;
        }
        return sum;
    }

    // Thay thế phần tử biên bị thiếu
    private static void replaceMissingBorderElements(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Các hàng
        for (int i = 0; i < rows; i++) {
            // Cột đầu tiên và cuối cùng
            if (matrix[i][0] == -1) matrix[i][0] = findMinimalBorderElement(matrix, i, 0);
            if (matrix[i][cols - 1] == -1) matrix[i][cols - 1] = findMinimalBorderElement(matrix, i, cols - 1);
        }

        // Các cột
        for (int j = 0; j < cols; j++) {
            // Hàng đầu tiên và cuối cùng
            if (matrix[0][j] == -1) matrix[0][j] = findMinimalBorderElement(matrix, 0, j);
            if (matrix[rows - 1][j] == -1) matrix[rows - 1][j] = findMinimalBorderElement(matrix, rows - 1, j);
        }
    }

    // Tìm phần tử biên nhỏ nhất
    private static int findMinimalBorderElement(int[][] matrix, int row, int col) {
        int minElement = Integer.MAX_VALUE;

        // Kiểm tra các hàng lân cận
        for (int i = Math.max(0, row - 1); i <= Math.min(matrix.length - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(matrix[0].length - 1, col + 1); j++) {
                // Bỏ qua phần tử hiện tại và các phần tử -1
                if ((i != row || j != col) && matrix[i][j] != -1) {
                    minElement = Math.min(minElement, matrix[i][j]);
                }
            }
        }

        // Nếu không tìm thấy phần tử nào, trả về 0
        return minElement == Integer.MAX_VALUE ? 0 : minElement;
    }

    // Kiểm tra số nguyên tố
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}