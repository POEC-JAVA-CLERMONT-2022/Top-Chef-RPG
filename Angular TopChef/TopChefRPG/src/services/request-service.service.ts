import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlService} from "./UrlService";

@Injectable({
  providedIn: 'root'
})
export class RequestServiceService {

  urlApi: string ="http://localhost:8080"
  constructor(private httpClient: HttpClient) { }

  getRequest<T>(endUrl : string ): Observable<T>{
    console.log("url appelée : "+ this.urlApi + endUrl );
    return this.httpClient.get<T>(UrlService.urlApi + endUrl );
  }

  postRequest<T>(endUrl : string, body : any): Observable<T>{
    return this.httpClient.post<T>( this.urlApi + endUrl, body, UrlService.headers);
  }

  deleteRequest(endUrl : string ): void {
    this.httpClient.delete(this.urlApi +endUrl);
}
}
