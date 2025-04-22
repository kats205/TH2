package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_2 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận
        int[][] matrix = MatrixUtils.inputMatrix();

        // 2. In ma trận vừa nhập
        MatrixUtils.printMatrix(matrix, "Ma trận vừa nhập:");

        // 3. Tìm số chẵn lớn thứ 2
        System.out.println("\n1. Số chẵn lớn thứ 2: " + findSecondLargestEven(matrix));

        // 4. Tính tổng cột
        System.out.print("\n2. Nhập chỉ số cột để tính tổng (0-" + (matrix.length - 1) + "): ");
        int colIndex = scanner.nextInt();
        System.out.println("Tổng cột " + colIndex + ": " + sumColumn(matrix, colIndex));

        // 5. Thay thế phần tử bị thiếu trên hàng
        System.out.print("\n3. Nhập chỉ số hàng để thay thế (0-" + (matrix.length - 1) + "): ");
        int rowIndex = scanner.nextInt();
        replaceMissingElementsInRow(matrix, rowIndex);
        MatrixUtils.printMatrix(matrix, "Ma trận sau khi thay thế:");
    }

    // Tìm số chẵn lớn thứ 2
    private static String findSecondLargestEven(int[][] matrix) {
        int largest = -1;
        int secondLargest = -1;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num % 2 == 0) {
                    if (num > largest) {
                        secondLargest = largest;
                        largest = num;
                    } else if (num > secondLargest && num != largest) {
                        secondLargest = num;
                    }
                }
            }
        }

        return secondLargest == -1 ? "rỗng" : String.valueOf(secondLargest);
    }

    // Tính tổng các phần tử trên cột
    private static int sumColumn(int[][] matrix, int colIndex) {
        int sum = 0;
        for (int[] row : matrix) {
            sum += row[colIndex];
        }
        return sum;
    }

    // Thay thế các phần tử bị thiếu trên một hàng
    private static void replaceMissingElementsInRow(int[][] matrix, int rowIndex) {
        int minElement = Integer.MAX_VALUE;

        // Tìm phần tử nhỏ nhất khác -1
        for (int num : matrix[rowIndex]) {
            if (num != -1) {
                minElement = Math.min(minElement, num);
            }
        }

        // Nếu không tìm thấy phần tử nào, dùng 0
        if (minElement == Integer.MAX_VALUE) {
            minElement = 0;
        }

        // Thay thế các phần tử -1
        for (int j = 0; j < matrix[rowIndex].length; j++) {
            if (matrix[rowIndex][j] == -1) {
                matrix[rowIndex][j] = minElement;
            }
        }
    }
}