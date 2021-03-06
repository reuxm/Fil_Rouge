import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { VehiculeModel } from 'src/app/vehicule/vehicule.model';
import { catchError } from 'rxjs/operators';
import { CommandeVehicule } from '../../_models/commandeVeh.model';

@Injectable({
  providedIn: 'root'
})
export class CommandeVehService {


  private UrlCommande = 'http://localhost:8080/Rest/entity/commande/vehicules';

  constructor(private http: HttpClient) { }

          /** GET: get all Devis   */
          getAllCommandes(): Observable<CommandeVehicule[]> {
            return this.http.get<CommandeVehicule[]>(this.UrlCommande)
              .pipe(
                catchError(this.handleError<CommandeVehicule[]>('getAllCommandes', []))
              );
          }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
  public editCommande(commande: CommandeVehicule) {
    console.log(commande);
    return this.http.post((this.UrlCommande + '/update'), commande)
    .pipe(
      catchError(this.handleError<CommandeVehicule[]>('editCommande', []))
    );
  }

  }
