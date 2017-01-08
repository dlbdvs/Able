package com.example.jpec.test;

/**
 * Created by jpec on 23/12/16.
 */

public class NarrowPushUp extends Pec {


    //Constructeur avec indication rép et série
    NarrowPushUp(int nbseries, int nbreps) {
        super("Narrow push ups", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    NarrowPushUp(int nbseries, int nbreps, double repos) {
        super("Narrow push ups", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut
    NarrowPushUp(){
        super("Narrow Push up", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }

}
