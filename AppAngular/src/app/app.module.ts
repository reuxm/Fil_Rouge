import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ListeVehiculesComponent } from './liste-vehicules/liste-vehicules.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { CommonModule } from '@angular/common';
import { ListTachesComponent } from './list-taches/list-taches.component';
import { DevisComponent } from './devis/devis.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FichesComponent } from './fiches/fiches.component';
import { TacheDetailComponent } from './tache-detail/tache-detail.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ListeVehiculesComponent,
    VehiculeComponent,
    DevisComponent,
    ListTachesComponent,
    FichesComponent,
    TacheDetailComponent
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
