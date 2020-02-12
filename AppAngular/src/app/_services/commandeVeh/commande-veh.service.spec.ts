import { TestBed } from '@angular/core/testing';

import { CommandeVehService } from './commande-veh.service';

describe('CommandeVehService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CommandeVehService = TestBed.get(CommandeVehService);
    expect(service).toBeTruthy();
  });
});
