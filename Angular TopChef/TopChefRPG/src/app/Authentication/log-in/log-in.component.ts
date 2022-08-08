import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RequestServiceService} from "../../../services/request-service.service";
import {Router} from "@angular/router";
import {LoginDTO} from "../loginDTO";
import {UrlService} from "../../../services/UrlService";
import {TokenService} from "../../../services/token.service";

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {
  userFormGroup!: FormGroup;
  showError: boolean = false;
  errorMessage: string = "";

  constructor(private request: RequestServiceService, private router: Router, private tokenService : TokenService ) {
  }

  ngOnInit(): void {
    this.userFormGroup = new FormGroup(
      {
        userName: new FormControl(
          '', [Validators.required, Validators.minLength(3)]
        ),
        password: new FormControl(
          '', [Validators.required, Validators.minLength(5)]
        )
      }
    )
  }

  logIn(): void {
    let newUser = new LoginDTO();
    newUser.userName = this.userFormGroup.value.userName;
    newUser.password = this.userFormGroup.value.password;

    this.request.postRequest(UrlService.urlLogIn, newUser).subscribe(result => {
        console.log(result)
        this.tokenService.saveToken( result.token);
        this.router.navigate(['newcook']);
      },
      err => {
        this.errorMessage = err.error.message;
        this.showError = true;
      });
  }

  createAccount() {
    this.router.navigate(['signin']);
  }
}
