import {Component, Input, OnInit} from '@angular/core';
import {Ingredient} from "../../models/Ingredient";

@Component({
  selector: 'app-frigo',
  templateUrl: './frigo.component.html',
  styleUrls: ['./frigo.component.scss']
})
export class FrigoComponent implements OnInit {


  @Input()
  public Ingredients : Array<Ingredient> = new Array<Ingredient>();
  constructor() { }

  ngOnInit(): void {
    console.log("les ingredients : "+this.Ingredients);
  }


}
