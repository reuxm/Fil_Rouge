import { Component, OnInit } from '@angular/core';
import { Devis, Client } from 'src/app/_models/devis.model';
import {DevisService} from '../_services/devis/devis.service';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router, ActivatedRoute } from '@angular/router';
import { identifierModuleUrl } from '@angular/compiler';
import { Vehicule } from '../_models/devis.model';
import { User } from '../_models/tache.model';
import { forkJoin } from 'rxjs';


@Component({
  selector: 'app-devis',
  templateUrl: './devis.component.html',
  styleUrls: ['./devis.component.css']
})
export class DevisComponent implements OnInit {
  addForm: FormGroup;
  submitted: boolean;

  constructor(private sdevis: DevisService, private router: Router,
    private formBuilder: FormBuilder, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParamMap.subscribe(d => {
      this.getAllDevis();
    });


    this.addForm = this.formBuilder.group({
      dateCreation:  ['', Validators.required],
      client: this.formBuilder.group({
        name: '',
        id: ''
      }),
      vehicule: this.formBuilder.group({
        modele:'',
        id: ''
      }),
      user: this.formBuilder.group({
        firstname: '',
        id: ''
      }),

    });
  }

  getAllDevis(): void {
    this.sdevis.getAllDevis()
    .subscribe(devis => {
      this.devis = devis;
    } );
  }

  onSubmit() {
    this.submitted = true;
    const formValue = this.addForm.value;

    const vehiculeP = this.sdevis.getVehicule(parseInt(formValue.vehicule.id));
    const clientP = this.sdevis.getClient(parseInt(formValue.client.id));
    const userP = this.sdevis.getUser(parseInt(formValue.user.id));
    forkJoin([vehiculeP, clientP, userP]).subscribe(responses => {
      const devis = new Devis(
        {dateCreation: formValue.dateCreation,
          client: responses[1],
          vehicule: responses[0],
          user: responses[2],
          etat: false}
      );
      console.log(devis);
      this.sdevis.createDevis(devis)
      .subscribe( devis => {
        this.router.navigate(['/devis'], {queryParams: {ok: true} } );
        console.warn(devis);
      });
    });
  }

  // get the form short name to access the form fields
  get f() { return this.addForm.controls; }
}