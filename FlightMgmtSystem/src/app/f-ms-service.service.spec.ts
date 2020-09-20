import { TestBed } from '@angular/core/testing';

import { FMSServiceService } from './f-ms-service.service';

describe('FMSServiceService', () => {
  let service: FMSServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FMSServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
