
package Projeet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver2_3 {
	
	public Receiver2_3() {
		UDP();
		
	}
  public void UDP() {
	  int port=7676;
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
	  
              new Receiver2_3();
          
  
  }}


