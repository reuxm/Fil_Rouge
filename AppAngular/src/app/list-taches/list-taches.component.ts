import { Component, OnInit } from '@angular/core';
import { Fiche } from 'src/app/_models/fiche.model';
import { FichesService } from '../_services/fiches/fiches.service';
import { Router } from '@angular/router';
import { Tache } from '../_models/tache.model';
import { TachesService } from '../_services/taches/taches.service';

@Component({
  selector: 'app-list-taches',
  templateUrl: './list-taches.component.html',
  styleUrls: ['./list-taches.component.css']
})
export class ListTachesComponent implements OnInit {

  taches: Tache[];

  constructor(private serviceTache: TachesService, private router: Router) { }

  ngOnInit() {
    this.getAllTaches();
  }

  getAllTaches(): void {
    this.serviceTache.getAllTaches()
    .subscribe(taches => {
      this.taches = taches;
      console.log(taches);
    });
  }

}
