package etape6;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class WorldInFile {

    public static boolean estPresent(String mot, String nomFichier){
        File fichier = new File(nomFichier);
        if(!fichier.exists()){
            System.out.println("Le fichier n'existe pas");
            System.exit(-1);
        }
        boolean res = false;
        try {
            String typeMIME= Files.probeContentType(fichier.toPath());
            String[] splite = typeMIME.split("/");
            if(!splite[0].equals("image") && !splite[0].equals("video") && !splite[0].equals("audio")){
                if(splite[1].equals("pdf")){
                    String contenu = Files.readString(fichier.toPath(), StandardCharsets.ISO_8859_1);
                    res = contenu.contains(mot);
                }else {
                    String contenu = Files.readString(fichier.toPath());
                    res = contenu.contains(mot);
                }
            }else{
                System.out.println("Impossible de faire la recherche sur le fichier");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(WorldInFile.estPresent("machine", "C:\\Users\\p.akpata\\Downloads\\examen_2021.pdf"));
    }
}
