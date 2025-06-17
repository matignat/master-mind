import java.util.Random;

public class Kod {
    private int[] kod;
    Random random = new Random();

    public Kod(int[] kod) {
        this.kod = kod;
    }
    
    public static Kod stringToCode(String string) {
        int[] kodTab = new int[MasterMind.długośćKodu];
        for (int i = 0; i < MasterMind.długośćKodu; i++) {
            kodTab[i] = Character.getNumericValue(string.charAt(i));
        }
        return new Kod(kodTab);
    }

    public Kod losowyKod() {
        int[] kodTab = new int[MasterMind.długośćKodu];
        for (int i = 0; i < MasterMind.długośćKodu; i ++) {
            kodTab[i] = random.nextInt(MasterMind.liczbaKolorów) + 1;
        }
        return new Kod(kodTab);
    }
}
