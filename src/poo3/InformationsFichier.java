package poo3;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InformationsFichier {

    public void informationsFichier(String fileName){
        File file = new File(fileName);

        if(!file.exists() || file.isDirectory()){
            System.out.println("Le fichier doit exister et ne pas être un dossier");
            System.exit(-1);
        }else{
            try{
                System.out.println("Le nom du fichier: "+file.getName());
                System.out.println("Le chemin absolue: "+file.getAbsolutePath());
                System.out.println("Le chemin canonique: "+file.getCanonicalPath());
                System.out.println("La taille du fichier: "+file.getTotalSpace());
                System.out.println("Droit d'écriture: "+file.canWrite());
                System.out.println("Droit de lecture: "+file.canRead());
                System.out.println("Droit d'exécution: "+file.canExecute());
                System.out.println("La date de la dernière modification: "+file.lastModified());
            }catch (Exception e){

            }
        }

    }

    public static void main(String[] args) {
	    //InformationsFichier infosFile = new InformationsFichier();
        //infosFile.informationsFichier("/Users/francois-junioretoughe/Downloads/Appelés-à-conquérir.pdf");
        //DeplacerFichier d = new DeplacerFichier();
        //d.deplacerFichier("/Users/francois-junioretoughe/Downloads/Appelés-à-conquérir.pdf","/Users/francois-junioretoughe/Downloads/Test");
        //MaxSizeRep ma = new MaxSizeRep();
        //ma.maxSizeRep();
        /*BackupFile back = new BackupFile();
        back.copierFichier("/Users/francois-junioretoughe/Downloads/intercultural-MIAGE2021.pdf");*/

        //TestSyncFile
        //SyncFile.test();

        //Test de FluxBinaire
        //FluxBinaire.test();

        //Test de CopierImage
        CopierImage.test();


    }
}
