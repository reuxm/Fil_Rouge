import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { of, Observable} from 'rxjs';
import { catchError} from 'rxjs/operators';
import { Devis, Vehicule, Client } from 'src/app/_models/devis.model';
import { User } from '../../_models/tache.model';

@Injectable({
  providedIn: 'root'
})
export class DevisService {

  private UrlDevis = 'http://localhost:8080/Rest/entity/'; 

  constructor(private http: HttpClient) { }

          /** GET: get all Devis   */
          getAllDevis (): Observable<Devis[]> {
            return this.http.get<Devis[]>(this.UrlDevis + 'devis')
              .pipe(
                catchError(this.handleError<Devis[]>('getAllDevis', []))
              );
          }

            /** POST: add a new Devis  */
       createDevis(devis: Devis): Observable<Devis> {
         console.log(devis);
         return this.http.post<Devis>((this.UrlDevis + 'createdevis'), devis)
          .pipe(
            catchError(this.handleError<Devis>('createdevis', devis))
          );
      }
      getVehicule(id) {
        console.log(this.UrlDevis+'devis/vehicule/'+id);
        return this.http.get<Vehicule>(this.UrlDevis+'devis/vehicule/'+id)
        .pipe(
          catchError(this.handleError<Vehicule>('getVehicule'))
        );
      }
      getClient(id) {
        console.log(this.UrlDevis+'devis/client/'+id);
        return this.http.get<Client>(this.UrlDevis+'devis/client/'+id)
        .pipe(
          catchError(this.handleError<Client>('getVehicule'))
        );
      }
      getUser(id) {
        console.log(this.UrlDevis+'devis/user/'+id);
        return this.http.get<User>(this.UrlDevis+'devis/user/'+id)
        .pipe(
          catchError(this.handleError<User>('getVehicule'))
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
