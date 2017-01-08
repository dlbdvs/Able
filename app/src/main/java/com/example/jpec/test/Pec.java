package com.example.jpec.test;

/**
 * Created by jpec on 23/12/16.
 */

public class Pec extends Exercise {

    Pec(String nom, boolean isPdc, int poids, int nbseries, int nbreps) {
        super("Pectoraux", nom, isPdc, poids, nbseries, nbreps);
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
        this.nbseries=nbseries;
        this.nbreps=nbreps;
    }

    Pec(String nom, boolean isPdc, int poids) { //Dans la parenthèse : ce qu'il reste à définir
        super("Pectoraux", nom, isPdc, poids); //Ce que l'on définit
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
    }

}
