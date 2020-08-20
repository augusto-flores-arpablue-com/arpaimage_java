/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.paintobj;

import java.awt.Graphics2D;

/**
 *
 * @author AugLaptop
 */
public class GRect extends GBase{

    protected float mX2,mY2;
    public void setPoint2( float x, float y){
        mX2 = x;
        mY2 = y;
    }
    @Override
    public void render(Graphics2D g) {
        if( g == null ){
            return;
        }
        int x1 = (int) mX;
        int y1 = (int) mY;
        int x2 = (int) mX2;
        int y2 = (int) mY2;
        
        mG.drawLine(x1,y1,x1,y2);
        mG.drawLine(x1,y2,x2,y2);
        mG.drawLine(x2,y2,x2,y1);
        mG.drawLine(x2,y1,x1,y1);
    }
    
}
