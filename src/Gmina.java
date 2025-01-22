class Gmina {
    private String nazwa;
    private String rodzajGminy;

    public Gmina(String nazwa, String rodzajGminy) {
        this.nazwa = nazwa;
        this.rodzajGminy = rodzajGminy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getRodzajGminy() {
        return rodzajGminy;
    }

    @Override
    public String toString() {
        return "Gmina{" +
                "nazwa='" + nazwa + '\'' +
                ", rodzajGminy='" + rodzajGminy + '\'' +
                '}';
    }
}