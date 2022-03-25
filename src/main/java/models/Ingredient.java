package models;

import javax.persistence.*;

@Entity
public class Ingredient {
	// d�claration des variables

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;

	@Column(name = "IngredientName")
	private String name;

	@Column(name ="ingredienQuantity")
	private int quantity;

	/*
	@JoinColumn (name ="IdCook")

	private int idCook;
*/
	// constructeur par défaut
	public Ingredient()
	{
		this.quantity = -1;
	}
	
	// surchage du constructeur par défaut avec passage du nom de l'ingredient
	public Ingredient(String ingredientName)
	{
		this.name = ingredientName;
		this.quantity = -1;
	}
	
	// fonction pour obtenir la quantit� d'ingredient 
	public int getIngredientQuantity ()
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
