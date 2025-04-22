package UI;

import backend.*;
import utils.ScannerUtils;

public class Menu {
    private Bai5_1 bai5_1 = new Bai5_1();
    private Bai5_2 bai5_2 = new Bai5_2();
    private Bai5_3 bai5_3 = new Bai5_3();
    private Bai5_4 bai5_4 = new Bai5_4();
    private Bai5_5 bai5_5 = new Bai5_5();
    private Bai5_6 bai5_6 = new Bai5_6();
    private Bai5_7 bai5_7 = new Bai5_7();

    private ScannerUtils sc = new ScannerUtils();
    private boolean isRunning = true;

    public void run() {
        while (isRunning) {
            displayMenu();
        }
    }

    public void displayMenu() {
        System.out.println("\n----------- Phần 5 -----------");
        System.out.println("1. Bài 5.1");
        System.out.println("2. Bài 5.2");
        System.out.println("3. Bài 5.3");
        System.out.println("4. Bài 5.4");
        System.out.println("5. Bài 5.5");
        System.out.println("5. Bài 5.6");
        System.out.println("5. Bài 5.7");
        System.out.println("5. Bài 5.8");
        System.out.println("5. Bài 5.9");
        System.out.println("0. Thoát chương trình");
        System.out.println("--------------------------------------------");

        int choice = sc.inputInRange("Nhập lựa chọn của bạn: ", 0, 5);

        switch (choice) {
            case 1:
                bai5_1.run();
                break;
            case 2:
                bai5_2.run();
                break;
            case 3:
                bai5_3.run();
                break;
            case 4:
                bai5_4.run();
                break;
            case 5:
                bai5_5.run();
                break;
            case 6:
                bai5_6.run();
                break;
            case 7:
                bai5_7.run();
                break;
            case 8:
//                bai5_8.run();
                break;
            case 9:
//                bai5_9.run();
                break;
            case 0:
                isRunning = false;
                System.out.println("Dã thoát khỏi chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }
}
