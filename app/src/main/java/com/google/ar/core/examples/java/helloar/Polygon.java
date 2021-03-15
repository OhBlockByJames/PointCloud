package com.google.ar.core.examples.java.helloar;

import com.google.ar.core.Pose;

import java.util.ArrayList;

public class Polygon {
    ArrayList<PlaneFeature> Points;
    int type;
    private Pose pose;
    public ArrayList<PlaneFeature> getPoints()
    {
        return Points;
    }
    public Polygon(int type)
    {
        this.type=type;
        Points=new ArrayList<>();
    }
//    public float[] getYAxis (){
//        float[] x;
//        x = new float[3];
//        return x;
//        }




    public void AddPoint(PlaneFeature point)
    {
        Points.add(point);
    }

    public int getType()
    {
        return type;
    }
}
