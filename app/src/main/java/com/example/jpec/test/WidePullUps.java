package com.example.jpec.test;

/**
 * Created by jpec on 07/01/17.
 */

public class WidePullUps extends Back {
    WidePullUps(int nbseries, int nbreps) {
        super("WidePullUps", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }


    WidePullUps(int nbseries, int nbreps, double repos) {
        super("WidePullUps", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut sans indication
    WidePullUps(){
        super("WidePullUps", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }


    //Constructeur FONTE
    WidePullUps(int poids, int nbseries, int nbreps) {
        super("WidePullUps",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
    }
    WidePullUps(int poids, int nbseries, int nbreps, double repos) {
        super("WidePullUps",false, poids, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.poids=poids;
        this.repos=repos;
    }
}
