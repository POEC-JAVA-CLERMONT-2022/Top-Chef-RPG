import {Ingredient} from "./Ingredient";

export class ResultRecipe{

  ingredientLoot : Array<Ingredient> = new Array<Ingredient>();
  ingredientUsed :Array<Ingredient> =new Array<Ingredient>();
  experienceGain : number =0 ;
  textRetour : string ="";
  errorMessage : string ="";
  succes : boolean=true ;

  constructor() {
  }
}
