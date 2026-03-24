package project;


import java.util.LinkedList;



public class Consomateur extends Thread {
    private final File<Integer> file;
    private final int nbConsommations;

    public Consomateur(File<Integer> file, String nom, int nbConsommations) {
        super(nom);
        this.file = file;
        this.nbConsommations = nbConsommations;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < nbConsommations; i++) {
                int produit = file.retirer();
                System.out.println(" " + getName() + " a retiré " + produit );
                Thread.sleep(150); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}