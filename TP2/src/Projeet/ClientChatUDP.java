package Projeet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

	public class ClientChatUDP {

	    private static final String address = "224.0.0.1";
	    private static final int port = 8686;
	    public static void main(String[] args) {
	        try {
	            String pseudo;

	            if (args.length > 0) {
	                pseudo = args[0];
	            } else {
	                BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
	                System.out.print("Entrez votre pseudo : ");
	                pseudo = clavier.readLine();
	            }
	            InetAddress groupe = InetAddress.getByName(address);
	            MulticastSocket socket = new MulticastSocket(null);
	            socket.setReuseAddress(true);
	            socket.bind(new InetSocketAddress(port));
	            socket.joinGroup(groupe);
	            String pseudoFinal = pseudo;
	            Thread reception = new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    try {
	                        byte[] buffer = new byte[1024];
	                        while (true) {
	                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	                            socket.receive(packet);
	                            String message = new String(packet.getData());
	                            System.out.println(message);
	                        }
	                    } catch (Exception e) {
	                        System.out.println(" .");
	                    }
	                }
	            });

	            reception.start();

	            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
	            System.out.println("Tapez le message ou /quit pour quitter la conversation");
	            while (true) {
	                String texte = clavier.readLine();
	                if (texte.equalsIgnoreCase("/quit")) {
	                    break;
	                }
	                String message = pseudoFinal + " : " + texte;
	                byte[] data = message.getBytes(StandardCharsets.UTF_8);
	                DatagramPacket packet = new DatagramPacket(data, data.length, groupe, port);
	                socket.send(packet);
	            }
	            socket.leaveGroup(groupe);
	            socket.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
