package project;

public class threadletters extends Thread {

	public threadletters() { super();} 
	public threadletters(String n) { super(n);} 
	public void run() {
		for	(char i ='a'; i<='z';i++) {
			System.out.print( "\n thread "+Thread.currentThread()+"est a la valeur"+i);
		};
	}
}
