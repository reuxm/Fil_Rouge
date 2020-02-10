import { Component, OnInit } from '@angular/core';
import { Devis } from 'src/app/_models/devis.model';
import {DevisService} from '../_services/devis/devis.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-devis',
  templateUrl: './devis.component.html',
  styleUrls: ['./devis.component.css']
})
export class DevisComponent implements OnInit {
  devis : Devis[];

  constructor(private sdevis: DevisService, private router: Router) { }

  ngOnInit() {
    this.getAllDevis();
  }

  getAllDevis(): void {
    this.sdevis.getAllDevis()
    .subscribe(devis => {
      console.log("Réponse des devis");
      console.log(devis);
      this.devis = devis;
    } );
  }
}
