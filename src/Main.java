import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\JetBrains\\Zalicznie java\\untitled\\src\\TERC_Urzedowy_2025-01-20.csv";
        List<Wojewodztwo> wojewodztwa = new MapTerc(filePath).parseCsv();


    }
}
