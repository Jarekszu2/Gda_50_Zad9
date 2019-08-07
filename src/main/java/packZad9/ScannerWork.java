package packZad9;

import java.util.Scanner;

public class ScannerWork {
    Scanner scanner = new Scanner(System.in);

    public String getString() {
        return scanner.next();
    }

    public char getCharAW() {
        boolean flag = false;
        char znak = 'a';
        do {
            System.out.println();
            System.out.println("Wybierz: a/w ?");
            znak = scanner.next().charAt(0);
            if (znak == 'a' || znak == 'w') {
                flag = true;
            }
        } while (!flag);
        return znak;
    }

    public char getCharABC() {
        boolean flag = false;
        char znak = 'a';
        do {
            System.out.println();
            System.out.println("Wybierz: a/b/c ?");
            znak = scanner.next().charAt(0);
            if (znak == 'a' || znak == 'b' || znak == 'c') {
                flag = true;
            }
        } while (!flag);
        return znak;
    }

    public char getCharABCD() {
        boolean flag = false;
        char znak = 'a';
        do {
            System.out.println();
            System.out.println("Wybierz: a/b/c/d ?");
            znak = scanner.next().charAt(0);
            if (znak == 'a' || znak == 'b' || znak == 'c' || znak == 'd') {
                flag = true;
            }
        } while (!flag);
        return znak;
    }


}
