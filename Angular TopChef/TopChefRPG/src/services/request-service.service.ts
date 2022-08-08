import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlService} from "./UrlService";



const httpOptionsJson = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })};
const httpOptionsText = {
  headers: new HttpHeaders({ 'Content-Type': 'text' })};



@Injectable({
  providedIn: 'root'
})
export class RequestServiceService {





  constructor(private httpClient: HttpClient) { }

  getRequest<T>(endUrl : string ): Observable<T>{
    console.log("url appelée : "+ UrlService.urlApi + endUrl );
    return this.httpClient.get<T>(UrlService.urlApi + endUrl );
  }

  getTextRequest(endUrl : string): Observable<any>{
    console.log("url appelée : " + UrlService.urlApi + endUrl);
    return  this.httpClient.get(UrlService.urlApi + endUrl , {responseType: 'text'} );
  }

  getJsonRequest(endUrl : string): Observable<any>{
    console.log("url appelée : " + UrlService.urlApi + endUrl);
    return  this.httpClient.get(UrlService.urlApi + endUrl , {responseType: 'json'} );
  }

  postRequest<T>(endUrl : string, body : any): Observable<any>{
    console.log("url appelée : "+ UrlService.urlApi + endUrl );
    return this.httpClient.post( UrlService.urlApi + endUrl, body, httpOptionsJson );
  }

  deleteRequest(endUrl : string ): void {
    this.httpClient.delete(UrlService.urlApi +endUrl);
}
}
