import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCookComponent } from './new-cook.component';

describe('NewCookComponent', () => {
  let component: NewCookComponent;
  let fixture: ComponentFixture<NewCookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
