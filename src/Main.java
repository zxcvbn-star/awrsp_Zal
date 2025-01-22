import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\JetBrains\\Zalicznie java\\untitled\\src\\TERC_Urzedowy_2025-01-20.csv";
        List<Wojewodztwo> wojewodztwa = new MapTerc(filePath).parseCsv();

        TercControler controller = new TercControler(wojewodztwa);

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Witaj w systemie TERC! Wpisz polecenie lub 'exit' aby zakończyć.");
        while (true) {
            System.out.println("\nDostępne polecenia:");
            System.out.println("1. wyswietlWojewodztwa");
            System.out.println("2. znajdzWojewodztwoPoNazwie <nazwa>");
            System.out.println("3. znajdzPowiatPoNazwie <nazwa>");
            System.out.println("4. znajdzGminaPoNazwie <nazwa>");
            System.out.println("5. wyswietlLiczbeWojewodzctw");
            System.out.println("6. wyswietlLiczbePowiatow");
            System.out.println("7. wyswietlLiczbeGmin");
            System.out.println("8. wyswietlLiczbeRodziGmin");
            System.out.println("exit - zakończ program");

            System.out.print("\nPodaj polecenie: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Zakończono działanie programu.");
                break;
            }

            try {
                if (command.equals("wyswietlWojewodztwa")) {
                    controller.wyswietlWojewodztwa();
                } else if (command.startsWith("znajdzWojewodztwoPoNazwie")) {
                    String[] parts = command.split(" ", 2);
                    if (parts.length > 1) {
                        controller.znajdzWojewodztwoPoNazwie(parts[1]);
                    } else {
                        System.out.println("Podaj nazwę województwa.");
                    }
                } else if (command.startsWith("znajdzPowiatPoNazwie")) {
                    String[] parts = command.split(" ", 2);
                    if (parts.length > 1) {
                        controller.znajdzPowiatPoNazwie(parts[1]);
                    } else {
                        System.out.println("Podaj nazwę powiatu.");
                    }
                } else if (command.startsWith("znajdzGminaPoNazwie")) {
                    String[] parts = command.split(" ", 2);
                    if (parts.length > 1) {
                        controller.znajdzGminaPoNazwie(parts[1]);
                    } else {
                        System.out.println("Podaj nazwę gminy.");
                    }
                } else if (command.equals("wyswietlLiczbeWojewodzctw")) {
                    controller.wyswietlLiczbeWojewodzctw();
                } else if (command.equals("wyswietlLiczbePowiatow")) {
                    controller.wyswietlLiczbePowiatow();
                } else if (command.equals("wyswietlLiczbeGmin")) {
                    controller.wyswietlLiczbeGmin();
                } else if (command.equals("wyswietlLiczbeRodziGmin")) {
                    controller.wyswietlLiczbeRodziGmin();
                } else {
                    System.out.println("Nieznane polecenie. Spróbuj ponownie.");
                }
            } catch (Exception e) {
                System.out.println("Wystąpił błąd podczas wykonywania polecenia: " + e.getMessage());
            }
        }

        scanner.close();
    }

}
