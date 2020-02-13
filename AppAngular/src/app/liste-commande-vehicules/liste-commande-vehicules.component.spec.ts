import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeCommandeVehiculesComponent } from './liste-commande-vehicules.component';

describe('ListeCommandeVehiculesComponent', () => {
  let component: ListeCommandeVehiculesComponent;
  let fixture: ComponentFixture<ListeCommandeVehiculesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeCommandeVehiculesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeCommandeVehiculesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
