package etape6;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;


public class WordInDirectory {

    public static void wordInDirectory(String mot, String nomDossier){
        File dossier = new File(nomDossier);
        if(!dossier.isDirectory()){
            System.out.println("Il ne s'agit pas d'un dossier");
            System.exit(-1);
        }

        File[] files = dossier.listFiles();
        for(int i=0; i<files.length; i++){
            if(files[i].isFile() && motEstPresentDansUnFichier(mot, files[i]))
                System.out.println(files[i].getName());
            else if(files[i].isDirectory())
                wordInDirectory(mot, files[i].getAbsolutePath());
        }

    }

    public static boolean motEstPresentDansUnFichier(String mot, File fichier){
        if(!fichier.exists()){
            System.out.println("Le fichier n'existe pas");
            System.exit(-1);
        }
        boolean res = false;
        try {
            String typeMime= Files.probeContentType(fichier.toPath());
            if ((typeMime!=null) && (typeMime.contains("text") || typeMime.contains("pdf") || typeMime.contains("openxmlformats") )) {
                List<String> content = Files.readAllLines(fichier.toPath(), Charset.forName("ISO-8859-1"));
                for (String ligne : content) {
                    if(ligne.contains(mot)){
                        res = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }

    public static void main(String[] args) {
        wordInDirectory("chaque", "C:\\Users\\p.akpata\\Downloads\\rep");
    }
}
