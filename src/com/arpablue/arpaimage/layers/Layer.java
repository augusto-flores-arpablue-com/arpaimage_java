/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.layers;

import com.arpablue.arpaimage.core.IDraw;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author AugLaptop
 */
public class Layer extends IDraw{
   protected BufferedImage mImg;
   public void setImage( BufferedImage img ){
       mImg = img;
   }
    @Override
    public void getImage(Graphics2D g) {
       
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
