package javaCode.Action;

import javaCode.Action.ConsolClass.viewerConsole;

public class ConsoleServices implements InterfaceActionHandler{
	viewerConsole view ;
	
	public ConsoleServices()
	{
		view = new viewerConsole();
	}

	@Override
	public void logIn(String nameUser, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signIn(String nameUser, String mail, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creatCook(String nameCook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadCook() {
		// TODO Auto-generated method stub
		
	}

}
