/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.paintobj;

import com.arpablue.arpaimage.core.IDraw;
import java.awt.Graphics2D;

/**
 *
 * @author AugLaptop
 */
public class InteractiveSquare extends IDraw {

    protected float mX1;
    protected float mY1;
    protected boolean mbActive = false;
    protected GRect mRect;
    
    public InteractiveSquare() {
        mRect = new GRect();
        mX1 = 0;
        mY1 = 0;
        mbActive = false;
    }
    @Override
    public float getX(){
        if( mX < mX1){
            return mX;
        }
        return mX1;
    }
    @Override
    public float getY(){
        if( mY < mY1 ){
            return mY;
        }
        return mY1;
    }
    @Override
    public float getWidth(){
        float value = mX - mX1;
        if( value < 0.0f){
            value = value * -1;
        }
        return value;
    }
    public float getHeigth(){
        float value = mY - mY1;
        if( value < 0.0f){
            value = value * -1;
        }
        return value;
    }
    @Override 
    public boolean isActive(){
        return mbActive;
    }

    @Override
    public void getImage( Graphics2D g ) {
        if( !this.isActive()){
            return;
        }
        mRect.setGraphics(g);
        mRect.render();
    }

    @Override
    public void mouseClicked(int x, int y) {}
    @Override
    public void mousePressed(int x, int y) {
        mbActive = true;
        mRect.setPoint((float)x,(float) y);
        System.out.println("--Active: "+x+","+y);
    }
    @Override
    public void mouseReleased(int x, int y) {
        mbActive = false;
        mRect.setPoint2((float)x,(float) y);
        System.out.println("-- Inactive: "+x+","+y);
        
    }
    @Override
    public void mouseEntered(int x, int y)  {}
    @Override
    public void mouseExited(int x, int y)  {}
    @Override
    public void mouseDragged(int x, int y)  {
        mRect.setPoint2((float)x,(float) y);
    }
    @Override
    public void mouseMoved(int x, int y)  {}

}
