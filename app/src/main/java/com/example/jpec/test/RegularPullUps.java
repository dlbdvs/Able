package com.example.jpec.test;

/**
 * Created by jpec on 07/01/17.
 */

public class RegularPullUps extends Back {
    RegularPullUps(int nbseries, int nbreps) {
        super("RegularPullUps", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }


    RegularPullUps(int nbseries, int nbreps, double repos) {
        super("RegularPullUps", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut sans indication
    RegularPullUps(){
        super("RegularPullUps", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }


    //Constructeur FONTE
    RegularPullUps(int poids, int nbseries, int nbreps) {
        super("RegularPullUps",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
    }
    RegularPullUps(int poids, int nbseries, int nbreps, double repos) {
        super("RegularPullUps",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
        this.repos=repos;
    }
}
