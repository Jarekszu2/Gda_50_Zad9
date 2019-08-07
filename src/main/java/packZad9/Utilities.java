package packZad9;

public class Utilities {
    ScannerWork scannerWork = new ScannerWork();

    public String getName() {
        System.out.println();
        System.out.println("Podaj imię:");
        String name = scannerWork.getString();
        return name;
    }

    public String getSurame() {
        System.out.println();
        System.out.println("Podaj nazwisko:");
        String name = scannerWork.getString();
        return name;
    }

    public RodzajBiletu getRodzajBiletu() {
        RodzajBiletu[] tab = RodzajBiletu.values();
        System.out.println();
        System.out.println("Wybierz rodzaj biletu:");
        final char[] tabChar = new char[] {'a'};
        for (int i = 0; i < tab.length; i++) {
            System.out.println((tabChar[0]++) + ") " + tab[i] + " " + tab[i].getCena() + " PLN");
        }
        char znak = scannerWork.getCharABCD();
        RodzajBiletu rodzajBiletu = null;
        switch (znak) {
            case 'a':
                rodzajBiletu = RodzajBiletu.MIESIECZNY;
                break;
            case 'b':
                rodzajBiletu = RodzajBiletu.TYGODNIOWY;
                break;
            case 'c':
                rodzajBiletu = RodzajBiletu.JEDNODNIOWY;
                break;
            case 'd':
                rodzajBiletu = RodzajBiletu.GODZINNY;
                break;
        }
        return rodzajBiletu;
    }

    public char getPayment(RodzajBiletu rodzajBiletu) {
        System.out.println();
        System.out.println("Kwota do zapłaty: " + rodzajBiletu.getCena() + " PLN");
        System.out.println("Wybierz rodzaj płatności:" +
                "\n a) KARTA" +
                "\n b) GOTÓWKA" +
                "\n c) MODLITWA" +
                "\n d) rezygnacja z zakupu biletu");
        char wubor = scannerWork.getCharABCD();
        return wubor;
    }
}
