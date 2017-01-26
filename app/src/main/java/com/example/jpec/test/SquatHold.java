package com.example.jpec.test;

/**
 * Created by jpec on 24/12/16.
 */

public class SquatHold extends Leg implements HoldExercise {
    SquatHold(int nbseries, int nbreps) {
        super("Squat Hold", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    SquatHold(int nbseries, int nbreps, double repos) {
        super("Squat Hold", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }
    SquatHold(){
        super("Squat Hold", true, 0 );
        this.nbreps=30;
        this.nbseries=3;
    }
}
