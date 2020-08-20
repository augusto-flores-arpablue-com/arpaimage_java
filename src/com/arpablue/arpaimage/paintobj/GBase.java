/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.paintobj;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author AugLaptop
 */
public abstract class GBase {
    protected float mX, mY;
    protected Graphics2D mG;
    protected Color mColor;
    public GBase(){
        mColor = new Color(0,255,0);
        
    }
    public void setGraphics( Graphics2D g){
        mG = g;
    }
    public void setPoint(float x, float y) {
        mX = x;
        mY = y;
    }
    public void render(){
        if( mG == null ){
            return;
        }
        Color current = mG.getColor();
        mG.setColor(mColor);
        render( mG );
        mG.setColor(current);
    }
    public abstract void render( Graphics2D g);
}
