import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Ressource bois = new Ressource("bois");
        Ressource pierre = new Ressource("pierre");
        Ressource architecture = new Ressource("architecture");
        Ressource decoration = new Ressource("decoration");

        Map<Ressource, Integer> production = new HashMap<>();
        production.put(bois, 1);
        production.put(pierre, 2);
        production.put(architecture, 0);
        production.put(decoration, 0);

        List<Ressource> materiaux = Arrays.asList(bois, pierre);
        List<Integer> quantites = Arrays.asList(2, 3);

        Batiment maison = new Batiment("Maison", 3, 2, materiaux, quantites);
        System.out.println(maison);
        System.out.println("Pierre nécessaire: " + maison.quantiteByMateriau(pierre));
    }
}
