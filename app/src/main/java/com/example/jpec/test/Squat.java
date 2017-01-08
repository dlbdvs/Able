package com.example.jpec.test;

/**
 * Created by jpec on 24/12/16.
 */

public class Squat extends Leg {

    //Constructeur avec indication nb série et rép
    Squat(int nbseries, int nbreps) {
        super("Squat", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }


    Squat(int nbseries, int nbreps, double repos) {
        super("Squat", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut sans indication
    Squat(){
        super("Squat", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }


    //Constructeur FONTE
    Squat(int poids, int nbseries, int nbreps) {
        super("Squat",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
    }
    Squat(int poids, int nbseries, int nbreps, double repos) {
        super("Squat",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
        this.repos=repos;
    }

}
