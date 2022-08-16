import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RequestServiceService} from "../../../services/request-service.service";
import {Router} from "@angular/router";
import {LoginDTO} from "../loginDTO";
import {UrlService} from "../../../services/UrlService";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {
  userFormGroup!: FormGroup;
  errorMessage: string = '';
  showError: boolean = false;

  constructor(private request: RequestServiceService, private router: Router) {
  }

  ngOnInit(): void {
    this.userFormGroup = new FormGroup(
      {
        userName: new FormControl(
          '', [Validators.required, Validators.minLength(3)]
        ),
        mail: new FormControl(
          '', [Validators.required, Validators.minLength(5)]
        ),
        password: new FormControl(
          '', [Validators.required, Validators.minLength(5)]
        )
      }
    )
  }

  createUser(): void {
    let newUser = new LoginDTO();
    newUser.userName = this.userFormGroup.value.userName;
    newUser.mail = this.userFormGroup.value.mail;
    newUser.password = this.userFormGroup.value.password;

    this.request.postRequest(UrlService.urlSignIn, newUser).subscribe(result => {
        console.log(result);
        this.router.navigate(['']);
      },
      err => {
        this.showError = true;
        this.errorMessage = err.error.message;
      });
  }

  gologin(): void {
    this.router.navigate(['']);
  }

  test() {
    console.log("passage dans le test");
    this.request.getTextRequest("/api/test").subscribe(result => {
        console.log(result);
        console.log("fin du test");
      },
      err => {
        let toto = err.error;
      }
    );
  }

  testJGetson() {
    console.log("test récupération de Json");
    this.request.getJsonRequest("/api/testJson").pipe().subscribe(result => {
        console.log(result);
      },
      err => {
        let toto = err.error;
      });
  }
}