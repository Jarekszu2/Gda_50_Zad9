package packZad9;

import java.util.ArrayList;
import java.util.List;

/*
Napisz aplikację do zamawiania biletu w kasie SKM. Użytkownik podchodzi do kasy (uruchamia się program) i program pyta go o:
- imie
- nazwisko
- rodzaj płatności (KARTA, GOTÓWKA, MODLITWA*)
- rodzaj biletu (MIESIECZNY, TYGODNIOWY, JEDNORAZOWY, GODZINNY)

po zatwierdzeniu użytkownikowi powinien wypisać się bilet (wypisać obiekt biletu). Obiekt powinien dodatkowo posiadać unikalny identyfikator, który jest długim ciągiem liter i cyfr oddzielonych myślnikami.

 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        Utilities utilities = new Utilities();
        ScannerWork scannerWork = new ScannerWork();
        List<Integer> integerList = utilities.getIntegerList();

        System.out.println("Aplikacja służy do zakupu biletu w kasie SKM.");
        System.out.println("Po podaniu danych Użytkownika drukowany jest jego bilet.");

        boolean flag = false;
        char znak = 'a';
        do {
            System.out.println();
            System.out.println("Witamy w punkcie kasowym SKM.");
            System.out.println("Wybierz opcję:\n a) zakup biletu\n w) wyjście");
            znak = scannerWork.getCharAW();
            if (znak == 'a') {
                System.out.println();
                System.out.println("Postępuj zgodnie z instrukcją:");
                System.out.println();

                String name = utilities.getName();
                String surname = utilities.getSurame();
                RodzajBiletu rodzajBiletu = utilities.getRodzajBiletu();
                String payment = utilities.getPayment(rodzajBiletu);
                if (payment.equalsIgnoreCase("quit")) {
                    continue;
                } else {
                    utilities.printBilet(rodzajBiletu, name, surname, utilities.getBiletId(name, surname, integerList), payment);
                }

            } else {
                flag = true;
            }
        } while (!flag);
    }
}
