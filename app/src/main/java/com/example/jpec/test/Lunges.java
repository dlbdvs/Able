package com.example.jpec.test;

/**
 * Created by jpec on 24/12/16.
 */

public class Lunges extends Leg {
    //Constructeur pdc
    Lunges(int nbseries, int nbreps) {
        super("Lunges", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    Lunges(int nbseries, int nbreps, double repos) {
        super("Lunges", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur fonte
    Lunges(int poids, int nbseries, int nbreps) {
        super("Lunges",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
    }
    Lunges(int poids, int nbseries, int nbreps, double repos) {
        super("Lunges",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
        this.repos=repos;
    }

    //Constructeur par défaut
    Lunges(){
        super("Lunges", true, 0 );
    }
}
