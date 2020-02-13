import { Component, OnInit, Input } from '@angular/core';
import { VehiculeModel } from './vehicule.model';

@Component({
  selector: 'app-vehicule',
  templateUrl: './vehicule.component.html',
  styleUrls: ['./vehicule.component.css']
})
export class VehiculeComponent implements OnInit {
  @Input() vehicule: VehiculeModel;
  hasImage: boolean = false;
  constructor() { }

  ngOnInit() {
    const image = new Image();
    image.onload = () => {
      this.hasImage = true;
    }
    image.src = `assets/images/${this.vehicule.modele.toLowerCase()}.jpg`;

  }

}
