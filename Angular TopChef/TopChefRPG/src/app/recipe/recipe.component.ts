import {Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import {Recipe} from "../../models/recipe";
import {RequestServiceService} from "../../services/request-service.service";


@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.scss']
})
export class RecipeComponent implements OnInit {


  @Input()
  public recipes :Array<Recipe> = new Array<Recipe>();


  @Output()
  public idRecipe : EventEmitter<number> =new EventEmitter<number>();



  constructor(private request : RequestServiceService) { }

  ngOnInit(): void {

  }


  doRecipe(idRecipe :number){
    console.log("go make recipe "+ idRecipe);
    // appel de la main avec la recette clickée
    this.idRecipe.emit(idRecipe);
  }

}
