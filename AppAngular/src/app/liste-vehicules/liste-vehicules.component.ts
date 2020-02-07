import { Component, OnInit } from '@angular/core';
import { VehiculeModel } from '../vehicule/vehicule.model';

@Component({
  selector: 'app-liste-vehicules',
  templateUrl: './liste-vehicules.component.html',
  styleUrls: ['./liste-vehicules.component.css']
})
export class ListeVehiculesComponent implements OnInit {
  public ListVehicule: VehiculeModel[] = [];
  // Ajouter le lien fetch vers les data
  public listeData = data;
  constructor() {

  }

  ngOnInit() {
    for (const e of data) {
      const vehicule = new VehiculeModel(e.id, e.modele, e.quantite, e.prixHt, e.dateCreation);
      this.ListVehicule.push(vehicule);
  }

}
