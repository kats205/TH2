package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_6 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận ký tự
        char[][] matrix = inputCharMatrix();

        // 2. In ma trận vừa nhập
        printCharMatrix(matrix, "1. Ma trận vừa nhập:");

        // 3. Đếm số lượng ký tự số
        System.out.println("\n2. Số lượng ký tự số: " + countDigits(matrix));

        // 4. Chuyển chữ thường sang chữ hoa trên một cột
        System.out.print("\n3. Nhập chỉ số cột để chuyển sang chữ hoa: ");
        int colIndex = scanner.nextInt();
        convertColumnToUppercase(matrix, colIndex);
        printCharMatrix(matrix, "Ma trận sau khi chuyển:");

        // 5. Tìm ký tự xuất hiện nhiều nhất trên 2 đường chéo
        System.out.println("\n4. Ký tự xuất hiện nhiều nhất trên 2 đường chéo: " + findMostFrequentOnDiagonals(matrix));
    }

    // Nhập ma trận ký tự
    private char[][] inputCharMatrix() {
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        char[][] matrix = new char[rows][cols];

        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        return matrix;
    }

    // In ma trận ký tự
    private void printCharMatrix(char[][] matrix, String title) {
        System.out.println(title);
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // Đếm số lượng ký tự số
    private static int countDigits(char[][] matrix) {
        int count = 0;
        for (char[] row : matrix) {
            for (char c : row) {
                if (Character.isDigit(c)) {
                    count++;
                }
            }
        }
        return count;
    }

    // Chuyển tất cả ký tự chữ viết thường trên một cột sang chữ hoa
    private static void convertColumnToUppercase(char[][] matrix, int colIndex) {
        for (int i = 0; i < matrix.length; i++) {
            if (Character.isLowerCase(matrix[i][colIndex])) {
                matrix[i][colIndex] = Character.toUpperCase(matrix[i][colIndex]);
            }
        }
    }

    // Tìm ký tự xuất hiện nhiều nhất trên 2 đường chéo
    private static char findMostFrequentOnDiagonals(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Mảng để đếm số lần xuất hiện của từng ký tự
        int[] charCount = new int[256]; // Giả sử là ký tự ASCII

        // Đường chéo chính
        for (int i = 0; i < Math.min(rows, cols); i++) {
            charCount[matrix[i][i]]++;
        }

        // Đường chéo phụ
        for (int i = 0; i < Math.min(rows, cols); i++) {
            charCount[matrix[i][cols - 1 - i]]++;
        }

        // Tìm ký tự xuất hiện nhiều nhất
        int maxCount = 0;
        char mostFrequent = ' ';
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > maxCount) {
                maxCount = charCount[i];
                mostFrequent = (char) i;
            }
        }

        return mostFrequent;
    }
}