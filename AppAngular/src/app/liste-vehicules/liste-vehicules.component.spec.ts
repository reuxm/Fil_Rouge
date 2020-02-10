import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeVehiculesComponent } from './liste-vehicules.component';

describe('ListeVehiculesComponent', () => {
  let component: ListeVehiculesComponent;
  let fixture: ComponentFixture<ListeVehiculesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeVehiculesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeVehiculesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
