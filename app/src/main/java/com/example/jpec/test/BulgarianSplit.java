package com.example.jpec.test;

/**
 * Created by jpec on 24/12/16.
 */

public class BulgarianSplit extends Leg {

    //Constructeur avec nb série et rép
    BulgarianSplit(int nbseries, int nbreps) {
        super("Bulgarian Split", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
    }
    BulgarianSplit(int nbseries, int nbreps, double repos) {
        super("Bulgarian Split", true, 0, nbseries, nbreps);
        this.nbreps=nbreps;
        this.nbseries=nbseries;
        this.repos=repos;
    }

    //Constructeur par défaut sans indication
    BulgarianSplit(){
        super("Bulgarian Split", true, 0 );
        this.nbreps=20;
        this.nbseries=1;
    }
}