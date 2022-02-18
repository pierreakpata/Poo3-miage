package etape7;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestClientTCP {

    public static void main(String[] args) {

        try {
            System.out.println("Je suis un client !");
            System.out.println("Je demande une connexion au serveur ...");
            Socket maSocket = new Socket("localhost",4848);
            System.out.println("J'ai obtenu l'accès au serveur, je vais lui transmettre mon adresse ip");
            OutputStream os = maSocket.getOutputStream();
            os.write(("192.168.12.1").getBytes());
            os.close();


            System.out.println("Je suis Serveur !");
            ServerSocket leStandard = new ServerSocket(4747);
            Socket comm = leStandard.accept();
            System.out.println("J'attends une conexion ...");
            InputStream is = comm.getInputStream();
            System.out.println("L'adresse IP du client: "+ TestServeurTCP.convertToString(is.readAllBytes()));
            is.close();

            System.out.println("Merci, à bientôt !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
