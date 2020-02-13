import { User } from "./tache.model";

export class Devis {
  id: number;
  dateCreation: Date;
  etat: boolean;
  client: Client;
  vehicule: Vehicule;
  user: User;
  constructor(param) {
    this.id = param.id;
    this.dateCreation = param.dateCreation;
    this.etat = param.etat;
    this.client = param.client;
    this.user = param.user;
    this.vehicule = param.vehicule;
    this.etat = param.etat;
  }
}

export class Client {
  id: number;
  name: string;
  firstname: string;
  adresse: string;
  codePostal: string;
  ville: string;
  telephone: string;
  mobile: string;
  cloturer: boolean;
  constructor(param) {
    this.id = param.id;
    this.name = param.name;
    this.firstname = param.firstname;
    this.adresse = param.adresse;
    this.codePostal = param.codePostal;
    this.ville = param.ville;
    this.telephone = param.telephone;
    this.mobile = param.mobile;
    this.cloturer = param.cloturer;
  }
}

export class Vehicule {
  id: number;
  modele: string;
  qte: number;
  prixHT: number;
  constructor(param){
      this.id = param.id;
      this.modele = param.modele;
      this.qte = param.qte;
      this.prixHT = param.prixHT;
  }
}
