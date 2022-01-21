package poo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopierImage {

    public static void copierBin(File source, File dest){
        //vérifier l'extension du fichier source
        if(!getFileExtension(source.getName()).equals("png")){
            System.out.println("Le fichier doit avoir l'extension .png");
            System.exit(-1);
        }
        else if(!source.exists()) {
            System.out.println("Le fichier "+source.getPath()+" n'existe pas");
            System.exit(-1);
        }else if(dest.exists()){
            System.out.println("Le fichier "+dest.getPath()+" existe déjà");
            System.exit(-1);
        }else{
            try(FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(dest)){
                int data = fis.read();
                while(data != -1){
                    fos.write(data);
                    data = fis.read();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Fichier copié avec succès");
        }
    }

    public static String getFileExtension(String fileName){
        String fe = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            fe = fileName.substring(i+1);
        }
        return fe;
    }

    public static void test(){
        //création des fichiers source et destination
        File source = new File("/Users/francois-junioretoughe/Downloads/img/LOGO-BLANC.png");
        File dest = new File("/Users/francois-junioretoughe/Downloads/img2/LOGO-BLANC.png");

        //test de la méthode copierBin
        CopierImage.copierBin(source, dest);
    }
}
