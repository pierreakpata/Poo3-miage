package etape3;

import java.io.*;

public class CopieFichierBinaire {

    public void copieOctet(File source, File dest){
        if(!source.exists()) {
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

    public void copieGroupe64Octet(File source, File dest){
        if(!source.exists()) {
            System.out.println("Le fichier "+source.getPath()+" n'existe pas");
            System.exit(-1);
        }else if(dest.exists()){
            System.out.println("Le fichier "+dest.getPath()+" existe déjà");
            System.exit(-1);
        }else{
            try(FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(dest)){
                byte[] bytes = new byte[64];
                fis.read(bytes);
                fos.write(bytes);
                while(fis.available() > 0){
                    fis.read(bytes);
                    fos.write(bytes);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Fichier copié avec succès");
        }
    }

    public void copieBufferedStream(File source, File dest){
        if(!source.exists()) {
            System.out.println("Le fichier "+source.getPath()+" n'existe pas");
            System.exit(-1);
        }else if(dest.exists()){
            System.out.println("Le fichier "+dest.getPath()+" existe déjà");
            System.exit(-1);
        }else{
            try(FileInputStream fis = new FileInputStream(source); FileOutputStream fos = new FileOutputStream(dest)){
                BufferedInputStream bis = new BufferedInputStream(fis);
                fos.write(bis.readAllBytes());

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Fichier copié avec succès");
        }
    }

    public void test(){
        long startTime, endTime;
        //création des fichiers
        File source = new File("C:\\Users\\p.akpata\\Documents\\Test1\\logo-amp.png");
        File dest = new File("C:\\Users\\p.akpata\\Documents\\Test2\\copie2.png");

        //première méthode
        /*CopieFichierBinaire cp1 = new CopieFichierBinaire();
        startTime = System.nanoTime();
        cp1.copieOctet(source, dest);
        endTime = System.nanoTime();
        System.out.println("Le temps mis par copie Octet/Octet est: "+(endTime-startTime))
        Le temps d'exécution est : 43.999.400 ns */;

        //deuxième méthode
        /*CopieFichierBinaire cp2 = new CopieFichierBinaire();
        startTime = System.nanoTime();
        cp2.copieGroupe64Octet(source, dest);
        endTime = System.nanoTime();
        System.out.println("Le temps mis par copie groupe Octet 64 est: "+(endTime-startTime));
        Le temps d'exécution est: 3.923.800  ns */

        //troisième méthode
        CopieFichierBinaire cp3 = new CopieFichierBinaire();
        startTime = System.nanoTime();
        cp3.copieBufferedStream(source, dest);
        endTime = System.nanoTime();
        System.out.println("Le temps mis par copie BufferedStream est: "+(endTime-startTime));
        /*Le temps d'exécution est: 1.524.800  ns */

        /**
         * COnclusion: On conclus que la copie BufferedStream est meilleur par rapport aux autres
         */
    }
}
