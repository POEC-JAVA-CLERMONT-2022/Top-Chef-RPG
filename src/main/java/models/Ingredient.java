package models;

public class Ingredient {
	// d�claration des variables
	private String name;
	private int quantity;
	
	
	// constructeur par d�faut mets la quantit� �-1 pour les ingredients non encore d�bloqu�s
	public Ingredient(String ingredientName)
	{
		this.name = ingredientName;
		this.quantity = -1;
	}
	
	// fonction pour obtenir la quantit� d'ingredient 
	public int ingredientQuantity ()
	{
		return this.quantity;
	}
	
	// fonction pour changer la quantit� de l'ingr�dient
	public void setQuantity (int quantityUpdate)
	{
		if (this.quantity == -1 && quantityUpdate>0)
			this.quantity =0;
		if ((this.quantity + quantityUpdate)>=0)
			this.quantity += quantityUpdate;
		else 
		{
			// en cas de mise � jour impossible car update erron�
			System.out.println("erreur de quantit�, la quantit� deviendrait n�gative");
		}
	}
	
	
	
	
	
	

}
