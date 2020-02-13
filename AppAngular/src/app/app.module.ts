import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ListeVehiculesComponent } from './liste-vehicules/liste-vehicules.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { ListTachesComponent } from './list-taches/list-taches.component';
import { DevisComponent } from './devis/devis.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FichesComponent } from './fiches/fiches.component';
import { TacheDetailComponent } from './tache-detail/tache-detail.component';
import { ListeCommandeVehiculesComponent } from './liste-commande-vehicules/liste-commande-vehicules.component';
import { SearchComponent } from './search/search.component';
import { FilterPipe } from './filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    DevisComponent,
    LoginComponent,
    ListeVehiculesComponent,
    VehiculeComponent,
    ListTachesComponent,
    FichesComponent,
    TacheDetailComponent,
    ListeCommandeVehiculesComponent,
    SearchComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
