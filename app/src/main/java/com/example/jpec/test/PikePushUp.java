package com.example.jpec.test;

/**
 * Created by jpec on 23/12/16.
 */

public class PikePushUp extends Pec {

    //Constructeur avec indication rep et série
    PikePushUp(int nbseries, int nbreps) {
        super("Pike push ups", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    PikePushUp(int nbseries, int nbreps, double repos) {
        super("Pike push ups", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut
    PikePushUp(){
        super("Pike Push up", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }
}
