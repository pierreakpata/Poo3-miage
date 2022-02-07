package etape3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Pattern {

    public void searchAndReplace(byte[] motif, byte[] subst, String nomFile){
        File fichier = new File(nomFile);
        if(!fichier.exists() || !fichier.isFile()){
            System.out.println("Le fichier n'existe pas ou est un dossier");
            System.exit(-1);
        }
        if(motif.length != subst.length){
            System.out.println("Les deux sequences n'ont pas la même taille");
            System.exit(-1);
        }
        try(FileInputStream fis = new FileInputStream(fichier)) {
            byte[] tab = fis.readAllBytes();
            //afficher le contenu du fichier avant traitement
            showTab(tab);
            for(int i=0; i<tab.length; i++)
                traitementParPosition(tab, motif, subst, fichier, i);

            //afficher le contenu après traitement
            showTab(tab);
            System.out.println("Fin !");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void traitementParPosition(byte[] tab, byte[] motif, byte[] subst, File fichier, int pos){
        byte[] temp = new byte[motif.length];
        int k;
        for(int i=pos; i<tab.length; i=i+temp.length){
            k=i;
            //recherche d'une occurence
            for(int j=0; j<temp.length; j++){
                if(k < tab.length )
                    temp[j]=tab[k];
                else
                    temp[j]=0;
                k++;
            }
            //on verifie si temp est une occurence de motif
            if(comparerDeuxSequence(motif, temp)){
                int p = i;
                for(int index=0; index<subst.length; index++){
                    tab[p]= subst[index];
                    p++;
                }
            }
        }

        try(FileOutputStream fos = new FileOutputStream(fichier)) {
            fos.write(tab);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean comparerDeuxSequence(byte[] b1, byte[] b2){
        if(b1.length == b2.length){
            for(int i=0; i<b1.length; i++){
                if(b1[i] != b2[i]) return false;
            }
            return true;
        }else return false;
    }

    public void showTab(byte[] t){
        for(int i=0; i<t.length; i++)
            System.out.print((char)t[i]);
        System.out.println();
    }

    public void test(){
        byte[] b1 = {'8','9','7'};
        byte[] b2 = {'e','e','e'};
        Pattern p = new Pattern();
        p.searchAndReplace(b1,b2, "C:\\Users\\p.akpata\\IdeaProjects\\Poo3-miage\\src\\test");
    }
}
