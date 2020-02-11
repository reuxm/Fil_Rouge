import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListeVehiculesComponent } from './liste-vehicules/liste-vehicules.component'
import { DevisComponent } from './devis/devis.component';
import { ListTachesComponent } from './list-taches/list-taches.component';
import { FichesComponent } from './fiches/fiches.component';
import { TacheDetailComponent } from './tache-detail/tache-detail.component';



const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'vehicule', component: ListeVehiculesComponent},
  {path: 'devis', component: DevisComponent},
  { path: 'fiches', component: FichesComponent },
  {
    path: 'taches',
    component: ListTachesComponent,
    children: [
      { path: 'detail/:id', component: TacheDetailComponent }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
