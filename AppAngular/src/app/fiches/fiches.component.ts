import { Component, OnInit } from '@angular/core';
import { Fiche } from 'src/app/_models/fiche.model';
import { FichesService } from '../_services/fiches/fiches.service';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-fiches',
  templateUrl: './fiches.component.html',
  styleUrls: ['./fiches.component.css']
})
export class FichesComponent implements OnInit {

  fiches: Fiche[];

  constructor(private serviceFiche: FichesService, private logServ: LoginService, private router: Router) { }

  ngOnInit() {
	  if( !this.logServ.isMeca )
		  this.router.navigate(['\home']);
	  this.getAllFiches();
  }

  getAllFiches(): void {
    this.serviceFiche.getAllFiches()
    .subscribe(fiches => {
      this.fiches = fiches;
      console.log(fiches);
    });
  }

}
