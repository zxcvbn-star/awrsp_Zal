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

    private String capitalize(String string){
        String[] tab = string.split("-");
        for (int i = 0; i < tab.length; i++) {
            tab[i] = tab[i].substring(0, 1).toUpperCase() + tab[i].substring(1).toLowerCase();
        }
        return String.join("-", tab);
    }

    public MapTerc(String filePath) {
        this.filePath = filePath;
    }
    public List<Wojewodztwo> parseCsv() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] element = line.split(";");

                if(element.length < 7)
                    continue;

                //WOJEWODZTWO
                if(element[5].equals("województwo")){
                    String nazwaWojewodztwa = element[4].trim().toLowerCase();
                    nazwaWojewodztwa = capitalize(nazwaWojewodztwa);
                    currentWojewodztwo = new Wojewodztwo(nazwaWojewodztwa);
                    wojewodztwa.add(currentWojewodztwo);

                    //POWIAT
                }else if(element[5].equals("powiat")) {
                    String nazwaPowiatu = element[4].trim();
                    nazwaPowiatu = capitalize(nazwaPowiatu);
                    currentPowiat = new Powiat(nazwaPowiatu);
                    currentWojewodztwo.dodajPowiat(currentPowiat);

                    //GMINA
                } else{
                    String nazwaGminy = element[4].trim();
                    String rodzajGminy = element[5].trim();
                    currentPowiat.dodajGmina(new Gmina(nazwaGminy, rodzajGminy));
                }

            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        }
        return wojewodztwa;
    }
}