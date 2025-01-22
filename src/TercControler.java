import java.util.List;

public class TercControler {
    private final List<Wojewodztwo> wojewodztwa;

    public TercControler(List<Wojewodztwo> wojewodztwa) {
        this.wojewodztwa = wojewodztwa;
    }

    public void wyswietlWojewodztwa() {
        for (Wojewodztwo woj : wojewodztwa) {
            System.out.println("Województwo: " + woj.getNazwa());
            for (Powiat powiat : woj.getPowiaty()) {
                System.out.println("  Powiat: " + powiat.getNazwa());
                for (Gmina gmina : powiat.getGminy()) {
                    System.out.println("    Gmina: " + gmina.getNazwa() + " -> Rodzaj: " + gmina.getRodzajGminy());
                }
            }
        }
    }

    public void znajdzWojewodztwoPoNazwie(String name) {
        for (Wojewodztwo woj : wojewodztwa) {
            if (woj.getNazwa().equalsIgnoreCase(name.trim())) {
                System.out.println("Województwo: " + woj.getNazwa());
                for (Powiat powiat : woj.getPowiaty()) {
                    System.out.println("  Powiat: " + powiat.getNazwa());
                }
            }
        }
    }

    public void znajdzPowiatPoNazwie(String name) {
        for (Wojewodztwo woj : wojewodztwa) {
            for (Powiat powiat : woj.getPowiaty()) {
                if (powiat.getNazwa().equalsIgnoreCase(name.trim())) {
                    System.out.println("  Powiat: " + powiat.getNazwa());
                    for (Gmina gmina : powiat.getGminy()) {
                        System.out.println("    Gmina: " + gmina.getNazwa() + " -> Rodzaj: " + gmina.getRodzajGminy());
                    }
                }
            }
        }
    }

    public void znajdzGminaPoNazwie(String name) {
        for (Wojewodztwo woj : wojewodztwa) {
            for (Powiat powiat : woj.getPowiaty()) {
                for (Gmina gmina : powiat.getGminy()) {
                    if (gmina.getNazwa().equalsIgnoreCase(name.trim())) {
                        System.out.println("Gmina: " + gmina.getNazwa() + " -> Rodzaj: " + gmina.getRodzajGminy());
                    }
                }
            }
        }
    }

    public void wyswietlLiczbeWojewodzctw(){
        System.out.println("Liczba województw: " + wojewodztwa.size());
    }

    public void wyswietlLiczbePowiatow(){
        int totalPowiaty = 0;
        for(Wojewodztwo woj: wojewodztwa){
            for(Powiat pow: woj.getPowiaty()){
                totalPowiaty++;
            }
        }
        System.out.println("Liczba powiatów: " + totalPowiaty);
    }

    public void wyswietlLiczbeGmin() {
        int totalGminy = 0;
        for (Wojewodztwo woj : wojewodztwa) {
            for (Powiat powiat : woj.getPowiaty()) {
                for (Gmina gmina : powiat.getGminy()) {
                    totalGminy++;
                }
            }
        }
        System.out.println("Liczba gmin: " + totalGminy);
    }

}
