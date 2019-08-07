package packZad9;
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

        System.out.println("Aplikacja służy do zakupu biletu w kasie SKM.");
        System.out.println("Po podaniu danych Użytkownika drugowany jest jego bilet.");

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
                System.out.println(name);
                String surname = utilities.getSurame();
                System.out.println(surname);
                RodzajBiletu rodzajBiletu = utilities.getRodzajBiletu();
                System.out.println(rodzajBiletu.name());
                char payment = utilities.getPayment(rodzajBiletu);
                switch (payment) {
                    case 'a':
                        System.out.println("Zapłacono kartą.");
                        break;
                    case 'b':
                        System.out.println("Zapłacono gotówka.");
                        break;
                    case 'c':
                        System.out.println("Odmówiono 'Zdrowaśkę', bilet opłacony.");
                        break;
                    case 'd':
                        System.out.println("Zrezygnowano z zakupu biletu.");
                        continue;
                }
            } else {
                flag = true;
            }
        } while (!flag);
    }
}
