ALTER TABLE facture_fiche
ADD date_creation date;

ALTER TABLE commande_piece ADD etat BIT NOT NULL DEFAULT 0 ;
ALTER TABLE commande_vehicule ADD livre BIT NOT NULL DEFAULT 0 ;
