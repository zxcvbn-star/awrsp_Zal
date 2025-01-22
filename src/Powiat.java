import java.util.ArrayList;
import java.util.List;

class Powiat {
    private String nazwa;
    private List<Gmina> gminy;

    public Powiat(String nazwa) {
        this.nazwa = nazwa;
        this.gminy = new ArrayList<>();
    }

    public void dodajGmina(Gmina gmina) {
        this.gminy.add(gmina);
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Gmina> getGminy() {
        return gminy;
    }

    @Override
    public String toString() {
        return "Powiat{" +
                "nazwa='" + nazwa + '\'' +
                ", gminy=" + gminy +
                '}';
    }
}