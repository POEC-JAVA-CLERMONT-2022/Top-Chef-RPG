import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from "../../models/recipe";

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.scss']
})
export class RecipeComponent implements OnInit {


  @Input()  public recipe :Recipe = new Recipe();

  constructor() { }

  ngOnInit(): void {
    console.log(this.recipe.name)
    console.log(this.recipe.ingredientsRequired.toString())
    this.recipe.ingredientsRequired.
  }



}
