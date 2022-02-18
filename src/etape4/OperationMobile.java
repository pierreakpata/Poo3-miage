package etape4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OperationMobile {

    public void save(String nomFichier, Mobile mobile){
        File fichier = new File(nomFichier);
        try(FileOutputStream fos = new FileOutputStream(fichier)){
            ObjectOutputStream buf = new ObjectOutputStream(fos);
            buf.writeObject(mobile);
            buf.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void save3Objets(String nomFichier, Mobile m1, Mobile m2, Mobile m3){
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(m1);mobiles.add(m2);mobiles.add(m3);
        File fichier = new File(nomFichier);
        try(FileOutputStream fos = new FileOutputStream(fichier)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mobiles);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveObjets(String nomFichier, List<Mobile> mobiles){
        File fichier = new File(nomFichier);
        try(FileOutputStream fos = new FileOutputStream(fichier)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mobiles);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Mobile load(String nomFichier){
        File fichier = new File(nomFichier);
        Mobile mobile= null;
        try(FileInputStream fis = new FileInputStream(fichier)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            mobile = (Mobile)ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return mobile;
        }
    }

    public List<Mobile> load3Objets(String nomFichier){
        List<Mobile> mobiles = null;
        File fichier = new File(nomFichier);
        try(FileInputStream fis = new FileInputStream(fichier)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            mobiles = (ArrayList<Mobile>)ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return mobiles;
        }
    }

    public List<Mobile> loadObjets(String nomFichier){
        List<Mobile> mobiles = null;
        File fichier = new File(nomFichier);
        try(FileInputStream fis = new FileInputStream(fichier)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            mobiles = (ArrayList<Mobile>)ois.readObject();
            Random r = new Random();
            for(Mobile m: mobiles){
                m.setPrix(r.nextInt(100));
            }
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return mobiles;
        }
    }

    public static void main(String[] args) {
        Mobile m1 = new Mobile("uix", 13, 210, true, 1200, 1);
        Mobile m2 = new Mobile("uix", 11, 210, true, 1200, 2);
        Mobile m3 = new Mobile("uix", 12, 210, true, 1200,3);
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(m1); mobiles.add(m2); mobiles.add(m3);
        OperationMobile om = new OperationMobile();
        om.saveObjets("C:\\Users\\p.akpata\\IdeaProjects\\Poo3-miage\\src\\data", mobiles);
        System.out.println(om.loadObjets("C:\\Users\\p.akpata\\IdeaProjects\\Poo3-miage\\src\\data"));
    }
}
