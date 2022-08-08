import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {RequestServiceService} from "../../services/request-service.service";
import {UrlService} from "../../services/UrlService";
import {Cook} from "../../models/Cook";
import {Router} from "@angular/router";
import {User} from "../../models/User";

@Component({
  selector: 'app-new-cook',
  templateUrl: './new-cook.component.html',
  styleUrls: ['./new-cook.component.scss']
})
export class NewCookComponent implements OnInit {
  cookFormGroup! : FormGroup;
  token : string ="";
  user : User = new User();
  cooks : Array<Cook> = new Array<Cook>();

  constructor(private request : RequestServiceService, private router :Router) { }

  ngOnInit(): void {
    this.cookFormGroup = new FormGroup(
      {
         cookName : new FormControl(
          '', [Validators.required, Validators.minLength(3)]
        )
      }

    )
    this.setUserName();

  }

  get cookName() : AbstractControl{
    return <AbstractControl>this.cookFormGroup.get('cookName');
  }

  setUserName() : void{
    this.request.getJsonRequest(UrlService.urlGetUserByToken).subscribe(result=>{
      this.user = result;
    })
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

  showToken() {
    this.request.getTextRequest(UrlService.urlGetUserByToken).subscribe((result)=>{
      console.log(result);
      this.token =result;
    })
  }
}
