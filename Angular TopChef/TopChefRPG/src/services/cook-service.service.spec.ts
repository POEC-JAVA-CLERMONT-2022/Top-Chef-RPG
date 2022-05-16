import { TestBed } from '@angular/core/testing';

import { CookServiceService } from './cook-service.service';

describe('CookServiceService', () => {
  let service: CookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
