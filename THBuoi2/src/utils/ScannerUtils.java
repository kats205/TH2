package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc;

    public ScannerUtils() {
        sc = new Scanner(System.in);
    }

    public int inputInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                int number = sc.nextInt();
                sc.nextLine();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi! Vui lòng nhập lại số nguyên.");
                System.out.print(message);
                sc.nextLine();
            }
        }
    }

    public int inputInRange(String message, int min, int max) {
        while(true) {
            int number = inputInt(message);
            if (number >= min && number <= max) {
                return number;
            } else {
                System.out.println("Lỗi! Vui long nhập lại số trong khoảng [" + min + ", " + max + "]\n");
            }
        }
    }

    public static int inputInRangev2(String prompt, int min, int max) {
        int choice;
        while (true) {
            try {
                System.out.print(prompt);
                choice = Integer.parseInt(sc.nextLine());

                if (choice >= min && choice <= max) {
                    return choice;
                }

                System.out.println("Vui lòng nhập số trong khoảng " + min + " - " + max);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public String inputString(String message) {
        System.out.print(message);
        while (true) {
            try {
                String str = sc.nextLine().trim();

                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Chuỗi không được để trống.");
                }
                return str;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print(message);
            }
        }
    }

    public void close() {
        if (sc != null) {
            sc.close();
        }
    }
}
