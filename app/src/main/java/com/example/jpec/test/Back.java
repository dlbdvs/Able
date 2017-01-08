package com.example.jpec.test;

/**
 * Created by jpec on 07/01/17.
 */

public class Back extends Exercise {
    Back(String nom, boolean isPdc, int poids, int nbseries, int nbreps) {
        super("Back", nom, isPdc, poids, nbseries, nbreps);
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
        this.nbseries=nbseries;
        this.nbreps=nbreps;
    }

    Back(String nom, boolean isPdc, int poids) {
        super("Back", nom, isPdc, poids);
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
    }
}
