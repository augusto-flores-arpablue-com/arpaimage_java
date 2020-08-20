/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.core;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author AugLaptop
 */
public abstract class IDraw implements ImageControl{
    protected float mWidth;
    protected float mHeight;
    protected float mX = 0.0f;
    protected float mY = 0.0f;
    public float getWidth(){ return mWidth; }
    public float getHeight(){ return mHeight; }
    protected void setWitdh( float width ){ mWidth = width; }
    protected void setHeight( float height){ mHeight = height; }
    public float getX(){ return mX; }
    public float getY(){ return mY; }
    public void process(){}
    public abstract void getImage(Graphics2D g);
    public static BufferedImage getTransparencyImage( int width, int height) {
        BufferedImage bimage = new BufferedImage(width, height,  BufferedImage.TYPE_BYTE_INDEXED);
        Graphics2D g2d = bimage.createGraphics();

        Color transparent = new Color(0, 0, 0, 0);
        g2d.setColor(transparent);
        g2d.setComposite(AlphaComposite.Src);
        g2d.fill(new Rectangle2D.Float(0, 0, width, height));
        g2d.dispose();
        return bimage;
    }
    
}
