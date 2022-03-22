package Action;

import models.viewerConsole;

public class ConsoleServices implements InterfaceActionHandler{
	viewerConsole view ;
	ActionAdaptor actionAdaptor ;

	public ConsoleServices()
	{
		view = new viewerConsole();
		actionAdaptor = new ActionAdaptor();
	}

	// prend les parametre transmis par la console et appele le action provider
	@Override
	public void logIn(String nameUser, String password) {
		// TODO Auto-generated method stub
		actionAdaptor.logIn(nameUser, password);
	}

	@Override
	public void signIn(String nameUser, String mail, String password) {
		// TODO Auto-generated method stub
		actionAdaptor.signIn(nameUser, mail, password);
	}

	@Override
	public void creatCook(String nameCook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showWelcomeMenu() {
		// TODO Auto-generated method stub
		int logChoice = view.menuAcceuil();
		// l'utilisateur veux se connecter avec son compte existant
		if (logChoice == 1)
		{
			// appel de la fonction de connection
			String userName = view.askText("Veuillez entrer un nom d'utilisateur");
			String userPassword = view.askText("veuillez entrer un mot de passe");
			logIn(userName, userPassword);
		}
		if (logChoice == 2)
		{
			// appel de la fonction de creation de compte
			String userName = view.askText("Veuillez entrer un nom d'utilisateur");
			String userMail = view.askText("Veuillez entrer un mail");
			String userPassword = view.askText("veuillez entrer un mot de passe");
			signIn(userName, userMail, userPassword);
		}


	}



}
