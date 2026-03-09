package project;

 public class Compte {
	public static int solde =1000;
	
	public int getSolde() {
        return solde;
    }
	public void retirer(int montant) {
		Compte.solde-=montant;
		System.out.print("L'operation est effectuee \n");	
	}	
}
