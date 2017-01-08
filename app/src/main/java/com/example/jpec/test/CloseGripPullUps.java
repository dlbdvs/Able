package com.example.jpec.test;

/**
 * Created by jpec on 07/01/17.
 */

public class CloseGripPullUps extends Back{
    CloseGripPullUps(int nbseries, int nbreps) {
        super("CloseGripPullUps", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }


    CloseGripPullUps(int nbseries, int nbreps, double repos) {
        super("CloseGripPullUps", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut sans indication
    CloseGripPullUps(){
        super("CloseGripPullUps", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }


    //Constructeur FONTE
    CloseGripPullUps(int poids, int nbseries, int nbreps) {
        super("CloseGripPullUps",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
    }
    CloseGripPullUps(int poids, int nbseries, int nbreps, double repos) {
        super("CloseGripPullUps",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
        this.repos=repos;
    }
}
