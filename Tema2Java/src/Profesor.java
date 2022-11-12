public class Profesor implements  Human {
    String nume;
    String prenume;
    String acronim;
    Integer varsta;
    String materie;

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getAcronim() {
        return acronim;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public String getMaterie() {
        return materie;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public Profesor(String nume, String prenume, String acronim, Integer varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.materie = materie;
    }

    public void greeting(){return;}
    public void doWork(){return;}

    @Override
    public String toString() {
        return "Profesor " +
                nume + " " +
                prenume + " " +
                "Facultate " + acronim +
                " varsta " + varsta + " " +
                "Materie predata " + materie;
    }

    @Override
    public int compareTo(Human h)
    {
        return this.varsta.compareTo(h.getVarsta());
    }
}
