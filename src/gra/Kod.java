package gra;

import java.util.Random;

public class Kod {
    private int[] kod;

    public Kod(int[] kod) {
        this.kod = kod;
    }

    //Zamienia prompt na Kod
    public static Kod stringToCode(String string) {
        int[] kodTab = new int[MasterMind.długośćKodu];
        for (int i = 0; i < MasterMind.długośćKodu; i++) {
            kodTab[i] = Character.getNumericValue(string.charAt(i));
        }
        return new Kod(kodTab);
    }

    //Generuje losowy dla trybu 2
    public static Kod losowyKod() {
        int[] kodTab = new int[MasterMind.długośćKodu];
        Random random = new Random();
        for (int i = 0; i < MasterMind.długośćKodu; i++) {
            kodTab[i] = random.nextInt(MasterMind.liczbaKolorów) + 1;
        }
        return new Kod(kodTab);
    }

    protected int[] dajKod() {
        return kod;
    }

    @Override
    public String toString() {
        return kod[0] + ", " + kod[1] + ", " + kod[2] + ", " + kod[3];
    }

}
