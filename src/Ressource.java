public class Ressource {
    private String libelle;
    private int index;

    public Ressource(String libelle, int index) {
        this.libelle = libelle;
        this.index = index;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return "Ressource :" + libelle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) obj;
        return libelle == null ? other.libelle == null : libelle.equals(other.libelle);
    }

    public int hashCode() {
        return libelle == null ? 0 : libelle.hashCode();
    }
}
