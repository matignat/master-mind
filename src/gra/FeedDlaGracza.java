package gra;

//oddzuelana klasa dodatkowo wypisuje powodzenie strzałów dla gracza (można użyc też dla komputera)
public class FeedDlaGracza {
    public static WynikFeedback dajFeedback(Kod sekret, Kod strzał) {
        int czarne = 0;
        int białe = 0;
        int długość = MasterMind.długośćKodu;
        int[] sekretTab = sekret.dajKod();
        int[] strzałTab = strzał.dajKod();
        char[] feedback = new char[długość];
        boolean[] usedSekret = new boolean[długość]; //ustawiamy aby wiedzieć czy już użyto
        boolean[] usedStrzał = new boolean[długość];

        for (int i = 0; i < długość; i++) {
            if (sekretTab[i] == strzałTab[i]) {
                czarne ++;
                feedback[i] = 'C';
                usedStrzał[i] = true;
                usedSekret[i] = true;
            }
        }

        //zła pozycja trafiony kolor
        for (int i = 0; i < długość; i++) {
            if (!usedStrzał[i]) { //unikamy sytuacji gdzie wyswietlamy za dużo B dla trafionych
                boolean trafiony = false;
                for (int j = 0; j < długość; j++) {
                    if (!usedSekret[j] && strzałTab[i] == sekretTab[j]) {
                        białe++;
                        feedback[i] = 'B';
                        usedSekret[j] = true;
                        trafiony = true;
                        break;
                    }
                }
                if (!trafiony) feedback[i] = 'X';
            }
        }
        WynikFeedback wynik = new WynikFeedback(czarne, białe);
        //System.out.println(feedback);  ;ułatwienie - zwraca pozycje
        System.out.println(wynik);
        return wynik;
    }
}
