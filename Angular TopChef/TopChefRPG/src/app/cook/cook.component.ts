import { Component, OnInit } from '@angular/core';
import {Cook} from "../../models/Cook";
import {RequestServiceService} from "../../services/request-service.service";
import {UrlService} from "../../services/UrlService";
import {Input,Output} from "@angular/core";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-cook',
  templateUrl: './cook.component.html',
  styleUrls: ['./cook.component.scss']
})


export class CookComponent implements OnInit {

  @Input()  cook :Cook |undefined;



  constructor() {

  }
  ngOnInit(): void {

  }

}
