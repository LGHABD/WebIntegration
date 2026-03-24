package TP3;

public class Compte {
    int solde;
    String name;

    public Compte() {
    }

    public Compte(int solde, String name) {
        this.solde = solde;
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public int getsolde() {
        return solde;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setsolde(int solde) {
        this.solde = solde;
    }
}
