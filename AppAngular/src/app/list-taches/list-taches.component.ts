import { Component, OnInit } from '@angular/core';
import { Fiche } from 'src/app/_models/fiche.model';
import { FichesService } from '../_services/fiches/fiches.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Tache } from '../_models/tache.model';
import { TachesService } from '../_services/taches/taches.service';

@Component({
  selector: 'app-list-taches',
  templateUrl: './list-taches.component.html',
  styleUrls: ['./list-taches.component.css']
})
export class ListTachesComponent implements OnInit {

  taches: Tache[];

  constructor(private serviceTache: TachesService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParamMap.subscribe(d => {
      let tache_id = d.get('detail');
      let reload = d.get('reload');
      if (tache_id == null || reload) {
        this.getAllTaches();
      } else {
        this.router.navigate(['detail', tache_id], { relativeTo: this.route });
      }
    });
  }

  getAllTaches(): void {
    this.serviceTache.getAllTaches()
    .subscribe(taches => {
      this.taches = taches;
    });
  }

  tacheDetail(id: number) {
    this.router.navigate(['detail/' + id], { relativeTo: this.route });
  }

}
