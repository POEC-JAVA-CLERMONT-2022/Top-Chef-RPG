package javaCode.Action.ConsolClass;

import java.util.Scanner;

public class viewerConsole {
	Scanner sc ;
	
	public viewerConsole()
	{
		sc = new Scanner(System.in);
	}
	
	public void imp(String  text)
	{
		System.out.println(text);
	}
	
	public String askText(String question)
	{
		imp(question);
		return sc.nextLine();
	}
	
	public int askInt(String question)
	{
		imp(question);
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	public int menuAcceuil ()
	{
		imp("############## Acceuil ##############");
		imp("se connecter    1");
		imp("creer un compte     2");
		imp(" quitter  3");
		int choice = sc.nextInt();
		sc.nextLine();		
		return choice;
	}
	
	
	
}
