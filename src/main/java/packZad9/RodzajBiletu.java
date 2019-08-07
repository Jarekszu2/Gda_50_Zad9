package packZad9;

import lombok.Data;

//@Data
public enum  RodzajBiletu {
    MIESIECZNY(140),
    TYGODNIOWY(40),
    JEDNODNIOWY(10),
    GODZINNY(3);

    private int cena;

    RodzajBiletu(int cena) {
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }
}
