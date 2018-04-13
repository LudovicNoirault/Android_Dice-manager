package com.example.horyon.dmshandydicemanager;

/**
 * Created by Horyon on 25/03/2018.
 */

public class Dice
{
    private int idDice =0;
    private int nbFace =0;
    private int result =0;

    public Dice(int idDice, int nbFace, int result)
    {
        this.idDice=idDice;
        this.nbFace=nbFace;
        this.result=result;
    }

    public int getIdDice()
    {
        return idDice;
    }

    public int getNbFace()
    {
        return nbFace;
    }

    public int getResult()
    {
        return result;
    }
}
