package Projeet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;
import java.util.Scanner;

public class Sender {
public Sender() {
	init();
	
}
public void init() {
	//String message = "bonjour tout le monde";
   // String host = "localhost";
    //int port = 7676;
	String[] proverbes = {
            "Petit a petit, l'oiseau fait son nid.",
            "L'habit ne fait pas le moine.",
            "Qui vivra verra.",
            "Après la pluie, le beau temps.",
            "Mieux vaut tard que jamais."
        };

        Scanner clavier = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Entrez l'hôte: ");
        String host = clavier.nextLine();
        System.out.print("Entrez le port : ");
        int port = Integer.parseInt(clavier.nextLine());

        String message = proverbes[random.nextInt(proverbes.length)];
    try (DatagramSocket socket = new DatagramSocket()) {
        byte[] data = message.getBytes();
        InetAddress adresse = InetAddress.getByName(host);

        DatagramPacket packet = new DatagramPacket(data, data.length, adresse, port);
        socket.send(packet);

       

    } catch (Exception e) {
        e.printStackTrace();
    }
    clavier.close();
}
public static void main(String[] args) {
    new Sender();
    }

}
