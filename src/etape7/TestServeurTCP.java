package etape7;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServeurTCP {

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
            ServerSocket leStandard = new ServerSocket(4848);
            System.out.println("Je suis en attente d'un client ... ");
            // on se place en poisition d'accepter des connexions entrantes
            Socket comm = leStandard.accept();
            System.out.println("On a accepté un client !");
            // Affichage de la donnée saisie par le client
            InputStream is = comm.getInputStream();
            System.out.println("L'adresse IP du client: "+ convertToString(is.readAllBytes()));

            System.out.println("Je suis client !");
            Socket maSocket = new Socket("localhost",4747);
            System.out.println("J'ai obtenu l'accès au serveur, je vais lui transmettre mon adresse ip");
            OutputStream os = maSocket.getOutputStream();
            os.write(("192.168.113.10").getBytes());
            os.close();
            System.out.println("Fin !");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
