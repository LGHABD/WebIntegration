package Projeet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.swing.SwingUtilities;

public class Receiver {
	
	public Receiver(int port) {
		UDP(port);
		
	}
  public void UDP(int port) {
	 // int port=7676;
	  try (DatagramSocket socket = new DatagramSocket(port)) {
          System.out.println("Receiver démarré..........." );

          byte[] buffer = new byte[1024];

          while (true) {
              DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
              socket.receive(packet);

              String message = new String( packet.getData() );

              System.out.println("Message reçu de " 
                      + packet.getAddress().getHostAddress()
                      + ":" + packet.getPort()
                      + " -> " + message);
          }

      } catch (Exception e) {
          e.getMessage();
      }
  }


  public static void main(String[] args) {
	  if (args.length > 0) {
          try {
              int port = Integer.parseInt(args[0]);
              new Receiver(port);
          } catch (Exception e) {
              System.out.println("Port invalide"+e.getMessage());
          }
      }

     
      }
  
  }

