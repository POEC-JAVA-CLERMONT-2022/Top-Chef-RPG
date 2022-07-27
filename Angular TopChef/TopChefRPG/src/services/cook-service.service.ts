import { Injectable } from '@angular/core';
import {RequestServiceService} from "./request-service.service";
import {Cook} from "../models/Cook";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CookServiceService {
  urlApi: string = "http://localhost:8080"
  urlGetCookById: string = "/cook/";


  constructor(private request: RequestServiceService, private httpClient: HttpClient) {
  }

  getCookById(): Observable<Cook> {
    console.log("toto, " + this.urlApi + this.urlGetCookById);
    return this.httpClient.get<Cook>(this.urlApi + this.urlGetCookById);
  }
}


