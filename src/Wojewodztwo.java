import java.util.ArrayList;
import java.util.List;

class Wojewodztwo {
    private String nazwa;
    private List<Powiat> powiaty;


    public Wojewodztwo(String nazwa) {
        this.nazwa = nazwa;
        this.powiaty = new ArrayList<>();
    }

    public void dodajPowiat(Powiat powiat) {
        this.powiaty.add(powiat);
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Powiat> getPowiaty() {
        return powiaty;
    }

    @Override
    public String toString() {
        return "Wojewodztwo{" +
                "nazwa='" + nazwa + '\'' +
                ", powiaty=" + powiaty +
                '}';
    }
}