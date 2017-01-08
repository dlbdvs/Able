package com.example.jpec.test;

/**
 * Created by jpec on 02/01/17.
 */

public class WidePushUp extends Pec {
    //Constructeur avec indication rep et série
    WidePushUp(int nbseries, int nbreps) {
        super("Pike push ups", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    WidePushUp(int nbseries, int nbreps, double repos) {
        super("Pike push ups", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut
    WidePushUp(){
        super("Pike Push up", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }
}
