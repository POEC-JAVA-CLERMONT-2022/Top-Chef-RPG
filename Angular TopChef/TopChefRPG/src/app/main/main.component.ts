import { Component, OnInit } from '@angular/core';
import {Cook} from "../../models/Cook";
import {RequestServiceService} from "../../services/request-service.service";
import {ActivatedRoute} from "@angular/router";
import {UrlService} from "../../services/UrlService";
import {Ingredient} from "../../models/Ingredient";
import {newArray} from "@angular/compiler/src/util";
import {Recipe} from "../../models/recipe";
import {Lesson} from "../../models/lesson";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {



  private _cook :Cook = new Cook();
  private _id :number =1;
  public ingredients : Array<Ingredient> = new Array<Ingredient>();
  private _recipes : Array<Recipe> = new Array<Recipe>();
  private _lessonsOwned : Array<Lesson> =new Array<Lesson>();


  constructor(private _request :RequestServiceService, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params)=>{
      this.id = params['id'];
    })
    console.log("id obtained : "+this.id);
    this.getCookInfo();
    this.getIngredients();
    this.getRecipes();
  }

  getCookInfo() {
    this._request.getRequest<Cook>(UrlService.urlGetCookById + this.id).pipe().subscribe((result) => {
        this.cook = result;
      }
    )
  }
  getIngredients(){
    this._request.getRequest<Ingredient[]>(UrlService.urlGetIngredient+this.id).pipe().subscribe((result)=>{
      this.ingredients = result;
    })
  }

  getRecipes(){
    this.request.getRequest<Recipe[]>(UrlService.urlGetRecipes+ this.id).pipe().subscribe((result)=>{
      this.recipes = result;
    })
  }



  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get cook(): Cook {
    return this._cook;
  }

  set cook(value: Cook) {
    this._cook = value;
  }

  get recipes(): Array<Recipe> {
    return this._recipes;
  }

  set recipes(value: Array<Recipe>) {
    this._recipes = value;
  }

  get lessonsOwned(): Array<Lesson> {
    return this._lessonsOwned;
  }

  set lessonsOwned(value: Array<Lesson>) {
    this._lessonsOwned = value;
  }

  get request(): RequestServiceService {
    return this._request;
  }

  set request(value: RequestServiceService) {
    this._request = value;
  }
}
