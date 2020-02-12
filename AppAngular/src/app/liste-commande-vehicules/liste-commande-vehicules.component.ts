import { Component, OnInit } from '@angular/core';
import { CommandeVehicule } from '../_models/commandeVeh.model';
import { CommandeVehService } from '../_services/commandeVeh/commande-veh.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-liste-commande-vehicules',
  templateUrl: './liste-commande-vehicules.component.html',
  styleUrls: ['./liste-commande-vehicules.component.css']
})
export class ListeCommandeVehiculesComponent implements OnInit {
  ListCommandes: CommandeVehicule[];
  public listeData;
  constructor(private sCommandeVeh: CommandeVehService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAllCommandeVeh();
  }

  getAllCommandeVeh() {
     this.sCommandeVeh.getAllCommandes()
    .subscribe(commande => {
      this.ListCommandes = commande;
    });
  }
  livraisonCommande(commande){
    commande.livre = true;
    console.log('on passe par là')
    this.sCommandeVeh.editCommande(commande).subscribe(d => console.log(d));

  }

}
