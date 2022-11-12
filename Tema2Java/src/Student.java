public class Student implements  Human {
    String nume;
    String prenume;
    String acronim;
    Integer varsta;
    Integer an_studiu;

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

    public Integer getAn_studiu() {
        return an_studiu;
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

    public void setAn_studiu(Integer an_studiu) {
        this.an_studiu = an_studiu;
    }

    public Student(String nume, String prenume, String acronim, Integer varsta, Integer an_studiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronim = acronim;
        this.varsta = varsta;
        this.an_studiu = an_studiu;
    }

    public void greeting(){return;}
    public void doWork(){return;}

    @Override
    public String toString() {
        return "Sd " +
                nume +" "+
                prenume + " " +
                "Anul " + an_studiu +
                " Facultate " + acronim +
                " varsta " + varsta;
    }

    @Override
    public int compareTo(Human h)
    {
        return this.varsta.compareTo(h.getVarsta());
    }
}
