package etape5;

import java.util.Scanner;

public class Redirection {

    public static void redirection(){
        Scanner scan = new Scanner(System.in);
        String data;
        String [] sub;
        do{
            System.out.println("Entrer des données et terminer par *fin*: ");
            data = scan.nextLine();
            sub = data.split(" ");
        }while(!sub[sub.length-1].equals("*fin*"));
        System.out.println(data);

    }

    public static void main(String[] args) {
        Redirection.redirection();
    }
}
