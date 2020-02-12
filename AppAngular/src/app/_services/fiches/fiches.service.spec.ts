import { TestBed } from '@angular/core/testing';

import { FichesService } from './fiches.service';

describe('FichesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FichesService = TestBed.get(FichesService);
    expect(service).toBeTruthy();
  });
});
