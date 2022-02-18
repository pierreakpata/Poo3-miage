package etape5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CreerFichier {

    public void creerFichier(String nomFichier){
        File fichier = new File(nomFichier);
        if(fichier.exists()){
            System.out.println("Ce fichier existe déjà !");
            System.exit(-1);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisir du texte: ");
        String texte = scan.nextLine();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))){
            writer.write(texte);
            System.out.println("Fichier créer avec succès !");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreerFichier flux = new CreerFichier();
        flux.creerFichier("calibri.txt");
    }
}
