import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Tache } from 'src/app/_models/tache.model';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TachesService {

  private url = 'http://localhost:8080/Rest/entity/';

  constructor(private http: HttpClient) { }

  getAllTaches(): Observable<Tache[]> {
    return this.http.get<Tache[]>(this.url + 'taches')
      .pipe(
        catchError(this.handleError<Tache[]>('getAllTaches', []))
      );
  }

  getTache(id: string): Observable<Tache> {
    return this.http.get<Tache>(this.url + 'taches/' + id)
      .pipe(
        catchError(this.handleError<Tache>('getTache', ))
      );
  }

  updateTache(tache: Tache): Observable<Tache> {
    return this.http.post<Tache>(this.url + 'updateTache', tache)
      .pipe(
        catchError(this.handleError<Tache>('updateTache', tache))
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
