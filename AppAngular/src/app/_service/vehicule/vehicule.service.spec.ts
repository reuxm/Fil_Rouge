import { TestBed } from '@angular/core/testing';

import { VehiculeService } from './vehicule.service';

describe('VehiculeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VehiculeService = TestBed.get(VehiculeService);
    expect(service).toBeTruthy();
  });
});
