package Projeet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;
import java.util.Random;
public class MulticastSender {
    private static final String address = "224.0.0.1";
    private static final int port = 8686;

    public static void main(String[] args) {
        String[] proverbes = {
            "Petit a petit, l'oiseau fait son nid.",
            "L'habit ne fait pas le moine.",
            "Qui vivra verra.",
            "Apres la pluie, le beau temps.",
            "Mieux vaut tard que jamais."
        };

        try {
            Random rnd = new Random();
            String message = proverbes[rnd.nextInt(proverbes.length)];
            InetAddress groupe = InetAddress.getByName(address);
            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            MulticastSocket socket = new MulticastSocket();
            DatagramPacket packet = new DatagramPacket(data, data.length, groupe, port);
            socket.send(packet);
            System.out.println("Proverbe envoyé ----> " + message);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}