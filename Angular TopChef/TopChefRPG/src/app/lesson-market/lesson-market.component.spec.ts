import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LessonMarketComponent } from './lesson-market.component';

describe('LessonMarketComponent', () => {
  let component: LessonMarketComponent;
  let fixture: ComponentFixture<LessonMarketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LessonMarketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LessonMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
