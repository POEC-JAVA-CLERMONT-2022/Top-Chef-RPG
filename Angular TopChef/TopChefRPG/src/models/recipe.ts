import {Ingredient} from "./Ingredient";
import {newArray} from "@angular/compiler/src/util";


export class Recipe{
  private _idRecipe : number = 0;
  private _name : string =""
  private _strengthRequired: number = 0
  private _dexterityRequired: number = 0
  private _creativityRequired: number = 0
  private _chanceOfSucces: number = 0
  private _experienceGain: number = 0
  private _doable : boolean =true ;
  private _ingredientsRequired : Array<Ingredient> = new Array<Ingredient>();
  private _lootIngredient : Array<Ingredient>= new Array<Ingredient>();

  constructor() {
  }

  get idRecipe(): number {
    return this._idRecipe;
  }

  set idRecipe(value: number) {
    this._idRecipe = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get strengthRequired(): number {
    return this._strengthRequired;
  }

  set strengthRequired(value: number) {
    this._strengthRequired = value;
  }

  get dexterityRequired(): number {
    return this._dexterityRequired;
  }

  set dexterityRequired(value: number) {
    this._dexterityRequired = value;
  }

  get creativityRequired(): number {
    return this._creativityRequired;
  }

  set creativityRequired(value: number) {
    this._creativityRequired = value;
  }

  get chanceOfSucces(): number {
    return this._chanceOfSucces;
  }

  set chanceOfSucces(value: number) {
    this._chanceOfSucces = value;
  }

  get experienceGain(): number {
    return this._experienceGain;
  }

  set experienceGain(value: number) {
    this._experienceGain = value;
  }

  get doable(): boolean {
    return this._doable;
  }

  set doable(value: boolean) {
    this._doable = value;
  }

  get ingredientsRequired(): Array<Ingredient> {
    return this._ingredientsRequired;
  }

  set ingredientsRequired(value: Array<Ingredient>) {
    this._ingredientsRequired = value;
  }

  get lootIngredient(): Array<Ingredient> {
    return this._lootIngredient;
  }

  set lootIngredient(value: Array<Ingredient>) {
    this._lootIngredient = value;
  }
}

