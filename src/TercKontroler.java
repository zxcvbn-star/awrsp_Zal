import java.util.List;

public class TercKontroler {
    private final List<Wojewodztwo> wojewodztwa;

    public TercKontroler(List<Wojewodztwo> wojewodztwa) {
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

    public void znajdzWojewodztwoPoNazwie(String nazwa) {
        for (Wojewodztwo woj : wojewodztwa) {
            if (woj.getNazwa().equalsIgnoreCase(nazwa.trim())) {
                System.out.println("Województwo: " + woj.getNazwa());
                for (Powiat powiat : woj.getPowiaty()) {
                    System.out.println("  Powiat: " + powiat.getNazwa());
                }
            }
        }
    }

    public void znajdzPowiatPoNazwie(String nazwa) {
        for (Wojewodztwo woj : wojewodztwa) {
            for (Powiat powiat : woj.getPowiaty()) {
                if (powiat.getNazwa().equalsIgnoreCase(nazwa.trim())) {
                    System.out.println("  Powiat: " + powiat.getNazwa());
                    for (Gmina gmina : powiat.getGminy()) {
                        System.out.println("    Gmina: " + gmina.getNazwa() + " -> Rodzaj: " + gmina.getRodzajGminy());
                    }
                }
            }
        }
    }

    public void znajdzGminaPoNazwie(String nazwa) {
        for (Wojewodztwo woj : wojewodztwa) {
            for (Powiat powiat : woj.getPowiaty()) {
                for (Gmina gmina : powiat.getGminy()) {
                    if (gmina.getNazwa().equalsIgnoreCase(nazwa.trim())) {
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

    public void wyswietlLiczbeRodziGmin() {
        int Lmisat = 0, LmiastoPowiat = 0, Lmiastosto = 0, Lmiejska = 0, LmiejskaS = 0,
                Lmiejskowiejska = 0, Lobszarwiejski = 0, Lwiejska = 0, Ldzielnica = 0, Ldelegatura = 0;
        for (Wojewodztwo woj : wojewodztwa) {
            for (Powiat powiat : woj.getPowiaty()) {
                for (Gmina gmina : powiat.getGminy()) {
                    switch (gmina.getRodzajGminy()) {
                        case "miasto":
                            Lmisat++;
                            break;
                        case "miasto na prawach powiatu":
                            LmiastoPowiat++;
                            break;
                        case "miasto stołeczne, na prawach powiatu":
                            Lmiastosto++;
                            break;
                        case "gmina miejska":
                            Lmiejska++;
                            break;
                        case "gmina miejska, miasto stołeczne":
                            LmiejskaS++;
                            break;
                        case "gmina miejsko-wiejska":
                            Lmiejskowiejska++;
                            break;
                        case "obszar wiejski":
                            Lobszarwiejski++;
                            break;
                        case "gmina wiejska":
                            Lwiejska++;
                            break;
                        case "dzielnica":
                            Ldzielnica++;
                            break;
                        case "delegatura":
                            Ldelegatura++;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        System.out.println("Liczba rodzajów gmin:" +
                "\nmiasto: " + Lmisat + "\nmiasto na prawach powiatu: " + LmiastoPowiat +
                "\nmiasto stołeczne, na prawach powiatu: " + Lmiastosto + "\ngmina miejska: " + Lmiejska +
                "\ngmina miejska, miasto stołeczne: " + LmiejskaS + "\ngmina miejsko-wiejska: " + Lmiejskowiejska +
                "\nobszar wiejski: " + Lobszarwiejski + "\ngmina wiejska: " + Lwiejska + "\ndzielnica: " + Ldzielnica +
                "\ndelegatura: " + Ldelegatura);
    }

}
