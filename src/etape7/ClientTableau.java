package etape7;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ClientTableau {

    public static void main(String[] args) {

        try {
            System.out.println("Je suis un client !");
            System.out.println("Je demande une connexion au serveur ...");
            Socket maSocket = new Socket("localhost",48);
            System.out.println("J'ai obtenu l'accès au serveur, je vais lui transmettre un tableau d'entier");
            OutputStream os = maSocket.getOutputStream();
            Integer[] tab = {1,2,3,4,5};
            System.out.println(Arrays.toString(tab));
            os.write(Arrays.toString(tab).getBytes());
            os.close();

            System.out.println("Fin client !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
