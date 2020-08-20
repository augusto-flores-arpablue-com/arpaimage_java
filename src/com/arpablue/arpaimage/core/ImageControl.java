/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.core;

/**
 *
 * @author AugLaptop
 */
public interface ImageControl {
    public boolean isActive();
    public void mouseClicked(int x, int y) ;
    public void mousePressed(int x, int y) ;
    public void mouseReleased(int x, int y) ;
    public void mouseEntered(int x, int y) ;
    public void mouseExited(int x, int y) ;
    public void mouseDragged(int x, int y) ;
    public void mouseMoved(int x, int y) ;

}
