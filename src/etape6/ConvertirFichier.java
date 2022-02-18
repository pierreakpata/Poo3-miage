package etape6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConvertirFichier {

    public static void convertirAnsiToUtf8(String nomFichier){
        File fichier = new File(nomFichier);
        if(!fichier.exists()){
            System.out.println("Le fichier n'existe pas");
            System.exit(-1);
        }

        String typeMIME= null;
        try {
            typeMIME = Files.probeContentType(fichier.toPath());
            if(typeMIME.contains("text")){

                //lecture du fichier
                BufferedReader reader = Files.newBufferedReader(fichier.toPath(), StandardCharsets.UTF_8);
                List<String> liste = new ArrayList<>();
                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    liste.add(ligne);
                }

                //ecriture du fichier
                BufferedWriter writer = Files.newBufferedWriter(fichier.toPath(), StandardCharsets.UTF_8);
                for(String s: liste){
                    writer.write(s);
                }

                reader.close();
                writer.close();
            }else{
                System.out.println("Impossible de modifier le fichier");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ConvertirFichier.convertirAnsiToUtf8("C:\\Users\\p.akpata\\Downloads\\Item.java");
    }
}
