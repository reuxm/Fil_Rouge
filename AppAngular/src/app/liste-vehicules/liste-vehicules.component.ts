import { Component, OnInit } from '@angular/core';
import { VehiculeModel } from '../vehicule/vehicule.model';
import { VehiculeService } from '../_service/vehicule/vehicule.service';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-liste-vehicules',
  templateUrl: './liste-vehicules.component.html',
  styleUrls: ['./liste-vehicules.component.css']
})
export class ListeVehiculesComponent implements OnInit {
  public ListVehicule: VehiculeModel[] = [];
  public listeData;
  constructor(private svehicule: VehiculeService, private logServ: LoginService, private router: Router) {

  }


  ngOnInit() {
	  if( !this.logServ.isCom )
		  this.router.navigate(['\home']);
    this.getAllVehicule();
    for (const e of this.listeData) {
      const vehicule = new VehiculeModel(e.id, e.modele, e.quantite, e.prixHt, e.dateCreation);
      this.ListVehicule.push(vehicule);
    }
  }
  getAllVehicule(){
    this.svehicule.getAllVehicules()
    .subscribe(vehicule => {
      this.ListVehicule = vehicule;
    });

  }
}
