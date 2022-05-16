import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CookComponent} from "./cook/cook.component";
import {FrigoComponent} from "./frigo/frigo.component";
import {RecipeComponent} from "./recipe/recipe.component";
import {LessonComponent} from "./lesson/lesson.component";
import {MainComponent} from "./main/main.component";

const routes: Routes = [
  {path : 'cook' , component : CookComponent},
  {path : 'cook/:id' , component :CookComponent},
  {path : 'frigo' , component : FrigoComponent },
  {path : 'recipe' , component : RecipeComponent},
  {path : 'lesson' , component : LessonComponent},
  {path : 'home/:id' , component : MainComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
