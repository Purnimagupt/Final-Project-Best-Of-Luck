import { TestBed } from '@angular/core/testing';

import { GiftingDetailsService } from './gifting-details.service';

describe('GiftingDetailsService', () => {
  let service: GiftingDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GiftingDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
