package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrinterWriterTest {
String fname;
public PrinterWriterTest(String fname) {
	this.fname=fname;
	
}
public void writer() {
	 
	  try (PrintWriter out = new PrintWriter(new FileWriter(fname))) {
          out.println("Integration web ");
          out.println("jeudi 05 Mars 2026");
      } catch (IOException e) {
          System.out.println(e.getMessage());
      }
}
}
