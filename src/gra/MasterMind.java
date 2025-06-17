package gra;

import gracze.*;

import java.util.Scanner;

public class MasterMind {
    public  static int długośćKodu = 4;
    public  static int liczbaKolorów = 6;

    //Mechanizm gry
    public static void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz tryb gry:");
        System.out.println("1. Ty ustalasz kod, komputer zgaduje.");
        System.out.println("2. Komputer ustala kod, Ty zgadujesz.");
        int tryb = scanner.nextInt();
        scanner.nextLine();

        if (tryb == 1) {
            System.out.println("Wybrałeś tryb: Ty ustalasz kod, komputer zgaduje.");
            komputerZgaduje(scanner);
        } else if (tryb == 2) {
            System.out.println("Wybrałeś tryb: Komputer ustala kod, Ty zgadujesz.");
            graczZgaduje(scanner);
        } else {
            System.out.println("Niepoprawny wybór.");
            start();
        }
    }

    // Tryb: komputer zgaduje
    private static void komputerZgaduje(Scanner scanner) {
        System.out.println("Podaj kod:");
        Kod sekret = Kod.stringToCode(scanner.nextLine());
        KomputerGracz komputer = new KomputerGracz();

        int próby = 1;
        boolean zgadł = false;

        while (!zgadł) {
            Kod strzał = komputer.zgaduj();

            System.out.println("Komputer zgaduje: " + strzał);
            WynikFeedback wynik = Feedback.sprawdźStrzał(sekret, strzał); //Komputer dostaje feedback
            //WynikFeedback wynik = FeedDlaGracza.dajFeedback(sekret, strzał);

            if (wynik.daj()[0] == długośćKodu) {
                System.out.println("Komputer odgadł hasło w " + próby + " próbach");
                zgadł = true;
            } else {
                komputer.aktualizujKody(strzał, wynik); //Aktualizujemy na podstawie feedbacku
                próby++;
            }
        }
    }

    // Tryb: komputer wybiera kod, człowiek zgaduje
    private static void graczZgaduje(Scanner scanner) {
        Kod sekret = Kod.losowyKod();

        int próby = 1;
        boolean zgadł = false;
        while (!zgadł) {
            System.out.print("Próba " + próby + ":\n");
            String kod = scanner.nextLine();
            Kod kodGracza = Kod.stringToCode(kod);
            WynikFeedback wynik = FeedDlaGracza.dajFeedback(sekret, kodGracza);

            if (wynik.daj()[0] == długośćKodu) {
                System.out.println("Wygrałeś w " + próby + " próbach");
                zgadł = true;
            } else {
                próby++;
            }

        }
    }
}
