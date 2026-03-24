package Projeet;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebThread extends Thread {
    private Socket client;
    private String corps;

    public WebThread(Socket client, String corps) {
        this.client = client;
        this.corps=corps;
    }

    @Override
    public void run() {
        try {
            

        	String rep = "HTTP/1.0 200 OK\n\n"
 		           + this.corps;
                
 		PrintWriter out = new PrintWriter(this.client.getOutputStream());

   
   out.println(rep); 
   out.flush();
   this.client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}