package javaCode;

import javaCode.dataConnection.DataAdaptor;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*User user = new User("robert", "mail", "password");
		user.createCook("cuistot");
		user.saveCook();*/
		DataAdaptor da = new DataAdaptor();
		for (Recipe r : da.getRecipe())
		{
			System.out.println(r);
		}
		
	}

}
