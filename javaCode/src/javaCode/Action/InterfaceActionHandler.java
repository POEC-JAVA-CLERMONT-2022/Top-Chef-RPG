package javaCode.Action;

public interface InterfaceActionHandler {
	
	// m�thode pour se connecter quand on a d�j� un compte
	public void logIn (String nameUser, String password);
	
	// m�thode pour s'inscrire quand on a  pas de compte
	public void signIn(String nameUser, String mail, String password);
	
	// cr�er un cuisinnier quand on en a pas
	public void creatCook(String nameCook);
	
	// utiliser un cuisinnier existant
	public void loadCook();
}
