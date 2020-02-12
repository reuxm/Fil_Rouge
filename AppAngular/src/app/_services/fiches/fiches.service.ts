import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Fiche } from 'src/app/_models/fiche.model';

@Injectable({
  providedIn: 'root'
})
export class FichesService {

  private url = 'http://localhost:8080/Rest/entity/';

  constructor(private http: HttpClient) { }

  getAllFiches(): Observable<Fiche[]> {
    return this.http.get<Fiche[]>(this.url + 'fiches')
      .pipe(
        catchError(this.handleError<Fiche[]>('getAllFiches', []))
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
