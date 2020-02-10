export class Devis{

    id : number;
    dateCreation: Date;
    etat: boolean;
    id_client: number;
    id_vehicule :number;
    id_user: number

    constructor(param) {
        this.id = param.id;
        this.dateCreation= param.dateCreation;
        this.etat=param.etat;
        this.id_client=param.id_client;
        this.id_user=param.id_user;
        this.id_vehicule=param.id_vehicule
    }
}