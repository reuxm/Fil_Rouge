import { Component, OnInit } from '@angular/core';
import { Tache, User, Priorite, Piece } from '../_models/tache.model';
import { Fiche } from '../_models/fiche.model';
import { ActivatedRoute, Router } from '@angular/router';
import { TachesService } from '../_services/taches/taches.service';

@Component({
  selector: 'app-tache-detail',
  templateUrl: './tache-detail.component.html',
  styleUrls: ['./tache-detail.component.css']
})
export class TacheDetailComponent implements OnInit {

  tache: Tache = {
    id: 0,
    commentaire: '',
    libelle: '',
    qte: 0,
    etat: false,
    user: new User(),
    fiche: new Fiche(),
    priorite: new Priorite(),
    piece: new Piece()
  };

  constructor(private serviceTache: TachesService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getTache();
  }

  getTache() {
    this.route.paramMap.subscribe(d => {
      this.serviceTache.getTache(d.get('id'))
      .subscribe(tache => {
        this.tache = tache;
        });
    });
  }

  updateTache(tache: Tache) {
    this.serviceTache.updateTache(tache).subscribe(d => {
        if (this.tache.etat) {
          this.router.navigate(['taches'], { queryParams: { reload: true } });
        } else {
          this.router.navigate(['taches'], { queryParams: { detail: this.tache.id } });
        }
    });
  }

}
