import gra.*;

import java.util.ArrayList;
import java.util.List;

public class KomputerGracz {
    private List<Kod> możliweKody;
    private int długośćKodu = MasterMind.długośćKodu;
    private int liczbaKolorów = MasterMind.liczbaKolorów;

    public KomputerGracz() {
        this.możliweKody = generujMożliwości();
    }

    private List<Kod> generujMożliwości() {
        List<Kod> kody = new ArrayList<>();
        genrujRek(new int[długośćKodu], 0, kody);
        return kody;
    }

    private void genrujRek(int[] kod, int pozycja, List<Kod> kody) {
        if (pozycja == długośćKodu) {
            kody.add(new Kod(kod.clone()));
            return;
        }

        for (int i = 1; i <= liczbaKolorów; i++) {
            kod[pozycja] = i;
            genrujRek(kod, pozycja + 1, kody);
        }
    }

    public Kod zgaduj() {
        if (możliweKody.isEmpty()) return null;
        return możliweKody.get(0);
    }

    public void aktualizujKody(Kod strzał, WynikFeedback feedback) {
        List<Kod> noweKody = new ArrayList<>();
        for (Kod kod : możliweKody) {
            WynikFeedback wynik = Feedback.sprawdźStrzał(strzał, kod); //porównujemy feedback naszego kodu i wszytskich możliwych zostawiamy tylko takie same
            
        }
    }



}
