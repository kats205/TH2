package utils;

import java.util.Scanner;

public class MatrixUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int[][] inputMatrix() {
        System.out.println("--------------------------------------------");
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();
        System.out.println("--------------------------------------------");

        int[][] matrix = new int[rows][cols];

        System.out.println("\n--------------------------------------------");
        System.out.println("***hập các phần tử của ma trận***");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Nhập phần tử tại vị trí [%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("--------------------------------------------\n");
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Ma trận rỗng.");
            return;
        }

        System.out.println("Ma trận:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Nạp chồng để in ma trận với tiêu đề tùy chọn
    public static void printMatrix(int[][] matrix, String title) {
        System.out.println(title);
        printMatrix(matrix);
    }
}