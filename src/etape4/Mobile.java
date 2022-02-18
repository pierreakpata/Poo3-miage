package etape4;

import java.io.Serializable;

public class Mobile implements Serializable {

    private static final long serialVersionUID = 32L;
    private String modele;
    private int NbPixelsFront;
    private double memoire;
    private boolean capacite5G;
    private transient double prix;
    private double masse;

    public Mobile(String modele, int nbPixelsFront, double memoire, boolean capacite5G, double prix, double masse){
        this.modele = modele;
        this.NbPixelsFront = nbPixelsFront;
        this.memoire = memoire;
        this.capacite5G = capacite5G;
        this.prix = prix;
        this.masse = masse;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "modele='" + modele + '\'' +
                ", NbPixelsFront=" + NbPixelsFront +
                ", memoire=" + memoire +
                ", capacite5G=" + capacite5G +
                ", prix=" + prix +
                ", masse=" + masse +
                '}';
    }
}
