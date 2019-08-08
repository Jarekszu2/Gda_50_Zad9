package packZad9;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public String getPayment(RodzajBiletu rodzajBiletu) {
        String result = "";
        System.out.println();
        System.out.println("Kwota do zapłaty: " + rodzajBiletu.getCena() + " PLN");
        System.out.println("Wybierz rodzaj płatności:" +
                "\n a) KARTA" +
                "\n b) GOTÓWKA" +
                "\n c) MODLITWA" +
                "\n d) rezygnacja z zakupu biletu");
        char wybor = scannerWork.getCharABCD();
        if (wybor == 'a') {
            result = "karta";
        } else if (wybor == 'b') {
            result = "gotówka";
        } else if (wybor == 'c') {
            result = "modlitwa";
        } else if (wybor == 'd') {
            result = "quit";
        }
        return result;
    }

    public int getRandomInt(List<Integer> integerList) {
        Random random = new Random();
        boolean flag = false;
        int result = 0;
        do {
            int randomInt = random.nextInt(1000000) + 1;
            if (integerList.contains(randomInt)) {
                continue;
            } else {
                integerList.add(randomInt);
                result = randomInt;
                flag = true;
            }
        } while (!flag);
        return result;
    }

    public String getRandomString(List<Integer> integerList) {
        int randomInt = getRandomInt(integerList);
        String stringFromInt = String.valueOf(randomInt);
        String[] tab = stringFromInt.split("");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (i < tab.length) {
                stringBuilder.append(tab[i]);
            } else {
                stringBuilder.append(getRandomChar());
            }
        }

        return stringBuilder.toString();
    }

    public char getRandomChar() {
        Random random = new Random();
        int randomInt = random.nextInt(23) + 65;
        char znak = (char) randomInt;
        return znak;
    }

    public String getBiletId(String name, String surname, List<Integer> integerList) {
        String biletId = "Blt-" + name.charAt(0) + surname.charAt(0) + "-"
                + getRandomString(integerList) + "-SKM";
        return biletId;
    }

    public List<Integer> getIntegerList() {
        List<Integer> integerList = new ArrayList<Integer>();
        return integerList;
    }

    public void printBilet(RodzajBiletu rodzajBiletu, String name, String surname, String iDbiletu, String payment) {
        String stringDateTimeNow = getStringLocalDateTimeNow();
        String stringValitTo = getStringLocalDateTimeValid(rodzajBiletu);
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("  Szybka Kolej Miejska");
        System.out.println("     Bilet podróżny");
        System.out.println();
        System.out.println("Rodzaj biletu: " + rodzajBiletu.name());
        System.out.println("Bilet ważny od: " + stringDateTimeNow);
        System.out.println("Bilet ważny do: " + stringValitTo);
        System.out.println("Imię Nazwisko: " + name + " " + surname);
        System.out.println("Nr biletu: " + iDbiletu);
        System.out.println("Cena: " + rodzajBiletu.getCena() + " PLN. Sposób zapłaty: " + payment + ".");
        System.out.println();
        System.out.println(">> ZAPRASZAMY PONOWNIE <<");
        System.out.println("------------------------------------");
    }

    private String getStringLocalDateTimeNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dateTimeFormatter.format(localDateTime);
    }

    private String getStringLocalDateTimeValid(RodzajBiletu rodzajBiletu) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String result = "";
        switch (rodzajBiletu) {
            case MIESIECZNY:
                LocalDateTime localDateTimePlusMonth = localDateTime.plusMonths(1);
                result = dateTimeFormatter.format(localDateTimePlusMonth);
                break;
            case TYGODNIOWY:
                LocalDateTime localDateTimePlus7Days = localDateTime.plusDays(7);
                result = dateTimeFormatter.format(localDateTimePlus7Days);
                break;
            case JEDNODNIOWY:
                LocalDateTime localDateTimePlus1Day = localDateTime.plusDays(1);
                result = dateTimeFormatter.format(localDateTimePlus1Day);
                break;
            case GODZINNY:
                LocalDateTime localDateTimePlus1Hour = localDateTime.plusHours(1);
                result = dateTimeFormatter.format(localDateTimePlus1Hour);
                break;
        }
        return result;
    }

}
