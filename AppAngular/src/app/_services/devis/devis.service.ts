import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { of, Observable} from 'rxjs';
import { catchError} from 'rxjs/operators';
import { Devis } from 'src/app/_models/devis.model';

@Injectable({
  providedIn: 'root'
})
export class DevisService {

  private UrlDevis = 'http://localhost:8080/Rest/entity/devis'; 

  constructor(private http: HttpClient) { }

          /** GET: get all Devis   */
          getAllDevis (): Observable<Devis[]> {
            return this.http.get<Devis[]>(this.UrlDevis+'devis')
              .pipe(
                catchError(this.handleError<Devis[]>('getAllDevis', []))
              );
          }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
 
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
 
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
 
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
