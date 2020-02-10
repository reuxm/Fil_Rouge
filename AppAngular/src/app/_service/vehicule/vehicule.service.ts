import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { VehiculeModel } from 'src/app/vehicule/vehicule.model';
import { catchError} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class VehiculeService {

  private UrlDevis = 'http://localhost:8080/Rest/entity/vehicules';

  constructor(private http: HttpClient) { }

          /** GET: get all Devis   */
          getAllVehicules(): Observable<VehiculeModel[]> {
            return this.http.get<VehiculeModel[]>(this.UrlDevis)
              .pipe(
                catchError(this.handleError<VehiculeModel[]>('getAllVehicule', []))
              );
          }

  private handleError<T>(operation = 'operation', result?: T) {
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