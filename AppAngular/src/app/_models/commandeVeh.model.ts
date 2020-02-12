import { Devis } from './devis.model';

export class CommandeVehicule {
    id: number;
    etat: boolean;
    devis: Devis;
    dateCreation: Date;
    dateCloture: Date;
    livre: boolean;
}

