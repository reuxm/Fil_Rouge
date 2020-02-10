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

class User {
    id: number;
    firstname: string;
    lastname: string;
    login: string;
    password: string;
    suspended: boolean;
    profils: Profil[];
}

class Profil {
    id: number;
    name: string;
}

class Priorite {
    id: number;
    libelle: string;
}

class Piece {
    id: number;
    libelle: string;
    qte: number;
    dateCreation: string;
}