package etape5;

import java.io.*;

public class FluxCaractere {

    public void afficherFichier(String nomFichier){
        File fichier = new File(nomFichier);
        if(!fichier.exists()){
            System.out.println("Le fichier n'existe pas");
            System.exit(-1);
        }
        try( BufferedReader reader = new BufferedReader(new FileReader(nomFichier))){
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FluxCaractere flux = new FluxCaractere();
        flux.afficherFichier("C:\\Users\\p.akpata\\Documents\\cordova.txt");
    }
}
