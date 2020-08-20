/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.layers;

import com.arpablue.arpaimage.core.IDraw;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * It contain the layers to produce the final image.
 * @author AugLaptop
 */
public class Layers extends IDraw{
    protected ArrayList<IDraw> mLayers;
    protected BufferedImage mImg;
    protected int mWidth = 400;
    protected int mHeight = 400;
    Color mTransparent = new Color(0, 0, 0, 0);
    
    public Layers(){
        mLayers = new ArrayList<IDraw>();
        mLayers.add(new Layer());
    }
    public void setWidth( int width ){
        mWidth = width;
    }
    public void setHeight( int height ){
        mHeight = height;
    }
    public void setSize( Dimension size ){
        setWidth( (int) size.getWidth() );
        setHeight( (int)size.getHeight() );
    }
    /**
     * It process the layers to return the image final image result.
     * @return It is the final image result of all layers.
     */
    @Override
    public void getImage(Graphics2D g){
        process();
        paint(g);
    }
    /**
     * It process all layers to get the final image.
     */
    public void process(){
        for( IDraw l: mLayers){
            l.process();
        }
    }
    protected BufferedImage createImage(){
        BufferedImage res = new BufferedImage(this.mWidth, this.mHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = res.createGraphics();
        g2d.setBackground(Color.CYAN);
        
        return res;
    }
    protected void paint(Graphics2D g){
        
        for( IDraw l: mLayers){
            l.getImage( g );
            
        }
    }

    public void add(IDraw layer) {
        if( layer == null ){
            return;
        }
        mLayers.add(layer);
    }
    public void add( BufferedImage img) {
        if( img == null ){
            return;
        }
        Layer layer = new Layer();
        
        layer.setImage( img );
        mLayers.add(layer);
    }
    public IDraw get(int index){
        if( mLayers == null ){
            return null;
        }
        if( index >= mLayers.size() ){
            return null;
        }
        return mLayers.get(index);
    }
    
    @Override
    public void mouseClicked(int x, int y) {}
    @Override
    public void mousePressed(int x, int y) {}
    @Override
    public void mouseReleased(int x, int y) {}
    @Override
    public void mouseEntered(int x, int y) {}
    @Override
    public void mouseExited(int x, int y) {}
    @Override
    public void mouseDragged(int x, int y) {}
    @Override
    public void mouseMoved(int x, int y) {}

    @Override
    public boolean isActive() {
        return true;
    }
            
}
