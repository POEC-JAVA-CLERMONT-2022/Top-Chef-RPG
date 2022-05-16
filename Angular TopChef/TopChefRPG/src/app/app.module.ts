import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CookComponent } from './cook/cook.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { MainComponent } from './main/main.component';
import { RecipeComponent } from './recipe/recipe.component';
import { FrigoComponent } from './frigo/frigo.component';
import { LessonComponent } from './lesson/lesson.component';


@NgModule({
  declarations: [
    AppComponent,
    CookComponent,
    MainComponent,
    RecipeComponent,
    FrigoComponent,
    LessonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
