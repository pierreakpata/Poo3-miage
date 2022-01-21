package poo3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SyncFile {

    public void syncFile(Path p1, Path p2, int criteria){

        if(p1.toFile().isFile() && p2.toFile().isFile()){
            System.out.println(p1.getFileName()+" et "+p2.getFileName()+ " existent");
            if(p1.getFileName().toString().equals(p2.getFileName().toString())){
                switch(criteria){
                    case 0:
                        if(p1.toFile().lastModified() > p2.toFile().lastModified())
                            copieFichierAvecMemeNom(p1, p2);
                        else copieFichierAvecMemeNom(p2, p1);
                        break;
                    case 1:
                        if(p1.toFile().length() > p2.toFile().length())
                            copieFichierAvecMemeNom(p1, p2);
                        else copieFichierAvecMemeNom(p2, p1);
                        break;
                    case 2:
                        copieFichierAvecMemeNom(p1, p2);
                        break;
                    case 3:
                        copieFichierAvecMemeNom(p2, p1);
                        break;
                    default:
                        System.out.println("Aucun critère ne correspond à votre choix");
                        break;
                }
            }else{
                copieFichierAvecNomDifferent(p1, p2);
                copieFichierAvecNomDifferent(p2, p1);
                System.out.println("Les deux fichiers sont présents dans les deux dossiers");
            }
        }
    }


    public void copieFichierAvecMemeNom(Path source, Path cible){
        Path parent = cible.getParent();
        //suppression du fichier cible s'il existe déjà dans le dossier
        if(cible.toFile().delete())
            System.out.println("Fichier "+cible.getFileName()+" supprimé");
        try {
            Files.copy(source, Paths.get(parent.toString()+ File.separator+cible.getFileName().toString()));
            System.out.println("Fichier copié !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copieFichierAvecNomDifferent(Path source, Path cible){
        Path parent = cible.getParent();
        try {
            Files.copy(source, Paths.get(parent.toString()+ File.separator+source.getFileName().toString()));
            System.out.println("Fichier copié !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test(){
        Path p1 = Paths.get("/Users/francois-junioretoughe/Downloads/Test1/contenu-eBOOK-IEBI.pdf");
        Path p2 = Paths.get("/Users/francois-junioretoughe/Downloads/Test2/Fiches-Stratégie-Entreprise.pptx");
        SyncFile syncFile = new SyncFile();
        syncFile.syncFile(p1, p2, 3);
    }
}
