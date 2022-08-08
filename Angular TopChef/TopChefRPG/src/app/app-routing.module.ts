import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CookComponent} from "./cook/cook.component";
import {FrigoComponent} from "./frigo/frigo.component";
import {RecipeComponent} from "./recipe/recipe.component";
import {LessonComponent} from "./lesson/lesson.component";
import {MainComponent} from "./main/main.component";
import {SignInComponent} from "./Authentication/sign-in/sign-in.component";
import {LessonMarketComponent} from "./lesson-market/lesson-market.component";
import {LogInComponent} from "./Authentication/log-in/log-in.component";
import {NewCookComponent} from "./new-cook/new-cook.component";

const routes: Routes = [
  {path : 'cook' , component : CookComponent},
  {path : 'cook/:id' , component :CookComponent},
  {path : 'frigo' , component : FrigoComponent },
  {path : 'recipe' , component : RecipeComponent},
  {path : 'lesson' , component : LessonComponent},
  {path : 'home/:id' , component : MainComponent},
  {path : 'signin', component : SignInComponent},
  {path : '', component : LogInComponent},
  {path : 'lessonmarket/:id', component : LessonMarketComponent},
  {path : 'newcook', component : NewCookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
