package project;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {

        File<Integer> file = new File<>(5);
        Producteur p1 = new Producteur(file, "P1", 20);
        Producteur p2 = new Producteur(file, "P2", 20);
        Consomateur c1 = new Consomateur(file, "C1", 20);
        Consomateur c2 = new Consomateur(file, "C2", 20);

        p1.start(); p2.start();
        c1.start(); c2.start();
        p1.join(); p2.join();
        c1.join(); c2.join();

    }
}