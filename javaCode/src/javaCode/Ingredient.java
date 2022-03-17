package javaCode;

public class Ingredient {
	// déclaration des variables
	private String name;
	private int quantity;
	
	
	// constructeur par défaut mets la quantité à-1 pour les ingredients non encore débloqués
	public Ingredient(String ingredientName)
	{
		this.name = ingredientName;
		this.quantity = -1;
	}
	
	// fonction pour obtenir la quantité d'ingredient 
	public int ingredientQuantity ()
	{
		return this.quantity;
	}
	
	// fonction pour changer la quantité de l'ingrédient
	public void setQuantity (int quantityUpdate)
	{
		if (this.quantity == -1 && quantityUpdate>0)
			this.quantity =0;
		if ((this.quantity + quantityUpdate)>=0)
			this.quantity += quantityUpdate;
		else 
		{
			// en cas de mise à jour impossible car update erroné
			System.out.println("erreur de quantité, la quantité deviendrait négative");
		}
	}
	
	
	
	
	
	

}
