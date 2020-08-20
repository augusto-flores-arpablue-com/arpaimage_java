/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.core;

import com.arpablue.arpalib.game.Looper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author AugLaptop
 */
public class Paralel extends Looper {

    protected BufferedImage mImg;
    protected IDraw mDraw;
    protected double mWidth = 0;
    protected double mHeight = 0;

    public void setImage(BufferedImage img) {
        mImg = img;
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }

    public void setDrawObject(IDraw drawObj) {
        mDraw = drawObj;
    }

    @Override
    public void tick() {
        
        if (this.getCanvas() == null) {
            return;
        }
        
        getArea();
        if (mDraw != null) {
            ((Graphics2D) mImg.getGraphics()).setColor( Color.WHITE);
            ((Graphics2D) mImg.getGraphics()).fillRect(0, 0, mImg.getWidth(), mImg.getHeight());
            mDraw.getImage((Graphics2D) mImg.getGraphics());
        }

    }
    /**
     * It return a image with the size specified.
     * @param size It is the size of the image to be created.
     * @return It is the image width the size specified.
     */
    protected BufferedImage createImage( Dimension size ){
        return createImage( size.width, size.height );
    }
    protected BufferedImage createImage( int width, int height){
        mWidth = width;
        mHeight = height;
        BufferedImage bufferedImage = new BufferedImage( ((int)mWidth)+1, ((int)mHeight) +1, BufferedImage.TYPE_INT_RGB);
        return bufferedImage;
    }
    protected void getArea() {
        boolean flag =  false;
        
        if( mImg == null ){
            mImg = createImage(this.getCanvas().getSize());
        }
        if ( ( this.getCanvas().getSize().width != mWidth ) || (this.getCanvas().getSize().height != mHeight) ){
            mWidth = this.getCanvas().getSize().getWidth();
            mHeight = this.getCanvas().getSize().getHeight();
            mImg = createImage( this.getCanvas().getSize() );
        }
    }
    @Override
    public void render(Graphics2D g) {
        
        if (mImg != null) {
            g.drawImage(mImg, 0, 0, null);
        }
    }

}
