package poo3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackupFile {

    public void copierFichier(String source){
        //création d'un objet Path à partir du chemin source
        Path cheminSource = Paths.get(source);
        System.out.println(cheminSource.getFileName());

        //création du dossier Back
        String desti = cheminSource.getParent()+File.separator+"back";
        try {
            if(!Paths.get(desti).toFile().exists()){
                Files.createDirectory(Paths.get(desti));
                System.out.println("Le dossier Back vient d'être céer !");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //création du Path correspondant au fichier destination
        Path cheminDest = Paths.get(desti+File.separator+"date_"+System.currentTimeMillis());

        if(!cheminSource.toFile().exists() || !cheminSource.toFile().isFile()){
            System.out.println("Le fichier n'existe pas ou est un dossier");
        }else{
            if(!cheminDest.toFile().exists()){
                try {
                    Files.copy(cheminSource, cheminDest);
                    System.out.println("Le fichier a été copier avec succès !");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Le fichier existe déjà !");
            }
        }
    }
}
