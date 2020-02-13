import { Fiche } from './fiche.model';

export class Tache {
    id: number;
    commentaire: string;
    libelle: string;
    qte: number;
    etat: boolean;
    user: User;
    fiche: Fiche;
    priorite: Priorite;
    piece: Piece;
}

export class User {
    id: number;
    firstname: string;
    lastname: string;
    login: string;
    password: string;
    suspended: boolean;
    profils: Profil[];
    constructor(param) {
        this.id = param.id;
        this.firstname = param.firstname;
        this.lastname = param.lastname;
        this.login = param.lastname;
        this.password = param.password;
        this.suspended = param.suspended;
        this.profils = param.profils;
    }
}

export class Profil {
    id: number;
    name: string;
}

export class Priorite {
    id: number;
    libelle: string;
}

export class Piece {
    id: number;
    libelle: string;
    qte: number;
    dateCreation: string;
}
