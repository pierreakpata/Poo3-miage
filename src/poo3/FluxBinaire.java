package poo3;

import java.io.*;

public class FluxBinaire {

    public void ecrireEntier(File file, int data){
        if(file.isDirectory()){
            System.out.println("Le fichier est un dossier");
            System.exit(-1);
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
            fos.write(data);
            fos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int lectureEntier(InputStream is){
        int data = -1;
        try {
            data = is.read();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return data;
        }
    }

    public static void test(){
        FluxBinaire flux = new FluxBinaire();
        File file = new File("exo");
        int var = 1;
        switch(var){
            case 0:
                //écriture
                flux.ecrireEntier(file, 12);
                flux.ecrireEntier(file, -25);
                flux.ecrireEntier(file, 4584789);
                flux.ecrireEntier(file, -1);
                flux.ecrireEntier(file, 17);
                flux.ecrireEntier(file, 56);
                break;
            case 1:
                //lecture
                try(FileInputStream fis = new FileInputStream(file)){
                    int data = flux.lectureEntier(fis);
                    while(data != -1){
                        System.out.println(data);
                        data = flux.lectureEntier(fis);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
