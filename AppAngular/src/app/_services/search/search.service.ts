import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Piece } from 'src/app/_models/tache.model';
import { catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private url = 'http://localhost:8080/Rest/entity/';

  constructor(private http: HttpClient) { }

  getAllPieces() {
    return this.http.get<Piece[]>(this.url + 'pieces')
      .pipe(
        catchError(this.handleError<Piece[]>('getAllTaches', []))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      console.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }
}
