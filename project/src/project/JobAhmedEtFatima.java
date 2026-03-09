package project;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class JobAhmedEtFatima implements Runnable  {
 
	Compte compte;
	 private final Lock lock = new ReentrantLock();
	public JobAhmedEtFatima(Compte compte) {
        this.compte = compte;
    }
	//synchronized public boolean doRetrait(int montant) throws InterruptedException {
	 public boolean doRetrait(int montant) throws InterruptedException {

        String nom = Thread.currentThread().getName();
        lock.lock();
       try { if (compte.getSolde() >= montant) {
            System.out.println(nom + " voit solde=" + compte.getSolde() + " et veut retirer " + montant);
            Thread.sleep(200);
            compte.retirer(montant);
            return true;
        } else {
            System.out.println( nom + " solde insuffisant (" + compte.getSolde() + "), retrait refusé");
            return false;
            
        } } finally {lock.unlock();
        } }
	 
	@Override
	public void run() {
		 for (int i = 0; i < 120; i++) {
	            try {
	                if (!doRetrait(10)) break;
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                break;
	            }
	        }
	}
	public static void main(String[] args) {
        Compte compte = new Compte();
        Runnable job = new JobAhmedEtFatima(compte); // même Runnable partagé

        Thread ahmed  = new Thread(job, "AHMED");
        Thread fatima = new Thread(job, "FATIMA");

        ahmed.start();
        fatima.start();
    }

}
