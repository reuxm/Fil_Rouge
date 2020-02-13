import { Component, OnInit } from '@angular/core';
import { Piece } from '../_models/tache.model';
import { SearchService } from '../_services/search/search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  pieces: Piece[];

  constructor(private serviceSearch: SearchService) {
  }

  ngOnInit() {
    this.getAllPieces();
  }

  getAllPieces(): void {
    this.serviceSearch.getAllPieces()
    .subscribe(pieces => {
      this.pieces = pieces;
    });
  }

}
