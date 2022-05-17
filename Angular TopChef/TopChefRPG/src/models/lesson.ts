
export class Lesson{
  private _id : number =0;
  private _name : string ="";
  private _strengthIncrease :number =0;
  private _dexterityIncrease : number = 0;
  private _creativityIncrease:number =0;
  private _luckIncrease : number =0;
  private _experienceCost : number =0;
  private _ingredientName : string ="";
  private _ingredientQuantity : number =0;


  constructor() {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get strengthIncrease(): number {
    return this._strengthIncrease;
  }

  set strengthIncrease(value: number) {
    this._strengthIncrease = value;
  }

  get dexterityIncrease(): number {
    return this._dexterityIncrease;
  }

  set dexterityIncrease(value: number) {
    this._dexterityIncrease = value;
  }

  get creativityIncrease(): number {
    return this._creativityIncrease;
  }

  set creativityIncrease(value: number) {
    this._creativityIncrease = value;
  }

  get luckIncrease(): number {
    return this._luckIncrease;
  }

  set luckIncrease(value: number) {
    this._luckIncrease = value;
  }

  get experienceCost(): number {
    return this._experienceCost;
  }

  set experienceCost(value: number) {
    this._experienceCost = value;
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
