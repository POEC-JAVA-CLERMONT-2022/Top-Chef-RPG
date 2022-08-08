import { Injectable } from '@angular/core';



const TOPCHEF_KEY = 'TOPCHEF_KEY';


@Injectable({
  providedIn: 'root'
})
export class TokenService {


  constructor() { }

  saveToken(token: string) : void{
    window.sessionStorage.removeItem(TOPCHEF_KEY);
    window.sessionStorage.setItem(TOPCHEF_KEY, token);
  }

  getToken(): string{
    let token = window.sessionStorage.getItem(TOPCHEF_KEY);
    if ( token != null) {
      return token;
    }
    else {
      return "";
    }
  }
}
