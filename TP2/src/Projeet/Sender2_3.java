

	package Projeet;

	import java.net.DatagramPacket;
	import java.net.DatagramSocket;
	import java.net.InetAddress;
	import java.util.Random;


	public class Sender2_3 {
	public Sender2_3() {
		init();
		
	}
	public void init() {
		
		String[] proverbes = {
	            "Petit a petit, l'oiseau fait son nid.",
	            "L'habit ne fait pas le moine.",
	            "Qui vivra verra.",
	            "Après la pluie, le beau temps.",
	            "Mieux vaut tard que jamais."
	        };

	   
	        Random random = new Random();
	        String host = "localhost";
	        int port = 7676;

	        String message = proverbes[random.nextInt(proverbes.length)];
	    try (DatagramSocket socket = new DatagramSocket()) {
	        byte[] data = message.getBytes();
	        InetAddress adresse = InetAddress.getByName(host);

	        DatagramPacket packet = new DatagramPacket(data, data.length, adresse, port);
	        socket.send(packet);

	       

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   
	}
	public static void main(String[] args) {
	    new Sender2_3();
	    }

	}


