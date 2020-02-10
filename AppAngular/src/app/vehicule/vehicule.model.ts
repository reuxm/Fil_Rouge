export class VehiculeModel {
    private id: number;
    public quantite: string;
    public modele: string;
    public prixHt: number;
    public dateCreation: Date;

    constructor(id: number, modele: string, quantite: string, prixHt: number= null, dateCreation: Date) {
        this.id = id;
        this.modele = modele;
        this.quantite = quantite;
        this.prixHt = prixHt;
        this.dateCreation = dateCreation;
    }
}
