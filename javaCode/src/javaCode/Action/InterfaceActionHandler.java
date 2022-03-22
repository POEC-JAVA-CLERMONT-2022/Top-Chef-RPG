package javaCode.Action;

public interface InterfaceActionHandler {
	
	// méthode pour se connecter quand on a déjà un compte
	public void logIn (String nameUser, String password);
	
	// méthode pour s'inscrire quand on a  pas de compte
	public void signIn(String nameUser, String mail, String password);
	
	// créer un cuisinnier quand on en a pas
	public void creatCook(String nameCook);
	
	// utiliser un cuisinnier existant
	public void loadCook();
	
	// fonction d'appel pour afficher le menu d'acceuil du site ( peut être pas utile pour le web ?)
	public void showWelcomeMenu();
}
