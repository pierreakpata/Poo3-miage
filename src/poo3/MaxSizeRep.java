package poo3;

import java.io.File;
import java.util.Scanner;

public class MaxSizeRep {

    public void maxSizeRep(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Saisir un nom de dossier: ");
        String nomDossier = scan.nextLine();
        File file = new File(nomDossier);

        if(!file.exists() || !file.isDirectory()){
            System.out.println("Le fichier spécifier n'existe pas ou n'est pas un dossier !");
        }else{
            String nomRepPlusGrand = "";
            long maxiRep = 0;
            File[] files = file.listFiles();
            for (File temp: files) {
                if(temp.isDirectory()){
                    long taille = tailleDossier(temp);
                    if(taille > maxiRep){
                        maxiRep = taille;
                        nomRepPlusGrand = temp.getName();
                    }
                }
            }
            System.out.println("Le plus grand dossier est: "+nomRepPlusGrand);
        }
    }

    public long tailleDossier(File directory) {
        long length = 0;
        File[] files = directory.listFiles();
        if (files != null){
            for (File file : directory.listFiles()) {
                if (file.isFile())
                    length += file.length();
                else
                    length += tailleDossier(file);
            }
        }
        return length;
    }

}
