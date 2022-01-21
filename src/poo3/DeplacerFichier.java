package poo3;

import java.io.File;

public class DeplacerFichier {

    public void deplacerFichier(String cheminFichier, String dossierDestination){
        File fichierSource = new File(cheminFichier);
        File dossier = new File(dossierDestination);
        if(!fichierSource.exists() || !dossier.exists()){
            System.out.println("Le fichier ou le dossier n'existe pas");
        }else{
            try{
                String cheminAbsoluDuDossier = dossier.getAbsolutePath();
                //création du fichier dans le dossier de destination
                File newFile = new File(cheminAbsoluDuDossier+File.separator+fichierSource.getName());
                //Déplacer le fichier suivant le chemin spécifier dans newFile
                fichierSource.renameTo(newFile);
                if(newFile.exists()){
                    System.out.println("Fichier créé");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
