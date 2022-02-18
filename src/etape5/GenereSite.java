package etape5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class GenereSite {

    public static void genereSite(String cheminRep){
        File rep = new File(cheminRep);
        if(!rep.exists() || !rep.isDirectory()){
            System.out.println("Le chemin spécifier n'existe pas ou n'est pas un dossier");
            System.exit(-1);
        }
        File config = new File(cheminRep+File.separator+"config.txt");
        if(!config.exists() || !config.isFile()){
            System.out.println("Fichier non existant !");
            System.exit(-1);
        }
        File sousRep = new File(cheminRep +File.separator+ "prod");
        if(sousRep.exists()){
            System.out.println("Le repertoire prod existe déjà !");
            System.exit(-1);
        }

        //lecture du fichier config
        try(BufferedReader reader = new BufferedReader(new FileReader(config))){
            List<String> files = new ArrayList<>();
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                files.add(ligne);
            }

            //récupération du contenu des fichiers d'enTete et de pied de page
            String enTete = lireFichier(new File(cheminRep +File.separator+ files.get(0)));
            String piedPage = lireFichier(new File(cheminRep+File.separator+files.get(1)));

            //créer le sous repertoire prod
            Path prod = Files.createDirectories(Paths.get(cheminRep +File.separator+ "prod"));

            int j=1;
            for(int i=2; i<files.size(); i++){
                String contenu = lireFichier(new File(cheminRep +File.separator+ files.get(i)));
                String cheminPageWeb = prod.toFile().getAbsolutePath() +File.separator+ "contenu"+j+".htm";

                creerPageWeb(cheminPageWeb, enTete, contenu, piedPage);
                j++;
            }
            System.out.println("Pages web générées !");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void creerPageWeb(String nomFichier, String enTete, String corps, String pied){
        File fichier = new File(nomFichier);
        if(fichier.exists()){
            System.out.println("Ce fichier existe déjà !");
            System.exit(-1);
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))){
            writer.write(enTete);
            writer.write("<br><br>");
            writer.write(corps);
            writer.write("<br><br>");
            writer.write(pied);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String lireFichier(File fichier){
        if(!fichier.exists()){
            System.out.println("Le fichier n'existe pas");
            System.exit(-1);
        }
        String texte = null;
        try( BufferedReader reader = new BufferedReader(new FileReader(fichier.getAbsolutePath())) ){
            texte = reader.readLine();
            String temp;
            while ((temp = reader.readLine()) != null) {
                texte+="<br>";
                texte+=temp;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            return texte;
        }
    }

    public static void main(String[] args) {
        GenereSite.genereSite("C:\\Users\\p.akpata\\Downloads\\rep");
    }
}
