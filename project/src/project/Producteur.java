package project;

import java.util.Random;

public class Producteur extends Thread {
    private final File<Integer> file;
    private final int nbProduits;
    private final Random rnd = new Random();

    public Producteur(File<Integer> file, String nom, int nbProduits) {
        super(nom); 
        this.file = file;
        this.nbProduits = nbProduits;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < nbProduits; i++) {
                int produit = rnd.nextInt(1000);
                file.deposer(produit);
                System.out.println(getName() + " a déposé " + produit );
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}