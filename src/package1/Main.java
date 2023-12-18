package package1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к первому файлу");
        String path1 = scanner.nextLine();
        System.out.println("Введите путь к второму файлу");
        String path2 = scanner.nextLine();

        FileChecker.checkFiles(path1, path2);
    }
}
