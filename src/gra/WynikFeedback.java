package gra;

import java.util.Objects;

//klasa pomocnicza trzyma wynik feedbacku dla komputera
//daje się łatwo porównywać z innymi feedbackami
public class WynikFeedback {
    public final int czarne;
    public final int białe;

    public WynikFeedback(int czarne, int białe) {
        this.czarne = czarne;
        this.białe = białe;
    }

    public int[] daj() {
        return new int[]{czarne, białe};
    }

    @Override
    public String toString() {
        return "Trafione:" + czarne + ", zła pozycja:" + białe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WynikFeedback)) return false;
        WynikFeedback drugi = (WynikFeedback) o;
        return czarne == drugi.czarne && białe == drugi.białe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(czarne, białe);
    }

}
