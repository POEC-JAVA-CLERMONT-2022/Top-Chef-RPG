export class Ingredient{

  private _ingredientName :string  = "";
  private _ingredientQuantity : number = 0;

  constructor() {
  }

  get ingredientName(): string {
    return this._ingredientName;
  }

  set ingredientName(value: string) {
    this._ingredientName = value;
  }

  get ingredientQuantity(): number {
    return this._ingredientQuantity;
  }

  set ingredientQuantity(value: number) {
    this._ingredientQuantity = value;
  }


}
