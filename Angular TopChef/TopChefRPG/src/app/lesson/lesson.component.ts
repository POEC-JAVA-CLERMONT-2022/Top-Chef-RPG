import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Ingredient} from "../../models/Ingredient";
import {Lesson} from "../../models/lesson";

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.scss']
})
export class LessonComponent implements OnInit {
  @Input()
  lessons : Array<Lesson> = new Array<Lesson>();

  @Output()
  lessonChoosed : EventEmitter<number> = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  doLesson(id :number) {
    this.lessonChoosed.emit(id);

  }
}
