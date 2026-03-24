package Projeet;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
public class MulticastReceiver {
    private static final String address = "224.0.0.1";
    private static final int port = 8686;

    public static void main(String[] args) {
        MulticastSocket socket = null;

        try {
            InetAddress add = InetAddress.getByName(address);
            socket = new MulticastSocket(null);
            socket.setReuseAddress(true);
            socket.bind(new InetSocketAddress(port));
            socket.joinGroup(add);
            System.out.println("MulticastReceiver en écoute ......");
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData());
                System.out.println("Message reçu : " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}