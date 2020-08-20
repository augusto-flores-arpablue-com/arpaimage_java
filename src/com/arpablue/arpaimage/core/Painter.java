/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.core;

import com.arpablue.arpaimage.layers.Layer;
import com.arpablue.arpaimage.layers.Layers;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author AugLaptop
 */
public class Painter {
    private static Layers ACTIVE_LAYER;
    private static Paralel RUNNER;
    
    
    public static BufferedImage createImage( int witdth, int height ){
        BufferedImage res = new BufferedImage( witdth, height, BufferedImage.TYPE_INT_RGB);
        return res;
    }
    public static Paralel getRunner(){
        if( RUNNER == null ){
            RUNNER = new Paralel();
            RUNNER.setDrawObject( getLayers() );
        }
        return RUNNER;
    }
    public static Layers getLayers(){
     if( ACTIVE_LAYER == null )   {
         ACTIVE_LAYER = new Layers();
     }
     return ACTIVE_LAYER;
    }
    public static void setComponent( Canvas canvas ){
       getRunner().setCanvas(canvas);
       
    }
    public static void setActiveLayers( Layers layers ){
        getRunner().setDrawObject(layers);
    }
    public static void start(){

        getRunner().start();
    }
    public static void stop(){
        getRunner().stop();
    }
    public void add(IDraw item){
     getLayers().add( item );
    }
    
    
}
