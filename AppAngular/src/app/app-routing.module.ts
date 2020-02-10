import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListTachesComponent } from './list-taches/list-taches.component';
import { FichesComponent } from './fiches/fiches.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'fiches', component: FichesComponent },
  { path: 'list', component: ListTachesComponent },
  { path: '', pathMatch: 'full', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
