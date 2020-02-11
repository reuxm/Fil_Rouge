import { User } from './tache.model';

export class Devis{

    id : number;
    dateCreation: Date;
    etat: boolean;
    client: Client[];
    vehicule :Vehicule[];
    user: User[]

    constructor(param) {
        this.id = param.id;
        this.dateCreation= param.dateCreation;
        this.etat=param.etat;
        this.client=param.client;
        this.user=param.user;
        this.vehicule=param.vehicule
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
    cloturer: boolean
    
}

export class Vehicule {
    id: number;
    modele: string;
    qte: number;
    prixHT: number
    
}