package com.example.jpec.test;

/**
 * Created by jpec on 24/12/16.
 */

public class SquatHold extends Leg {
    SquatHold(int nbseries, int nbreps) {
        super("Squat Hold", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    SquatHold(){
        super("Squat Hold", true, 0 );
    }
}
