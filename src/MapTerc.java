import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MapTerc {
    private final String filePath;
    private final List<Wojewodztwo> wojewodztwa = new ArrayList<>();
    private Wojewodztwo currentWojewodztwo;
    private Powiat currentPowiat;

    public MapTerc(String filePath) {
        this.filePath = filePath;
    }
    public List<Wojewodztwo> parseCsv() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] element = line.split(";");


            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        }
        return wojewodztwa;
    }
}