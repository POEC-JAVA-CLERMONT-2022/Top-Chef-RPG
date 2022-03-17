package javaCode;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User("robert", "mail", "password");
		user.createCook("cuistot");
		user.saveCook();
	}

}
