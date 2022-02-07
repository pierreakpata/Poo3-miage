package etape3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SimpleComp {

    public void compressionDossier(File nomDossier){
        if(!nomDossier.exists() || !nomDossier.isDirectory()){
            System.out.println("Le fichier n'existe pas ou n'est pas un dossier");
        }

        int BUFFER = 2048;
        try {
            //On crée le fichier zip
            Path newFile = Files.createFile(Paths.get(nomDossier.getParent()+File.separator+nomDossier.getName()+".zip"));
            FileOutputStream fos = new FileOutputStream(newFile.toFile());

            //On crée le flux de compression
            ZipOutputStream zipos = new ZipOutputStream(fos);

            File[] files = nomDossier.listFiles();
            for(int i=0; i<files.length; i++){
                if(files[i].isFile()){
                    byte[] data = new byte[BUFFER];
                    //On ouvre le flux sur le fichier à lire
                    FileInputStream fis = new FileInputStream(files[i]);

                    //On crée un item correspondant au fichier d’origine
                    ZipEntry ze = new ZipEntry(files[i].getName());

                    //On place l’item dans le ZIP
                    zipos.putNextEntry(ze);
                    int count;
                    //Tant qu’on peut lire
                    while ((count = fis.read(data, 0, BUFFER)) != -1) {
                        zipos.write(data, 0, count);
                    }
                    //On ferme l’item dans le zip
                    zipos.closeEntry();
                }
            }
            //On ferme le flux vers le ZIP
            zipos.close();

            System.out.println("Compression effectué avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test(){
        SimpleComp sc = new SimpleComp();
        File file = new File("C:\\Users\\p.akpata\\Documents\\Test1\\Selenium");
        sc.compressionDossier(file);
    }
}
