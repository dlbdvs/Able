package com.example.jpec.test;

import android.os.Parcel;
import android.os.Parcelable;



class Exercise implements Parcelable{
    /*Grace à cette implémentation, des exercices pourront être transmis de
    page en page avec les getExtra --> Les exos deviennent Parcelable
    */
    boolean isPdc;
    String nom;
    int nbreps;
    int nbseries;
    int poids;
    private String muscles;
    private int hold;
    double repos;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (this.isPdc ? 1 : 0));
        dest.writeString(this.nom);
        dest.writeInt(this.nbreps);
        dest.writeInt(this.nbseries);
        dest.writeInt(this.poids);
        dest.writeString(this.muscles);
        dest.writeInt(this.hold);
        dest.writeDouble(this.repos);

    }



    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };
    public Exercise(){

    }
//Attention, il faut bien respecter l'ordre dans lequel on définit les variables
    public Exercise(Parcel in) {
        this.isPdc=in.readByte() != 0;
        this.nom = in.readString();
        this.nbreps = in.readInt();
        this.nbseries = in.readInt();
        this.poids = in.readInt();
        this.muscles = in.readString();
        this.hold = in.readInt();
        this.repos = in.readDouble();
    }
//Fin de la mise en Parcelable

    //Permet d'ajuster le temps de repos de manière automatique suivant que l'exo soit au pdc ou non
    protected void defRest(){
        if (isPdc){
            repos=30;
        }
        else{
            repos=90;
        }
    }

    Exercise(String muscles, String nom, boolean isPdc, int poids, int nbseries, int nbreps, double repos){
        this.muscles=muscles;
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
        this.nbseries=nbseries;
        this.nbreps=nbreps;
        this.repos=repos;

    }


    Exercise(String muscles, String nom, boolean isPdc, int poids, int nbseries, int nbreps ){
        this.muscles=muscles;
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;
        this.nbseries=nbseries;
        this.nbreps=nbreps;
        defRest();

    }

    Exercise(String muscles, String nom, boolean isPdc, int poids){
        this.muscles=muscles;
        this.nom=nom;
        this.isPdc=isPdc;
        this.poids=poids;

        defRest();
     }
    @Override
    public String  toString(){
        return "Nom du héro : "+nom;
    }

    public boolean isPdc() {
        return isPdc;
    }

    public void setPdc(boolean pdc) {
        isPdc = pdc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbreps() {
        return nbreps;
    }

    public void setNbreps(int nbreps) {
        this.nbreps = nbreps;
    }

    public int getNbseries() {
        return nbseries;
    }

    public void setNbseries(int nbseries) {
        this.nbseries = nbseries;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getMuscles() {
        return muscles;
    }

    public void setMuscles(String muscles) {
        this.muscles = muscles;
    }

    public int getHold() {
        return hold;
    }

    public void setHold(int hold) {
        this.hold = hold;
    }

    public double getRepos() {
        return repos;
    }

    public void setRepos(double repos) {
        this.repos = repos;
    }


}
