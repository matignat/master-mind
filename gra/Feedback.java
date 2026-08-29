package gra;

public class Feedback {

    //Feedback dla komputera zwraca ilość trafionych i na złej pozycji
    //na jej podstawie której komputer zmniejsza liczbe możliwych kodów
    public static WynikFeedback sprawdźStrzał(Kod sekret, Kod strzał) {
        int białe = 0;
        int czarne = 0;
        int długość = MasterMind.długośćKodu;
        int[] sekretTab = sekret.dajKod();
        int[] strzałTab = strzał.dajKod();
        boolean[] usedSekret = new boolean[długość]; //Nie liczymy podwójnie
        boolean[] strzałSpr = new boolean[długość];


        //czarne -> trafienie na dobrej pozycji
        for (int i = 0; i < długość; i++) {
            if (sekretTab[i] == strzałTab[i]) {
                czarne++;
                usedSekret[i] = true;
                strzałSpr[i] = true;
            }
        }

        //białe -> zła pozycja
        for (int i = 0; i < długość; i++) {
            if (!strzałSpr[i]) {
                for (int j = 0; j < długość; j++) {
                    if (!usedSekret[j] && strzałTab[i] == sekretTab[j]) {
                        białe++;
                        strzałSpr[i] = true;
                        usedSekret[j] = true;
                        break;
                    }
                }
            }
        }
        return new WynikFeedback(czarne, białe);
    }
}
