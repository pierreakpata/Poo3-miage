package etape4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceFamille {

    public static void saveFamille(String nomFichier, Famille famille){
        File fichier = new File(nomFichier);
        try(FileOutputStream fos = new FileOutputStream(fichier)){
            ObjectOutputStream buf = new ObjectOutputStream(fos);
            buf.writeObject(famille);
            buf.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  static Famille loadFamille(String nomFichier){
        File fichier = new File(nomFichier);
        Famille famille = null;
        try(FileInputStream fis = new FileInputStream(fichier)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            famille = (Famille)ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return famille;
        }
    }

    public static void main(String[] args) {
        //construction de l'arbre généalogique
        Famille princeWilliam = new Famille("Duc d'Embourg", "William", "kate","Middleton", null);
        Famille princeHenry = new Famille("Duc d'Embourg", "Henry", null, null, null);
        Famille savannah = new Famille("Phillips", null, "Savannah", "Phillips", null);
        Famille isla = new Famille("Phillips", null, "Isla", "Phillips", null);
        Famille princesseBeatrice = new Famille("Duc d'York", null,"Beatrice", "Duc d'York", null);
        Famille princesseEugenie = new Famille("Duc d'York", null, "Eugenie", "Duc d'York", null);

        Famille louise = new Famille("Duc d'Embourg", null, "Louise", "Duc d'Embourg", null);
        Famille sevem = new Famille("Duc d'Embourg", "Sevem", null, null, null);
        Famille zara = new Famille("Tindall", "Mike", "Zara", "Phillips", null);

        List<Famille> enfantsPeter = new ArrayList<>();
        enfantsPeter.add(savannah);enfantsPeter.add(isla);
        Famille peter = new Famille("Phillips", "Peter", "Autumn", "Wilken", enfantsPeter);

        List<Famille> enfantsCharles = new ArrayList<>();
        enfantsCharles.add(princeWilliam);enfantsCharles.add(princeHenry);
        Famille charles = new Famille("Duc d'Embourg", "Charles", "Diana", "Swmith", enfantsCharles);

        List<Famille> enfantsAnne = new ArrayList<>();
        enfantsAnne.add(peter);enfantsAnne.add(zara);
        Famille princesseAnne = new Famille("Phillips", "Mark", "Anne", "Duc d'Embourg", enfantsAnne);

        List<Famille> enfantsAndrew = new ArrayList<>();
        enfantsAndrew.add(princesseBeatrice);enfantsAndrew.add(princesseEugenie);
        Famille andrew = new Famille("Duc d'Embourg", "Andrew", "Sarah", "Ferguson", enfantsAndrew);

        List<Famille> enfantsEdouard = new ArrayList<>();
        enfantsEdouard.add(louise);enfantsEdouard.add(sevem);
        Famille edouard = new Famille("Duc d'Embourg", "Edouard", "Sophie", "Wilson", enfantsEdouard);

        List<Famille> enfantsElizabeth = new ArrayList<>();
        enfantsElizabeth.add(charles);enfantsElizabeth.add(princesseAnne);
        enfantsElizabeth.add(andrew);enfantsElizabeth.add(edouard);
        Famille elizabeth2 = new Famille("Duc d'Embourg", "Philip", "Elisabeth", "George", enfantsElizabeth);
        Famille princessMargaret = new Famille("Snowdon", "Antony", "Margaret", "George", null);

        List<Famille> enfantsGeorge = new ArrayList<>();
        enfantsGeorge.add(elizabeth2);enfantsGeorge.add(princessMargaret);
        Famille george = new Famille("George", "Albert", "Elisabeth", "Kulmnan", enfantsGeorge);

        //sauvegarder la famille
        PersistenceFamille.saveFamille("C:\\Users\\p.akpata\\IdeaProjects\\Poo3-miage\\src\\family", george);

        //Charger la famille
        System.out.println(PersistenceFamille.loadFamille("C:\\Users\\p.akpata\\IdeaProjects\\Poo3-miage\\src\\family"));

    }
}
