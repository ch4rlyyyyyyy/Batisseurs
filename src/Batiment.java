import java.util.ArrayList;
import java.util.List;

public class Batiment {
    private String libelle;
    private int pointsVictoire;
    private int gainSesterces;
    private List<int> quantitesMateriau;

    public Batiment(String libelle, int pointsVictoire, int gainSesterces, List<int> quantitesMateriau) {
        this.libelle = libelle;
        this.pointsVictoire = pointsVictoire;
        this.gainSesterces = gainSesterces;
        this.quantitesMateriau = new ArrayList<>();
        
    }

    public Batiment(String libelle, int pointsVictoire, int gainSesterces, List<Ressource> ressources, List<int> quantites) {
        this(libelle, pointsVictoire, gainSesterces, toList(ressources, quantites));
    }

    private static List<int> toList(List<Ressource> ressources, List<int> quantites) {
        List<Integer> list = new ArrayList<>();
        if (ressources == null || quantites == null || ressources.size() != quantites.size()) {
            return list;
        }
        for (int i = 0; i < ressources.size(); i++) {
            Ressource res = ressources.get(i);
            Integer quantity = quantites.get(i);
            if (res != null && quantity != null) {
                list.add(Math.max(0, quantity));
            }
        }
        return list;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<int> getQuantitesMateriau() {
        return new ArrayList<>(quantitesMateriau);
    }

    public int quantiteByMateriau(Ressource ressource) {
        if (ressource == null) {
            return 0;
        }
        int index = ressource.getIndex();
        if (index < 0 || index >= quantitesMateriau.size()) {
            return 0;
        }
        return quantitesMateriau.get(index);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Batiment[libelle=").append(libelle)
               .append(", pointsVictoire=").append(pointsVictoire)
               .append(", gainSesterces=").append(gainSesterces)
               .append(", quantites=").append(quantitesMateriau)
               .append("]");
        return builder.toString();
    }
}
