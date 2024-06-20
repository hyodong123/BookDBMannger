package BookDBMannger;

import java.util.Scanner;

public class BookDBControler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookDBControler controller = new BookDBControler();

        while (true) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 삽입");
            System.out.println("2. 삭제");
            System.out.println("3. 선택");
            System.out.println("4. 업데이트");
            System.out.println("5. 전체 조회");
            System.out.println("6. 종료");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 엔터 키 소비

            switch (choice) {
                case 1:
                    controller.insertBook(scanner);
                    break;
                case 2:
                    controller.deleteBook(scanner);
                    break;
                case 3:
                    controller.selectBook(scanner);
                    break;
                case 4:
                    controller.updateBook(scanner);
                    break;
                case 5:
                    controller.selectAllBooks();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    void insertBook(Scanner scanner) {
        System.out.print("ID를 입력하세요: ");
        String id = scanner.nextLine();

        System.out.print("제목을 입력하세요: ");
        String title = scanner.nextLine();

        System.out.print("저자를 입력하세요: ");
        String author = scanner.nextLine();

        System.out.print("출판사를 입력하세요: ");
        String publisher = scanner.nextLine();

        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // 엔터 키 소비

        insert inserter = new insert();
        inserter.insertBook(id, title, author, publisher, price);
    }

    void deleteBook(Scanner scanner) {
        System.out.print("삭제할 책의 ID를 입력하세요: ");
        String id = scanner.nextLine();

        delete deleter = new delete();
        deleter.deleteBook(id);
    }

    void selectBook(Scanner scanner) {
        System.out.print("조회할 책의 ID를 입력하세요: ");
        String id = scanner.nextLine();

        select selector = new select();
        selector.selectBookById(id);
    }

    void updateBook(Scanner scanner) {
        System.out.print("업데이트할 책의 ID를 입력하세요: ");
        String id = scanner.nextLine();

        System.out.print("새 제목을 입력하세요: ");
        String title = scanner.nextLine();

        System.out.print("새 저자를 입력하세요: ");
        String author = scanner.nextLine();

        System.out.print("새 출판사를 입력하세요: ");
        String publisher = scanner.nextLine();

        System.out.print("새 가격을 입력하세요: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // 엔터 키 소비

        update updater = new update();
        updater.updateBook(id, title, author, publisher, price);
    }

    void selectAllBooks() {
        view viewer = new view();
        viewer.selectAllBooks();
    }
}
