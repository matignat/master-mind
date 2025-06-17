import java.util.Scanner;

public class MasterMind {
    public final static int długośćKodu = 4;
    public final static int liczbaKolorów = 6;
    private Kod kod;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz tryb gry:");
        System.out.println("1. Ty ustalasz kod, komputer zgaduje.");
        System.out.println("2. Komputer ustala kod, Ty zgadujesz.");
        int tryb = scanner.nextInt();

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
    private void komputerZgaduje(Scanner scanner) {
        System.out.println("Podaj kod:");
        Kod kodGracza = Kod.stringToCode(scanner.nextLine());
        KomputerGracz komputer = new KomputerGracz();

        int próby = 0;
        boolean guessed = false;

        while (!guessed) {
            Kod strzał = komputer.makeGuess();

            System.out.println("Komputer zgaduje: " + guess);
            int[] feedback = getUserFeedback(scanner, guess);
            if (feedback[0] == codeLength) {
                System.out.println("Komputer odgadł hasło w " + (attempts + 1) + " próbach!");
                guessed = true;
            } else {
                computer.updatePossibleCodes(guess, feedback);
                attempts++;
            }
        }
        if (!guessed) {
            System.out.println("Komputer nie odgadł hasła w " + maxAttempts + " próbach.");
        }
    }

    // Tryb: komputer wybiera kod, człowiek zgaduje
    private void graczZgaduje(Scanner scanner) {
        int[] randCode = new int[codeLength];
        for (int i = 0; i < codeLength; i++) {
            randCode[i] = 1 + (int)(Math.random() * numColors);
        }
        Code secretCode = new Code(randCode);

        int attempts = 0;
        boolean guessed = false;
        while (attempts < maxAttempts && !guessed) {
            System.out.print("Podaj zgadywany kod (cztery liczby 1-6, bez spacji, np. 1234): ");
            String guessStr = scanner.nextLine();
            int[] guessArr = new int[codeLength];
            for (int i = 0; i < codeLength; i++) {
                guessArr[i] = Character.getNumericValue(guessStr.charAt(i));
            }
            Code guess = new Code(guessArr);
            int[] feedback = Evaluator.evaluate(guess, secretCode);
            System.out.println("Czarne: " + feedback[0] + ", białe: " + feedback[1]);
            if (feedback[0] == codeLength) {
                System.out.println("Brawo! Odgadłeś kod w " + (attempts + 1) + " próbach!");
                guessed = true;
            } else {
                attempts++;
            }
        }
        if (!guessed) {
            System.out.println("Niestety, nie udało się odgadnąć kodu. Poprawny kod to: " + secretCode);
        }
    }
}
