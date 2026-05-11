import java.util.ArrayList;
import java.util.List;

public class Ouvrier {
    private String nom;
    private List<Integer> quantitesRessources;

    public Ouvrier(String nom, List<Integer> quantitesRessources) {
        this.nom = nom;
        this.quantitesRessources = new ArrayList<>();
        
    }

    public Ouvrier(String nom, List<Ressource> ressources, List<int> quantites) {
        this(nom, toList(ressources, quantites));
    }

    private static List<Integer> toList(List<Ressource> ressources, List<int> quantites) {
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

    public String getNom() {
        return nom;
    }

    public List<int> getQuantitesRessources() {
        return new ArrayList<>(quantitesRessources);
    }

    public int quantiteByRessource(Ressource ressource) {
        if (ressource == null) {
            return 0;
        }
        int index = ressource.getIndex();
        if (index < 0 || index >= quantitesRessources.size()) {
            return 0;
        }
        return quantitesRessources.get(index);
    }


    public String toString() {
        StringBuilder ouv = new StringBuilder();
        ouv.append("Ouvrier[nom=").append(nom)
               .append(", quantites=").append(quantitesRessources)
               .append("]");
        return ouv.toString();
    }
}
