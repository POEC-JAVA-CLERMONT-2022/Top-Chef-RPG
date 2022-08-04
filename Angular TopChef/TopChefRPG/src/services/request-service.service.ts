import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlService} from "./UrlService";



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RequestServiceService {





  constructor(private httpClient: HttpClient) { }

  getRequest<T>(endUrl : string ): Observable<T>{
    console.log("url appelée : "+ UrlService.urlApi + endUrl );
    return this.httpClient.get<T>(UrlService.urlApi + endUrl );
  }

  getTextRequest<T>(endUrl : string): Observable<any>{
    console.log("url appelée : " + UrlService.urlApi + endUrl);
    return  this.httpClient.get(UrlService.urlApi + endUrl , {responseType: 'text'} );
  }

  getJsonRequest<T>(endUrl : string): Observable<any>{
    console.log("url appelée : " + UrlService.urlApi + endUrl);
    return  this.httpClient.get(UrlService.urlApi + endUrl , {responseType: 'json'} );
  }

  postRequest<T>(endUrl : string, body : any): Observable<T>{
    console.log("url appelée : "+ UrlService.urlApi + endUrl );
    return this.httpClient.post<T>( UrlService.urlApi + endUrl, body, httpOptions);
  }

  deleteRequest(endUrl : string ): void {
    this.httpClient.delete(UrlService.urlApi +endUrl);
}
}
