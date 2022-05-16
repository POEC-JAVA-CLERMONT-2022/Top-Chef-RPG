

export class Cook{
  private _experience : number =0;
  private _name : string="";
  private _newName : string="";
  private _id : number =0;
  private _dexterity : number=0;
  private _strength : number=0;
  private _creativity: number=0;
  private _luck : number=0;
  private _gender : string="";

  constructor(){
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get newName(): string {
    return this._newName;
  }

  set newName(value: string) {
    this._newName = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get dexterity(): number {
    return this._dexterity;
  }

  set dexterity(value: number) {
    this._dexterity = value;
  }

  get strength(): number {
    return this._strength;
  }

  set strength(value: number) {
    this._strength = value;
  }

  get creativity(): number {
    return this._creativity;
  }

  set creativity(value: number) {
    this._creativity = value;
  }

  get luck(): number {
    return this._luck;
  }

  set luck(value: number) {
    this._luck = value;
  }

  get gender(): string {
    return this._gender;
  }

  set gender(value: string) {
    this._gender = value;
  }

  get experience(): number {
    return this._experience;
  }

  set experience(value: number) {
    this._experience = value;
  }


}
