package etape7;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTableau {

    public static String convertToString(byte[] tab){
        String res="";
        for(int i=0; i<tab.length; i++){
            res+=(char)tab[i];
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            // creation de la socket de connexion
            System.out.println("Je suis un serveur  !");
            ServerSocket leStandard = new ServerSocket(48);
            System.out.println("Je suis en attente d'un client ... ");
            // on se place en poisition d'accepter des connexions entrantes
            Socket comm = leStandard.accept();
            System.out.println("On a accepté un client !");
            // Affichage de la donnée saisie par le client
            InputStream is = comm.getInputStream();
            System.out.println("Tableau envoyé par le client: "+ convertToString(is.readAllBytes()));

            System.out.println("Fin Serveur !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
