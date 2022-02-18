package etape4;

import java.io.Serializable;
import java.util.List;

public class Famille implements Serializable {

    private static final long serialVersionUID = 21L;
    private String nomFamille;
    private String prenomPere;
    private String prenomMere;
    private String nomJeuneFille;
    List<Famille> familles;

    public Famille(String nomFamille, String prenomPere, String prenomMere, String nomJeuneFille, List<Famille> famillesEngendre){
        this.nomFamille = nomFamille;
        this.prenomPere = prenomPere;
        this.prenomMere = prenomMere;
        this.nomJeuneFille = nomJeuneFille;
        familles = famillesEngendre;
    }

    @Override
    public String toString() {
        return "Famille{" +
                "nomFamille='" + nomFamille + '\'' +
                ", prenomPere='" + prenomPere + '\'' +
                ", prenomMere='" + prenomMere + '\'' +
                ", nomJeuneFille='" + nomJeuneFille + '\'' +
                ", familles=" + familles +
                '}';
    }
}
