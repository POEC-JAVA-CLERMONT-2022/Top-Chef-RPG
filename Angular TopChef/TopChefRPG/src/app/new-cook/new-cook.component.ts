import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {RequestServiceService} from "../../services/request-service.service";
import {UrlService} from "../../services/UrlService";
import {Cook} from "../../models/Cook";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-cook',
  templateUrl: './new-cook.component.html',
  styleUrls: ['./new-cook.component.scss']
})
export class NewCookComponent implements OnInit {
  cookFormGroup! : FormGroup

  constructor(private request : RequestServiceService, private router :Router) { }

  ngOnInit(): void {
    this.cookFormGroup = new FormGroup(
      {
         cookName : new FormControl(
          '', [Validators.required, Validators.minLength(3),]
        )
      }

    )
  }

  get cookName() : AbstractControl{
    return <AbstractControl>this.cookFormGroup.get('cookName');
  }

  createCook():void{
    console.log(this.cookName.value)
    let JsonCOOk =
      {
        name : this.cookName.value,
        newName : "",
        id : 0 ,
        dexterity : 0,
        strength :0,
        creativity : 0,
        luck :0,
        gender :'M',
        experience : 0
      }

    this.request.postRequest<number>(UrlService.urlCreateCook,JsonCOOk).pipe().subscribe((result=>{
      let idCook :number =result;
      console.log(idCook);
      this.router.navigate(['home/', idCook]);
    }));

  }

}
