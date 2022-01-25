package poo3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SynchroniserDossiers {

    /**
     * Synchronise des dossiers
     * @param rep1
     * @param rep2
     * @param critere
     */
    public static void synchroniserDossiers(File rep1, File rep2, int critere){

        if (!rep1.exists() || !rep2.exists()){
            System.out.println("Un des deux répertoires n'existe pas !");
            System.exit(-1);
        }
        if(!rep1.isDirectory() || !rep2.isDirectory()){
            System.out.println("Les deux paramètres doivent être des dossiers");
            System.exit(-1);
        }
        if(rep1.getPath().equals(rep2.getPath())){
            System.out.println("Les deux répertoires ne doivent pas être les mêmes");
            System.exit(-1);
        }else{
            File[] contenuRep2 = rep2.listFiles();
            copierContenuDossier(rep1, rep2, critere);
            copierFichiersDansDossier(contenuRep2, rep1, critere);
            System.out.println("Les dossiers ont été synchroniser avec succès");
        }
    }

    /**
     * Copie un fichier source dans un repertoire.
     * @param source
     * @param dest
     */
    public static void copieFichier(Path source, Path dest, int critere){
        if(!dest.toFile().exists() || !dest.toFile().isDirectory()){
            System.out.println("Le fichier destination n'existe pas ou n'est pas un dossier");
            System.exit(-1);
        }
        if(!source.toFile().exists() || !source.toFile().isFile()){
            System.out.println("Le fichier source n'existe pas ou est présent comme un répertoire");
            System.exit(-1);
        }
        try {
            Path fichierDest = Paths.get(dest.toString()+ File.separator+source.getFileName().toString());
            if(!fichierDest.toFile().exists())
                Files.copy(source, fichierDest);
            else{
                switch(critere){
                    //date la plus récentes
                    case 0:
                        if(source.toFile().lastModified() > fichierDest.toFile().lastModified())
                            copieFichierAvecMemeNom(source, fichierDest);
                        break;
                    //fichier le plus volumineux
                    case 1:
                        if(source.toFile().length() > fichierDest.toFile().length())
                            copieFichierAvecMemeNom(source, fichierDest);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copie d'un fichier portant le même nom que la cible.
     * @param source
     * @param cible
     */
    public static void copieFichierAvecMemeNom(Path source, Path cible){
        //suppression du fichier cible s'il existe déjà dans le dossier
        if(cible.toFile().delete())
            System.out.println("Fichier "+cible.getFileName()+" supprimé");
        try {
            Files.copy(source, cible);
            System.out.println("Fichier copié !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copie le contenu du dossier source dans un dossier destination.
     * @param dossierSource
     * @param dossierDest
     */
    public static void copierContenuDossier(File dossierSource, File dossierDest, int critere){
        //recupérer le contenu du dossier source et copie dans le dossier destination
        File[] files = dossierSource.listFiles();
        copierFichiersDansDossier(files, dossierDest, critere);
    }

    /**
     * Copie un ensemble de fichiers dans un repertoire.
     * @param files
     * @param dossierDest
     */
    public static void copierFichiersDansDossier(File[] files, File dossierDest, int critere){
        for(int i=0; i<files.length; i++){
            if(files[i].isFile())
                copieFichier(files[i].toPath(), dossierDest.toPath(), critere);
            else{
                //construction du chemin sous dossier
                Path chemin = Paths.get(dossierDest.toPath().toString()+File.separator+files[i].getName());
                try {
                    if(!chemin.toFile().exists())
                        Files.createDirectories(chemin);
                    copierContenuDossier(files[i], chemin.toFile(), critere);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * supprime le contenu d'un dossier.
     * @param dossier
     */
    public static void supprimerContenuDossier(File dossier){
        if(!dossier.exists() || !dossier.isDirectory()){
            System.out.println("Imppossible de supprimer ce fichier car il n'existe pas ou n'est pas un dossier");
            System.exit(-1);
        }
        File[] files = dossier.listFiles();
        for (int i=0; i<files.length; i++){
            files[i].delete();
        }
    }


    public static void test(){
        File rep1 = new File("/Users/francois-junioretoughe/Downloads/Test1");
        File rep2 = new File("/Users/francois-junioretoughe/Downloads/Test2");
        SynchroniserDossiers.synchroniserDossiers(rep1, rep2, 0);

    }
}
