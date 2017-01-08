package com.example.jpec.test;

/**
 * Created by jpec on 24/12/16.
 */

public class Leg extends Exercise {
    Leg(String nom, boolean isPdc, int poids, int nbseries, int nbreps) {
        super("Leg", nom, isPdc, poids, nbseries, nbreps);
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
        this.nbseries=nbseries;
        this.nbreps=nbreps;
    }

    Leg(String nom, boolean isPdc, int poids) {
        super("Leg", nom, isPdc, poids);
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
    }
}
