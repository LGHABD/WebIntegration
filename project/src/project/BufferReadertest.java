package project;
import java.io.*;
public class BufferReadertest {
 String fname ;
 public BufferReadertest(String  f) {
	 this.fname=f;
 }
 public void read() {
	 String line=null;
	 try {
		 BufferedReader in= new BufferedReader(new FileReader(fname));
		 while ((line = in.readLine()) != null) {
             System.out.println(line);
         }

	 }catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
 }
}
