import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\JetBrains\\Zalicznie java\\untitled\\src\\TERC_Urzedowy_2025-01-20.csv";
        List<Wojewodztwo> wojewodztwa = new MapTerc(filePath).MapCSV();

        TercKontroler kontroler = new TercKontroler(wojewodztwa);

        Scanner scanner = new Scanner(System.in);
        String komenda;

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
            komenda = scanner.nextLine();

            if (komenda.equalsIgnoreCase("exit")) {
                System.out.println("Zakończono działanie programu.");
                break;
            }

            try {
                if (komenda.equals("wyswietlWojewodztwa") || komenda.equals("1")) {
                    kontroler.wyswietlWojewodztwa();
                } else if (komenda.startsWith("znajdzWojewodztwoPoNazwie") || komenda.startsWith("2")) {
                    String[] parts = komenda.split(" ", 2);
                    if (parts.length > 1) {
                        kontroler.znajdzWojewodztwoPoNazwie(parts[1]);
                    } else {
                        System.out.println("Podaj nazwę województwa.");
                    }
                } else if (komenda.startsWith("znajdzPowiatPoNazwie") || komenda.startsWith("3")) {
                    String[] parts = komenda.split(" ", 2);
                    if (parts.length > 1) {
                        kontroler.znajdzPowiatPoNazwie(parts[1]);
                    } else {
                        System.out.println("Podaj nazwę powiatu.");
                    }
                } else if (komenda.startsWith("znajdzGminaPoNazwie") || komenda.startsWith("4")) {
                    String[] parts = komenda.split(" ", 2);
                    if (parts.length > 1) {
                        kontroler.znajdzGminaPoNazwie(parts[1]);
                    } else {
                        System.out.println("Podaj nazwę gminy.");
                    }
                } else if (komenda.equals("wyswietlLiczbeWojewodzctw") || komenda.equals("5")) {
                    kontroler.wyswietlLiczbeWojewodzctw();
                } else if (komenda.equals("wyswietlLiczbePowiatow") || komenda.equals("6")) {
                    kontroler.wyswietlLiczbePowiatow();
                } else if (komenda.equals("wyswietlLiczbeGmin") || komenda.equals("7")) {
                    kontroler.wyswietlLiczbeGmin();
                } else if (komenda.equals("wyswietlLiczbeRodziGmin") || komenda.equals("8")) {
                    kontroler.wyswietlLiczbeRodziGmin();
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
