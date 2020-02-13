import { Component, OnInit } from '@angular/core';
import { Devis, Client } from 'src/app/_models/devis.model';
import {DevisService} from '../_services/devis/devis.service';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-devis',
  templateUrl: './devis.component.html',
  styleUrls: ['./devis.component.css']
})
export class DevisComponent implements OnInit {
  devis : Devis[];

  addForm: FormGroup;
  submitted: boolean;

  constructor(private sdevis: DevisService, private logServ: LoginService, private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
	  if( !this.logServ.isCom )
		  this.router.navigate(['\home']);
    this.getAllDevis();

    this.addForm = this.formBuilder.group({
      
      dateCreation:  ['', Validators.required],
      
      client: this.formBuilder.group({
        name: ''
      }),
      vehicule: this.formBuilder.group({
        modele: ''
      }),
      user: this.formBuilder.group({
        firstname: ''
      }),

    });
  }

  getAllDevis(): void {
    this.sdevis.getAllDevis()
    .subscribe(devis => {
      console.log("Réponse des devis");
      console.log(devis);
      this.devis = devis;
    } );
  }

  onSubmit(){
    this.submitted = true;
    if(this.addForm.valid){
      this.sdevis.createDevis(this.addForm.value)
      .subscribe( data => {
        console.log("Form devis done");
        console.log(data);
        this.router.navigate(['/devis']);
        console.warn(this.addForm.value);
      });
    }
  }

  // get the form short name to access the form fields
  get f() { return this.addForm.controls; }
}