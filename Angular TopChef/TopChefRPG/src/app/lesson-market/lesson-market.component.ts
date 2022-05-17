import {Component, OnInit} from '@angular/core';
import {RequestServiceService} from "../../services/request-service.service";
import {Lesson} from "../../models/lesson";
import {UrlService} from "../../services/UrlService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-lesson-market',
  templateUrl: './lesson-market.component.html',
  styleUrls: ['./lesson-market.component.scss']
})
export class LessonMarketComponent implements OnInit {
  LessonsToBuy: Array<Lesson> = new Array<Lesson>();
  id: number = 1;

  constructor(private request: RequestServiceService, private routeur: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    console.log("arrivé au marché");
    this.route.params.subscribe((params) => {
      console.log("id récupéré : "+ this.id)
      this.id = params['id'];
      console.log("id récupéré : "+ this.id)
    })

    this.request.getRequest<Lesson[]>(UrlService.urlGetLessonsToBuy + this.id).pipe().subscribe((result) => {
      this.LessonsToBuy = result;
    })

  }

  buyLesson(id: number) {
    this.request.postRequest(UrlService.urlBuyLesson + this.id + "/" + id, JSON.stringify("")).pipe().subscribe((result) => {
        this.routeur.navigate(['home/', this.id]);
      }
    )

  }

  retour() {
    this.routeur.navigate(['home/', this.id]);
  }
}
