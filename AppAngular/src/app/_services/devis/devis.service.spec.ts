import { TestBed } from '@angular/core/testing';

import { DevisService } from './devis.service';

describe('DevisService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DevisService = TestBed.get(DevisService);
    expect(service).toBeTruthy();
  });
});
