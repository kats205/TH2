package backend;

import java.util.Scanner;
import utils.MatrixUtils;

public class Bai5_7 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // 1. Nhập ma trận ký tự
        char[][] matrix = inputCharMatrix();

        // 2. In ma trận vừa nhập
        printCharMatrix(matrix, "1. Ma trận vừa nhập:");

        // 3. Đếm số lượng ký tự chữ viết hoa
        System.out.println("\n2. Số lượng ký tự chữ viết hoa: " + countUppercaseChars(matrix));

        // 4. Chuyển chữ thường sang chữ hoa trên một hàng
        System.out.print("\n3. Nhập chỉ số hàng để chuyển sang chữ hoa: ");
        int rowIndex = scanner.nextInt();
        convertRowToUppercase(matrix, rowIndex);
        printCharMatrix(matrix, "Ma trận sau khi chuyển:");

        // 5. Tìm ký tự xuất hiện nhiều nhất ở biên
        System.out.println("\n4. Ký tự xuất hiện nhiều nhất ở biên: " + findMostFrequentBorderChar(matrix));
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

    // Đếm số lượng ký tự chữ viết hoa
    private static int countUppercaseChars(char[][] matrix) {
        int count = 0;
        for (char[] row : matrix) {
            for (char c : row) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
        }
        return count;
    }

    // Chuyển tất cả ký tự chữ viết thường trên một hàng sang chữ hoa
    private static void convertRowToUppercase(char[][] matrix, int rowIndex) {
        for (int j = 0; j < matrix[rowIndex].length; j++) {
            if (Character.isLowerCase(matrix[rowIndex][j])) {
                matrix[rowIndex][j] = Character.toUpperCase(matrix[rowIndex][j]);
            }
        }
    }

    // Tìm ký tự xuất hiện nhiều nhất ở biên
    private static char findMostFrequentBorderChar(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Mảng để đếm số lần xuất hiện của từng ký tự
        int[] charCount = new int[256]; // Giả sử là ký tự ASCII

        // Hàng đầu và cuối
        for (int j = 0; j < cols; j++) {
            charCount[matrix[0][j]]++;
            charCount[matrix[rows - 1][j]]++;
        }

        // Cột đầu và cuối (loại trừ các điểm góc đã đếm)
        for (int i = 1; i < rows - 1; i++) {
            charCount[matrix[i][0]]++;
            charCount[matrix[i][cols - 1]]++;
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