import { Component, OnInit } from '@angular/core';
import { Devis } from 'src/app/_models/devis.model';
import {DevisService} from '../_services/devis/devis.service';
import { FormBuilder, FormGroup, FormControl, Validators } from "@angular/forms";
import { Router } from '@angular/router';
@Component({
  selector: 'app-devis',
  templateUrl: './devis.component.html',
  styleUrls: ['./devis.component.css']
})
export class DevisComponent implements OnInit {
  devis : Devis[];

  addForm: FormGroup;
  submitted: boolean;

  constructor(private sdevis: DevisService, private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.getAllDevis();

    this.addForm = this.formBuilder.group({
      
      dateCreation: ['', Validators.required],
      id_client: ['', Validators.required],
      id_vehicule: ['', [Validators.required, Validators.required]],
      id_user: ['', [Validators.required, Validators.required]],
      etat: ['', [Validators.required, Validators.required]],
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
        console.log(data);
        this.router.navigate(['/home']);
      });
    }
  }

  // get the form short name to access the form fields
  get f() { return this.addForm.controls; }
}
